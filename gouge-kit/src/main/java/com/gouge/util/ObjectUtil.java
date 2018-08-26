package com.gouge.util;

import java.lang.reflect.Method;

/**
 * Created by grandfen on 17/5/4.
 */
public class ObjectUtil {

    public static Integer getIntValue(Object obj,String cloumn,Integer defaulValue){
        cloumn = cloumn.substring(0, 1).toUpperCase() + cloumn.substring(1);
        try {
            Method m = obj.getClass().getMethod("get" + cloumn);
            if(m.invoke(obj) == null)
                return defaulValue;
            return Integer.parseInt(String.valueOf(m.invoke(obj)));
        } catch (Exception e) {
            e.printStackTrace();
            return defaulValue;
        }
    }

    public static Integer getPageNoIntValue(Object obj,String cloumn,Integer defaulValue){
        cloumn = cloumn.substring(0, 1).toUpperCase() + cloumn.substring(1);
        try {
            Method m = obj.getClass().getMethod("get" + cloumn);
            if(m.invoke(obj) == null){
                return defaulValue;
            }
            return Integer.parseInt(String.valueOf(m.invoke(obj))) + 1; //分页统一加一
        } catch (Exception e) {
            e.printStackTrace();
            return defaulValue;
        }
    }
}
