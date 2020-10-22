package com.jeewms.www.wms.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 13799 on 2018/6/2.
 */

public class StringUtil {

    public static boolean isEmpty(String value) {
        return (value == null) || (value.trim().length() == 0);
    }


    public static boolean istruePhoneNum(String phoneNum) {
        Pattern pattern = Pattern.compile("^[1][345789][0-9]{9}$");
        Matcher matcher = pattern.matcher(phoneNum);
        if (phoneNum == null || "".equals(phoneNum)
                || matcher.matches() == false) {

            return false;
        } else {
            return true;
        }
    }
//
//    public static String MD5(String password) {
//        return MD5.getMessageDigest(password.getBytes());
//    }

    public static String subZeroAndDot(String s) {
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        if (s.indexOf(".") > 2) {
            if (isDouble(s)) {
                double f = Double.valueOf(s);
                s = String.format("%.2f", f);
            }
        }
        return s;
    }

    public static String subZeroAndDot(double s1) {
        String s = s1 + "";
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        if (s.indexOf(".") > 2) {
            if (isDouble(s)) {
                double f = Double.valueOf(s);
                s = String.format("%.2f", f);
            }
        }
        return s;
    }

    //控制小数点后有几位
    public static String subZeroAndDot(double x, int dig) {
        NumberFormat ddf1 = NumberFormat.getNumberInstance();
        ddf1.setMaximumFractionDigits(dig);
        String str = ddf1.format(x).replace(",", "");
        return str;
    }

    //判断浮点数（double和float）

    public static boolean isDouble(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(str).matches();

    }


    /**
     * 获取本地软件版本号名称
     */
    public static String getLocalVersionName(Context ctx) {
        String localVersion = "";
        try {
            PackageInfo packageInfo = ctx.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), 0);
            localVersion = packageInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }

    /**
     * 获取本地软件版本号名称
     */
    public static int getLocalVersionCord(Context ctx) {
        int localVersion = 0;
        try {
            PackageInfo packageInfo = ctx.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), 0);
            localVersion = packageInfo.versionCode;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }

    public static void getTime() {
        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createdate = sdf.format(date);
    }

    public static String getdata() {
        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取String类型的时间
        String createdate = sdf.format(date);
        return createdate;
    }

    public static Date str2time(String time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(time);
            return date;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 秒转化为天小时分秒字符串
     *
     * @param seconds
     * @return String
     */

    public static String formatSeconds(long seconds) {

        String timeStr = seconds + "秒";

        if (seconds > 60) {

            long second = seconds % 60;

            long min = seconds / 60;

            timeStr = min + "分" + second + "秒";

            if (min > 60) {

                min = (seconds / 60) % 60;

                long hour = (seconds / 60) / 60;

                timeStr = hour + "小时" + min + "分" + second + "秒";

                if (hour > 24) {

                    hour = ((seconds / 60) / 60) % 24;

                    long day = (((seconds / 60) / 60) / 24);

                    timeStr = day + "天" + hour + "小时" + min + "分" + second + "秒";

                }

            }

        }

        return timeStr;

    }
    //科学计数法转double

    /**
     * BigDecimal的测试，要精确。
     * 还要使得科学计数法的数字，做完全的展示。
     */
    private static void testBigDecimal() {
        Double d = 1.6D;
        //不准确的初始化
        BigDecimal bigDecimal = new BigDecimal(d);
        System.out.println(bigDecimal);

        //使得结果精确的初始化姿势
        bigDecimal = new BigDecimal(d.toString());
        System.out.println(bigDecimal);

        bigDecimal = new BigDecimal("6.214822313132341212666E+18");
        System.out.println(bigDecimal.toPlainString());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String convertDate(String strDate) {
        String str = "";
        try {
            String fmt = "yyyy-MM-dd HH:mm:ss";
            strDate = strDate.replace("T", " ");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(fmt);
            return dateTimeFormatter.format(dateTimeFormatter.parse(strDate));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return str;

    }
}
