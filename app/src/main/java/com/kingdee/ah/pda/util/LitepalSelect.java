package com.kingdee.ah.pda.util;

import org.litepal.LitePal;

import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.util
 * @ClassName: LitepalSelect
 * @Description: java类作用描述
 * 数据库查询
 * @Author: 作者名
 * @CreateDate: 2020/10/26 14:44
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/26 14:44
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class LitepalSelect {

    //十条查询
    public static<T> List<T> findByAll(Class<T> tClass,int offset){
        List<T> ts = LitePal.limit(10).offset(offset).find(tClass);
       return ts;
    }

    //查询 (指定字段)
    public static<T> List<T> findByAll(Class<T> tClass,int limit,int offset,String...strings){
        List<T> ts = LitePal.limit(limit).select(strings).offset(offset).find(tClass);
        return ts;
    }
    //查询 (指定字段)
    public static<T> List<T> findByAll(Class<T> tClass,int limit,int offset){
        List<T> ts = LitePal.limit(limit).offset(offset).find(tClass);
        return ts;
    }

    //模糊搜索
    public static<T> List<T> findByLike(Class<T> tClass,String fname){
        List<T> ts = LitePal.where("fname like ?", "%" + fname + "%").find(tClass);
        return ts;
    }
}
