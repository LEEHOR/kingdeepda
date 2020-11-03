package com.kingdee.ah.pda.util;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

public final class GsonUtils {

    public static Context context;

    /**
     * @param json
     * @param clazz
     * @param <T>
     * @return
     * @throws JsonSyntaxException
     */
    public static <T> T parseJSON(String json, Class<T> clazz) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        T info = null;
        try {
            info = gson.fromJson(json, clazz);
        } catch (JsonSyntaxException e) {
//			if (context != null) MobclickAgent.reportError(context, e+" \r\n，返回内容为："+json);
        }
        return info;
    }

    /**
     * Type type = new TypeToken&lt;ArrayList&lt;TypeInfo>>(){}.getType();
     * Type所在的包：java.lang.reflect
     * TypeToken所在的包：com.google.gson.reflect.TypeToken
     *
     * @param jsonArr
     * @param type
     * @return
     * @throws JsonSyntaxException
     */
    public static <T> T parseJSONArray(String jsonArr, Type type) throws JsonSyntaxException {
        Gson gson = new GsonBuilder().serializeNulls().create();
        T infos = gson.fromJson(jsonArr, type);
        return infos;
    }

    public static <T> JsonObject parseJsonObject(T tClass) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		return gson.toJsonTree(tClass).getAsJsonObject();
	}
}
