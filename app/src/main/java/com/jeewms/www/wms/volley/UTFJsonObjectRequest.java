package com.jeewms.www.wms.volley;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.volley
 * @ClassName: UTFJsonObjectRequest
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/14 13:31
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/14 13:31
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class UTFJsonObjectRequest extends JsonObjectRequest {


    public UTFJsonObjectRequest(int method, String url, JSONObject jsonRequest, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        return super.parseNetworkResponse(response);
    }
}
