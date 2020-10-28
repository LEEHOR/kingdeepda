package com.jeewms.www.wms.volley;

/**
 * Copyright 2013 Ognyan Bankov
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.jeewms.www.wms.bean.UpdatePwd;
import com.jeewms.www.wms.constance.Shared;
import com.jeewms.www.wms.util.Logutil;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.util.ToastUtil;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Helper class that is used to provide references to initialized
 * RequestQueue(s) and ImageLoader(s)
 *
 * @author Ognyan Bankov
 */
public class HTTPUtils {
    private static RequestQueue mRequestQueue;
    //私有化属性
    private static HTTPUtils singleQueue;
    private RequestQueue requestQueue;
    private static Context context;

    //私有化构造
    private HTTPUtils(Context context) {
        this.context = context;
        requestQueue = getRequestQueue();
    }

    //提供获得请求队列的方法
    private RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    //提供获取类对象的方法
    public static synchronized HTTPUtils getInstance(Context context) {   //synchronized加锁防止并发
        if (singleQueue == null) {
            singleQueue = new HTTPUtils(context);
        }
        return singleQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
//        requestQueue.add(req);  //防止被回收造成空指针异常，所以一般不用
        getRequestQueue().add(req);
    }

    public static void init(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public void cleanerCathe() {
        requestQueue.getCache().clear();
    }

    /**
     * Json方式请求
     * @param url
     * @param tClass
     * @param params
     * @param listener
     * @param <T>
     */
    public <T> void postByJson( final String url, final Class<T> tClass, final Map<String, String> params, final VolleyListener<T> listener) {
        JSONObject jsonObject = new JSONObject(params);
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Method.POST, url, jsonObject, new Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Logutil.print("网络日志:成功" + response.toString());
                Gson gson = new GsonBuilder().serializeNulls().create();
                T t = gson.fromJson(String.valueOf(response), tClass);
                listener.onResponse(t);
                listener.requestComplete();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Logutil.print("网络日志:失败" + error.getMessage());
                listener.onErrorResponse(error);
                listener.requestComplete();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (!url.contains("login")) {
                    Map<String, String> params = new HashMap<>();
                    params.put("Authorization", SharedPreferencesUtil.getInstance(context).getKeyValue(Shared.TOKEN));
                    return params;
                } else {
                    return super.getHeaders();
                }
            }
        };
//        if (mRequestQueue == null) {
//            init(context);
//        }
        try {
            Logutil.print("网络日志", "\n[\n" + jsonRequest.getBodyContentType() + "\n" + jsonRequest.getHeaders().toString() + "\n" + jsonRequest.getUrl() + "\n" + "POST" + "\n" + jsonObject.toString() + "\n]");
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
        addToRequestQueue(jsonRequest);
    }

