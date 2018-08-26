
package com.gouge.kit.string;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kame on 15/12/9.
 */
public abstract class StringKit {

    public static final boolean isEmpty(String str){
        return str == null || str.length() == 0;
    }

    public static final boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    public static final boolean isBlank(String str){
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }

        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;

    }

    public static final boolean isNotBlank(String str){
        return !isBlank(str);
    }

    public static String upperFirst(String name){
        if(isBlank(name))
            return "";

        byte[] items = name.getBytes();
        items[0] =  (byte)((char)items[0]-'a'+'A');
        return new String(items);
    }

    public static final String lowerFirst(String name){
        if(isBlank(name))
            return "";

        char[] chars = new char[1];
        chars[0] = name.charAt(0);
        String temp = new String(chars);
        if(chars[0]>='A' && chars[0]<='Z')
            return name.replaceFirst(temp,temp.toLowerCase());

        return name;
    }

    public static String[] split(String str, String split){
        if(isBlank(str))
            return new String[0];

        return str.split(split);
    }

    public static boolean isChineseCharacter(String str){
        if(isBlank(str))
            return false;
        int len = str.length();
        for(int i = 0; i < len; i ++){
            if(str.substring(i, i + 1).matches("[\u4e00-\u9fa5]+"))
                return true;
        }
        return false;
    }

    public static boolean isChar(String s){
        if(isBlank(s))
            return true;
        Pattern p = Pattern.compile("^[\\w]+$");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    public static boolean isMobile(String str){
        if(isBlank(str))
            return false;
        return str.matches("^(13|14|15|18)\\d{9}$");
    }

    public static boolean isNumeric(String str){
        if(str == null)
            return false;
        return str.matches("\\d+");
    }

    public static boolean isNotNumeric(String str){
        return !isNumeric(str);
    }

    public static boolean isDouble(String str){
        if(str == null)
            return false;

        return str.matches("\\d+\\.\\d+");
    }

    public static boolean isNotDouble(String str){
        return !isDouble(str);
    }

    public static final String evalString(Map<String, Object> params, String template){
        if(isBlank(template))
            return "";

        if (params != null && params.size() > 0) {
            for(String key : params.keySet()){
                String value = params.get(key) != null ? params.get(key).toString() : "";
                template = template.replace(
                        "${" + key + "}",  value);
            }
        }
        return template;
    }

    public static final String getSafeSQL(String str){
        //TODO:
        str = str.replace(";", "；");
        str = str.replace("'", "");
        return str;
    }

    public static final String null2str(String str){
        return (str == null ? "" : str);
    }

    public static final String safeStr(String str){
        return str;
    }

    public static String formatQueryName(Class<?> clazz, String suffix){
        String str = clazz.getName();
        str = str.substring(0, str.lastIndexOf(".") + 1);
        return str.concat(suffix);
    }

    public static String getNamespace(Class<?> clazz){
        String str = clazz.getName();
        str = str.substring(0, str.lastIndexOf("."));
        return str;
    }
    public static boolean isAllEmpty(String[] args){
        if(args == null)
            return true;
        if(args.length == 0)
            return true;
        for(int i = 0; i < args.length; i ++){
            if(!isEmpty(args[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("---" + isDouble("aa"));
        System.out.println(formatQueryName(StringKit.class, "create"));
    }
}
