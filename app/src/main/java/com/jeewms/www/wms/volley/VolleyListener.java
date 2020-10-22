package com.jeewms.www.wms.volley;

import com.android.volley.Response;
import com.android.volley.Response.Listener;

public abstract class VolleyListener<T> implements Response.ErrorListener, Listener<T>{
    /** 访问成功或者失败都会调用此方法，可以在这里做progressBar的操作或者其他*/
    public abstract void requestComplete();
}