    /**
     * Json方式请求
     * Gson 方式
     *
     * @param <T>
     * @param url
     * @param tClass
     * @param jsonObject
     * @param listener
     */
    public <T> void postByJson( final String url, final Class<T> tClass, JsonObject jsonObject, final VolleyListener<T> listener) {
        com.jeewms.www.wms.volley.JsonObjectRequest jsonObjectRequest = new com.jeewms.www.wms.volley.JsonObjectRequest(Method.POST, url, jsonObject, new Listener<JsonObject>() {
            @Override
            public void onResponse(JsonObject response) {
                Logutil.print("网络日志:成功" + response.toString());
                Gson gson = new GsonBuilder().serializeNulls().create();
                T t = gson.fromJson(response, tClass);
                listener.onResponse(t);
                listener.requestComplete();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Logutil.print("网络日志:失败" + error.getMessage());
                listener.onErrorResponse(error);
                listener.requestComplete();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (!url.contains("login")) {
                    Map<String, String> params = new HashMap<>();
                    params.put("Authorization", SharedPreferencesUtil.getInstance(context).getKeyValue(Shared.TOKEN));
                    return params;
                } else {
                    return super.getHeaders();
                }
            }
        };
//        if (mRequestQueue == null) {
//            init(context);
//        }
        try {
            Logutil.print("网络日志", "\n[\n" + jsonObjectRequest.getBodyContentType() + "\n" + jsonObjectRequest.getHeaders().toString() + "\n" + jsonObjectRequest.getUrl() + "\n" + "POST" + "\n" + jsonObject.toString() + "\n]");
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
        // mRequestQueue.add(jsonObjectRequest);
        addToRequestQueue(jsonObjectRequest);
    }


    /**
     * Json方式请求
     * org.gson
     *
     * @param <T>
     * @param url
     * @param tClass
     * @param jsonObject
     * @param listener
     */
    public <T> void postByJson( final String url, final Class<T> tClass, JSONObject jsonObject, final VolleyListener<T> listener) {
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Method.POST, url, jsonObject, new Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Logutil.print("网络日志:成功" + response.toString());
                Gson gson = new GsonBuilder().serializeNulls().create();
                T t = gson.fromJson(String.valueOf(response), tClass);
                listener.onResponse(t);
                listener.requestComplete();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Logutil.print("网络日志:失败" + error.getMessage());
                listener.onErrorResponse(error);
                listener.requestComplete();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (!url.contains("login")) {
                    Map<String, String> params = new HashMap<>();
                    params.put("Authorization", SharedPreferencesUtil.getInstance(context).getKeyValue(Shared.TOKEN));
                    return params;
                } else {
                    return super.getHeaders();
                }
            }
        };
//        if (mRequestQueue == null) {
//            init(context);
//        }
        try {
            Logutil.print("网络日志", "\n[\n" + jsonRequest.getBodyContentType() + "\n" + jsonRequest.getHeaders().toString() + "\n" + jsonRequest.getUrl() + "\n" + "POST" + "\n" + jsonObject.toString() + "\n]");
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
        // mRequestQueue.add(jsonRequest);
        addToRequestQueue(jsonRequest);
    }


    //JSON解析
    public <T> void postJson( final String url, Class<T> clazz, final Map<String, String> params, final VolleyListener<T> listener) {
        GsonRequest<T> gsonRequest = new GsonRequest<T>(Method.POST, url, clazz, new Listener<T>() {
            @Override
            public void onResponse(T response) {
                Logutil.print("网络日志:成功" + response.toString());
                listener.onResponse(response);
                listener.requestComplete();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Logutil.print("网络日志:错误" + error.getMessage());
                ToastUtil.show(context, error.getMessage() == null ? "网络连接错误" : error.getMessage());
                listener.onErrorResponse(error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (!url.contains("login")) {
                    Map<String, String> params = new HashMap<>();
                    params.put("Authorization", SharedPreferencesUtil.getInstance(context).getKeyValue(Shared.TOKEN));
                    return params;
                } else {
                    return super.getHeaders();
                }
            }
        };
        try {
            Logutil.print("网络日志", "\n[\n" + gsonRequest.getBodyContentType() + "\n" + gsonRequest.getHeaders().toString() + "\n" + gsonRequest.getUrl() + "\n" + gsonRequest.getMethod() + "\n" + params.toString() + "\n]");
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
//        if (mRequestQueue == null) {
//            init(context);
//        }
        // mRequestQueue.add(gsonRequest);
        addToRequestQueue(gsonRequest);
    }

    public void post( final String url, final Map<String, String> params, final VolleyListener<String> listener) {
        StringRequest myReq = new UTFStringRequest(Method.POST, url, new Listener<String>() {
            public void onResponse(String response) {
                if (response.contains("<!DOCTYPE")) {
                    listener.onErrorResponse(new VolleyError());
                    return;
                }
                Logutil.print("网络日志:成功" + response);
                listener.onResponse(response);
                listener.requestComplete();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Logutil.print("网络日志:错误" + error.getMessage());
                ToastUtil.show(context, error.getMessage() == null ? "网络连接错误" : error.getMessage());
                listener.onErrorResponse(error);
                listener.requestComplete();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (!url.contains("login")) {
                    Map<String, String> params = new HashMap<>();
                    params.put("Authorization", SharedPreferencesUtil.getInstance(context).getKeyValue(Shared.TOKEN));
                    return params;
                } else {
                    return super.getHeaders();
                }

            }
        };
//        if (mRequestQueue == null) {
//            init(context);
//        }

        // 请用缓存
        //myReq.setShouldCache(true);
        // 设置缓存时间10分钟
        // myReq.setCacheTime(10*60);
        try {
            Logutil.print("网络日志", "\n[\n" + myReq.getBodyContentType() + "\n" + myReq.getHeaders().toString() + "\n" + myReq.getUrl() + "\n" + myReq.getMethod() + "\n" + params.toString() + "\n]");
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
        addToRequestQueue(myReq);

    }

    public void get(final String url,
                    final VolleyListener<String> listener) {
        StringRequest myReq = new UTFStringRequest(Method.GET, url, new Listener<String>() {
            public void onResponse(String response) {
                if (response.contains("<!DOCTYPE")) {
                    listener.onErrorResponse(new VolleyError());
                    listener.requestComplete();
                    return;
                }
                Logutil.print("网络日志:成功" + response);
                listener.onResponse(response);
                listener.requestComplete();
            }


        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                // Log.d("网络日志",error.getMessage());
                Logutil.print("网络日志:错误" + error.getMessage());
                ToastUtil.show(context, error.getMessage() == null ? "网络连接错误" : error.getMessage());
                listener.onErrorResponse(error);
                listener.requestComplete();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (!url.contains("login")) {
                    Map<String, String> params = new HashMap<>();
                    params.put("Content-Type", "application/json");
                    params.put("Authorization", SharedPreferencesUtil.getInstance(context).getKeyValue(Shared.TOKEN));
                    return params;
                } else {
                    return super.getHeaders();
                }

            }
        };
//        if (mRequestQueue == null) {
//            init(context);
//        }
        try {
            Logutil.print("网络日志", "\n[\n" + myReq.getBodyContentType() + "\n" + myReq.getHeaders().toString() + "\n" + myReq.getUrl() + "\n" + myReq.getMethod() + "\n]");
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
        // mRequestQueue.add(myReq);
        addToRequestQueue(myReq);

    }

    public void get(final String url, final Map<String, String> params,
                    final VolleyListener<String> listener) {
        StringRequest myReq = new UTFStringRequest(Method.GET, url, new Listener<String>() {
            public void onResponse(String response) {
                if (response.contains("<!DOCTYPE")) {
                    listener.onErrorResponse(new VolleyError());
                    listener.requestComplete();
                    return;
                }
                Logutil.print("网络日志:成功" + response);
                listener.onResponse(response);
                listener.requestComplete();
            }


        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                // Log.d("网络日志",error.getMessage());
                Logutil.print("网络日志:错误" + error.getMessage());
                ToastUtil.show(context, error.getMessage() == null ? "网络连接错误" : error.getMessage());
                listener.onErrorResponse(error);
                listener.requestComplete();
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (!url.contains("login")) {
                    Map<String, String> params = new HashMap<>();
                    params.put("Content-Type", "application/json");
                    params.put("Authorization", SharedPreferencesUtil.getInstance(context).getKeyValue(Shared.TOKEN));
                    return params;
                } else {
                    return super.getHeaders();
                }

            }
        };
//        if (mRequestQueue == null) {
//            init(context);
//        }
        try {
            Logutil.print("网络日志", "\n[\n" + myReq.getBodyContentType() + "\n" + myReq.getHeaders().toString() + "\n" + myReq.getUrl() + "\n" + myReq.getMethod() + "\n]");
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
        //  mRequestQueue.add(myReq);
        addToRequestQueue(myReq);
    }

}
