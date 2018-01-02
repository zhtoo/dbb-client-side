package com.hs.dbbclientside.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.hs.dbbclientside.MyApplication;

import java.util.Map;
import java.util.Set;

/**
 * 作者：zhanghaitao on 2018/1/2 15:32
 * 邮箱：820159571@qq.com
 *
 * @describe:SharePreference工具类
 */

public class SPUtil {

    private SharedPreferences sp;
    /**
     * 上下文
     */
    private Context context;
    /**
     * 保存在手机里面的文件名
     */
    private final static String SP_NAME ="";// BaseParams.SP_NAME;

    private SPUtil() {
        context = MyApplication.getContext();
        sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    public static SPUtil getInstance() {
        return SPUtilInstance.instance;
    }

    private static class SPUtilInstance {
        static SPUtil instance = new SPUtil();
    }

    private SharedPreferences getSp() {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        return sp;
    }

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param key
     *         键值对的key
     * @param value
     *         键值对的值
     *
     * @return 是否保存成功
     */
    public static boolean setValue(String key, Object value) {
        SharedPreferences.Editor edit = SPUtil.getInstance().getSp().edit();

        if (value instanceof String) {
            return edit.putString(key, (String) value).commit();
        } else if (value instanceof Boolean) {
            return edit.putBoolean(key, (Boolean) value).commit();
        } else if (value instanceof Float) {
            return edit.putFloat(key, (Float) value).commit();
        } else if (value instanceof Integer) {
            return edit.putInt(key, (Integer) value).commit();
        } else if (value instanceof Long) {
            return edit.putLong(key, (Long) value).commit();
        } else if (value instanceof Set) {
            throw new IllegalArgumentException("Value can not be Set object!");
        }
        return false;
    }

    public static Object getValue(String key) {
        Map<String, ?> map = getAll();
        if (contains(key)) {
            return map.get(key);
        }
        return null;
    }

    @SuppressLint("NewApi")
    public static Boolean checkEmpty(String string) {
        if (string == null || string.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 得到Boolean类型的值
     */
    public static boolean getBoolean(String key, boolean defaultValue) {
        return SPUtil.getInstance().getSp().getBoolean(key, defaultValue);
    }

    /**
     * 得到String类型的值
     */
    public static String getString(String key, String defaultValue) {
        return SPUtil.getInstance().getSp().getString(key, defaultValue);
    }

    /**
     * 得到Float类型的值
     */
    public static Float getFloat(String key, float defaultValue) {
        return SPUtil.getInstance().getSp().getFloat(key, defaultValue);
    }

    /**
     * 得到Int类型的值
     */
    public static int getInt(String key, int defaultValue) {
        return SPUtil.getInstance().getSp().getInt(key, defaultValue);
    }

    /**
     * 得到Long类型的值
     */
    public static long getLong(String key, long defaultValue) {
        return SPUtil.getInstance().getSp().getLong(key, defaultValue);
    }

    /**
     * 移除某个key值已经对应的值
     */
    public static boolean remove(String key) {
        SharedPreferences.Editor editor = SPUtil.getInstance().getSp().edit();
        editor.remove(key);
        return editor.commit();
    }




    /**
     * 清除所有数据
     *
     * @return 是否成功
     */
    public static boolean clear() {
        SharedPreferences.Editor editor = SPUtil.getInstance().getSp().edit();
        editor.clear();
        return editor.commit();
    }

    /**
     * 查询某个key是否已经存在
     *
     * @return 是否存在
     */
    public static boolean contains(String key) {
        return SPUtil.getInstance().getSp().contains(key);
    }

    /**
     * 返回所有的键值对
     */
    public static Map<String, ?> getAll() {
        return SPUtil.getInstance().getSp().getAll();
    }
    ///////////////////////////////////////////////////////////////////////////
    // Object 以参数名的形式存入SP
    ///////////////////////////////////////////////////////////////////////////

    // TODO: 2018/1/2

    ///////////////////////////////////////////////////////////////////////////
    // Object 以 JSON 的形式存入SP
    ///////////////////////////////////////////////////////////////////////////





}
