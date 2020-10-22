package com.jeewms.www.wms.util;

import java.util.UUID;

/**
 * Created by 13799 on 2018/6/13.
 */

public class UUIDUtil {
    public static String getUUID32(){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }
}
