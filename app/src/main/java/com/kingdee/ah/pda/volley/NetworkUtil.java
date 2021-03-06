package com.kingdee.ah.pda.volley;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.kingdee.ah.pda.App;
import com.kingdee.ah.pda.constance.Shared;
import com.kingdee.ah.pda.util.Logutil;
import com.kingdee.ah.pda.util.SharedPreferencesUtil;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.volley
 * @ClassName: NetworkUtil
 * @Description: java类作用描述
 * @Author: 李浩
 * @CreateDate: 2020/11/6 12:43
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/6 12:43
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class NetworkUtil {
    public static final int SUCCESS = 1001;
    public static final int FAILURE = 1002;
    public static final int COMPLETE = 1003;
    private static NetworkUtil instance;

    //单例获取工具类
    public static NetworkUtil getInstance() {
        if (instance == null) {
            synchronized (NetworkUtil.class) {
                if (instance == null) {
                    instance = new NetworkUtil();
                }
            }
        }
        return instance;
    }

    //获取请求队列
    private RequestQueue mRequestQueue = App.sRequestQueue;

    /**
     * Json方式请求
     * org.json
     *
     * @param activity
     * @param url
     * @param tClass
     * @param params
     * @param listener
     * @param <T>
     */
    public <T> void postByJson(final Activity activity, final String url, final Class<T> tClass, Map<String, String> params, final VolleyListener<T> listener) {
        JSONObject jsonObject = new JSONObject(params);
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                VolleyLog.v("网络日志::成功:%s",response.toString());
                Gson gson = new GsonBuilder().serializeNulls().create();
                T t = gson.fromJson(String.valueOf(response), tClass);
                listener.onResponse(t);
                listener.requestComplete();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handlerErrorMessage(activity,error);
                listener.onErrorResponse(error);
                listener.requestComplete();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                App.sRequestQueue.stop();
                if (!url.contains("login")) {
                    Map<String, String> params = new HashMap<>();
                    params.put("Authorization", SharedPreferencesUtil.getInstance(activity).getKeyValue(Shared.TOKEN));
                    return params;
                } else {
                    return super.getHeaders();
                }
            }
        };
        try {
            VolleyLog.v("\n[\n%s\n%s\n%s\nPOST\n%s\n]",jsonRequest.getBodyContentType(),
                    jsonRequest.getHeaders().toString(), jsonRequest.getUrl(),jsonObject.toString());
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
        jsonRequest.setTag(activity.getClass().getName());
        mRequestQueue.add(jsonRequest);
    }


    /**
     * Json方式请求
     * org.json
     *
     * @param activity
     * @param url
     * @param tClass
     * @param jsonObject
     * @param listener
     * @param <T>
     */
    public <T> void postByJson(final Activity activity, final String url, final Class<T> tClass, JSONObject jsonObject, final VolleyListener<T> listener) {
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                VolleyLog.v("网络日志::成功:%s",response.toString());
                Gson gson = new GsonBuilder().serializeNulls().create();
                T t = gson.fromJson(String.valueOf(response), tClass);
                listener.onResponse(t);
                listener.requestComplete();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handlerErrorMessage(activity,error);
                listener.onErrorResponse(error);
                listener.requestComplete();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (!url.contains("login")) {
                    Map<String, String> params = new HashMap<>();
                    params.put("Authorization", SharedPreferencesUtil.getInstance(activity).getKeyValue(Shared.TOKEN));
                    return params;
                } else {
                    return super.getHeaders();
                }
            }
        };
        try {
            VolleyLog.v("\n[\n%s\n%s\n%s\nPOST\n%s\n]",jsonRequest.getBodyContentType(),
                    jsonRequest.getHeaders().toString(), jsonRequest.getUrl(),jsonObject.toString());
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
        jsonRequest.setTag(activity.getClass().getName());
        mRequestQueue.add(jsonRequest);
        //addToRequestQueue(jsonRequest);
    }


    /**
     * Json方式请求
     * google.gson方式
     *
     * @param <T>
     * @param url
     * @param tClass
     * @param jsonObject
     * @param listener
     */
    public <T> void postByJson(final Activity activity, final String url, final Class<T> tClass, JsonObject jsonObject, final VolleyListener<T> listener) {
        com.kingdee.ah.pda.volley.JsonObjectRequest jsonObjectRequest = new com.kingdee.ah.pda.volley.JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JsonObject>() {
            @Override
            public void onResponse(JsonObject response) {
                VolleyLog.v("网络日志::成功:%s",response.toString());
                Gson gson = new GsonBuilder().serializeNulls().create();
                T t = gson.fromJson(response, tClass);
                listener.onResponse(t);
                listener.requestComplete();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handlerErrorMessage(activity,error);
                listener.onErrorResponse(error);
                listener.requestComplete();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (!url.contains("login")) {
                    Map<String, String> params = new HashMap<>();
                    params.put("Authorization", SharedPreferencesUtil.getInstance(activity).getKeyValue(Shared.TOKEN));
                    return params;
                } else {
                    return super.getHeaders();
                }
            }
        };
        try {
            VolleyLog.v("\n[\n%s\n%s\n%s\nPOST\n%s\n]",jsonObjectRequest.getBodyContentType(),
                    jsonObjectRequest.getHeaders().toString(), jsonObjectRequest.getUrl(),jsonObject.toString());
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
        jsonObjectRequest.setTag(activity.getClass().getName());
        mRequestQueue.add(jsonObjectRequest);
        //  mRequestQueue(jsonObjectRequest);
    }


    /**
     * post请求 map
     * 解析
     * @param activity
     * @param url
     * @param clazz
     * @param params
     * @param listener
     * @param <T>
     */
    public <T> void postJson(final Activity activity, final String url, Class<T> clazz, final Map<String, String> params, final VolleyListener<T> listener) {
        GsonRequest<T> gsonRequest = new GsonRequest<T>(Request.Method.POST, url, clazz, new Response.Listener<T>() {
            @Override
            public void onResponse(T response) {
                VolleyLog.v("网络日志::成功:%s",response.toString());
                listener.onResponse(response);
                listener.requestComplete();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handlerErrorMessage(activity,error);
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
                    params.put("Authorization", SharedPreferencesUtil.getInstance(activity).getKeyValue(Shared.TOKEN));
                    return params;
                } else {
                    return super.getHeaders();
                }
            }
        };
        try {
            VolleyLog.v("\n[\n%s\n%s\n%s\nPOST\n%s\n]",gsonRequest.getBodyContentType(),
                    gsonRequest.getHeaders().toString(), gsonRequest.getUrl(),params.toString());
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
        gsonRequest.setTag(activity.getClass().getName());
        mRequestQueue.add(gsonRequest);
    }


    /**
     * post请求 map
     * @param activity
     * @param url
     * @param params
     * @param listener
     */
    public void post(final Activity activity, final String url, final Map<String, String> params, final VolleyListener<String> listener) {
        StringRequest myReq = new UTFStringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            public void onResponse(String response) {
                if (response.contains("<!DOCTYPE")) {
                    handlerErrorMessage(activity,new VolleyError());
                    listener.onErrorResponse(new VolleyError());
                    listener.requestComplete();
                    return;
                }
                VolleyLog.v("网络日志::成功:%s",response);
                listener.onResponse(response);
                listener.requestComplete();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                handlerErrorMessage(activity,error);
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
                    params.put("Authorization", SharedPreferencesUtil.getInstance(activity).getKeyValue(Shared.TOKEN));
                    return params;
                } else {
                    return super.getHeaders();
                }

            }
        };
        try {
            VolleyLog.v("\n[\n%s\n%s\n%s\nPOST\n%s\n]",myReq.getBodyContentType(),
                    myReq.getHeaders().toString(), myReq.getUrl(),params.toString());
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
        myReq.setTag(activity.getClass().getName());
        mRequestQueue.add(myReq);

    }


    /**
     * get请求 string
     * @param activity
     * @param url
     * @param listener
     */
    public void get(final Activity activity, final String url,
                    final VolleyListener<String> listener) {
        StringRequest myReq = new UTFStringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            public void onResponse(String response) {
                if (response.contains("<!DOCTYPE")) {
                    handlerErrorMessage(activity,new VolleyError());
                    listener.onErrorResponse(new VolleyError());
                    listener.requestComplete();
                    return;
                }
                VolleyLog.v("网络日志::成功:%s",response.toString());
                listener.onResponse(response);
                listener.requestComplete();
            }


        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                handlerErrorMessage(activity,error);
                listener.onErrorResponse(error);
                listener.requestComplete();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (!url.contains("login")) {
                    Map<String, String> params = new HashMap<>();
                    params.put("Content-Type", "application/json");
                    params.put("Authorization", SharedPreferencesUtil.getInstance(activity).getKeyValue(Shared.TOKEN));
                    return params;
                } else {
                    return super.getHeaders();
                }

            }
        };
        try {
            VolleyLog.v("\n[\n%s\n%s\n%s\nGET\n]",myReq.getBodyContentType(),
                    myReq.getHeaders().toString(), myReq.getUrl());
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
        myReq.setTag(activity.getClass().getName());
        mRequestQueue.add(myReq);

    }


    /**
     * get请求 map
     * @param activity
     * @param url
     * @param params
     * @param listener
     */
    public void get(final Activity activity, final String url, final Map<String, String> params,
                    final VolleyListener<String> listener) {
        StringRequest myReq = new UTFStringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            public void onResponse(String response) {
                if (response.contains("<!DOCTYPE")) {
                    handlerErrorMessage(activity,new VolleyError());
                    listener.onErrorResponse(new VolleyError());
                    listener.requestComplete();
                    return;
                }
                VolleyLog.v("网络日志::成功:%s",response.toString());
                listener.onResponse(response);
                listener.requestComplete();
            }


        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                handlerErrorMessage(activity,error);
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
                    params.put("Authorization", SharedPreferencesUtil.getInstance(activity).getKeyValue(Shared.TOKEN));
                    return params;
                } else {
                    return super.getHeaders();
                }

            }
        };
        try {
            VolleyLog.v("\n[\n%s\n%s\n%s\nGET\n]",myReq.getBodyContentType(),
                    myReq.getHeaders().toString(), myReq.getUrl());
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
        myReq.setTag(activity.getClass().getName());
        mRequestQueue.add(myReq);
    }


    private void handlerErrorMessage(Activity context, VolleyError error) {
        if (error instanceof NetworkError) {
            showToast(context, "网络链接异常");
        } else if (error instanceof TimeoutError) {
            showToast(context, "连接超时");
        } else if (error instanceof AuthFailureError) {
            showToast(context, "身份验证失败！");
        } else if (error instanceof ParseError) {
            showToast(context, "解析错误！");
        } else if (error instanceof ServerError) {
            showToast(context, "服务器响应错误！");
        } else {
            showToast(context, error.toString());
        }
        VolleyLog.v("网络日志::错误:%s",error.toString());
    }

    private void showToast(Activity context, String str) {
        if (!context.isFinishing()) {
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
        }
    }

}
