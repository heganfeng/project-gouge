package com.gouge.util;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by grandfen on 17/5/4.
 */
public class PageUtil {

    public final static Integer DEFAUL_PAGE_NO = 1;
    public final static Integer DEFAUL_PAGE_SIZE = 10;

    public final static String PAGE_INDEX_STR = "pageIndex";
    public final static String PAGE_SIZE_STR = "pageSize";


    public static String getClumn(String clumn){
        if(StringUtils.isBlank(clumn)){
            return "";
        }
        clumn=String.valueOf(clumn.charAt(0)).toUpperCase().concat(clumn.substring(1));
        StringBuffer sb = new StringBuffer();
        Pattern pattern=Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher=pattern.matcher(clumn);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(word.toUpperCase());
            sb.append(matcher.end()==clumn.length()?"":"_");
        }
        return sb.toString();
    }

    public static boolean isChange(String str){
        if(str == null){
            return true;
        }
        int i = 0;
        while(i < str.length()){
            char chr = str.charAt(i);
            if(Character.isUpperCase(chr)){
            }else if(Character.isLowerCase(chr)){
                return  false;
            }
            i++;
        }
        return true;
    }
}
