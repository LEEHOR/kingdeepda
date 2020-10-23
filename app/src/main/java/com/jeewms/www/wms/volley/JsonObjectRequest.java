package com.jeewms.www.wms.volley;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.volley
 * @ClassName: JsonObjectRequest
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/23 17:18
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 17:18
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class JsonObjectRequest extends JsonRequest<JsonObject> {
    public JsonObjectRequest(int method, String url, JsonObject jsonRequest, Response.Listener<JsonObject> listener
            , Response.ErrorListener errorListener) {
        super(method, url, (jsonRequest == null) ? null : jsonRequest.toString(), listener,
                errorListener);
    }

    @Override
    protected Response<JsonObject> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));
            return Response.success(new JsonParser().parse(jsonString).getAsJsonObject(),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }
}
