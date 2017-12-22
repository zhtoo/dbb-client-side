package com.hs.dbbclientside;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.support.multidex.MultiDexApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 全局单例 APP启动时最先运行。
 * Created by zhanghaitao on 2017/5/18.

 */
public class MyApplication extends MultiDexApplication {

    private final  String TAG =getClass().getSimpleName();

    /**全局的Context*/
    private static Context mContext;
    /**主线程的handler*/
    private static Handler mMainThreadHandler;
    /**主线程id*/
    private static int mMainThreadId;
    /**用于内存缓存的Map*/
    private Map<String, String> mMemProtocolCacheMap = new HashMap<>();
    /** 用于监听APP是否到后台*/
  //  private static GestureLockWatcher watcher;

    @Override
    public void onCreate() {//程序的入口方法
        //上下文
        mContext = getApplicationContext();
        //主线程的Handler
        mMainThreadHandler = new Handler();
        //主线程的线程id
        mMainThreadId = Process.myTid();
        // 抓取异常LOG，保存在本地
       //  CrashHandler.getInstance().init(this);

        // 监听APP是否到后台
//        watcher = new GestureLockWatcher(this);
//        watcher.setOnScreenPressedListener(new GestureLockWatcher.OnScreenPressedListener() {
//            @Override
//            public void onPressed() {
//                LockLogic.getInstance().start();
//            }
//        });
//        watcher.startWatch();

        int threadPriorityBackground = Process.THREAD_PRIORITY_BACKGROUND;

        super.onCreate();
    }

    /**
      当整个系统运行在内存不足的状态时会调用这个函数，而主动运行的进程应该修改内存的使用。
      虽然没有定义这个被调用的确切点，但通常在所有的后台进程都被终止的时候会发生。
      也就是说，在达到我们希望避免杀死的托管服务和前台UI的处理点之前。

     你应该实现这个方法来释放任何缓存或其他不必要的资源。
     从这个方法返回后，系统会为你执行垃圾回收。

     最好，你应该实现onTrimMemory(int)从 ComponentCallbacks2基于各种级别的内存需求逐步卸下你的资源。
     该API可用于API级别14和更高版本，因此您应该只使用此onLowMemory()方法作为旧版本的后备，
     这可以onTrimMemory(int)与TRIM_MEMORY_COMPLETE级别一样对待。

     如果您重写此方法，则必须调用super实现。
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }



    /**
     * 获取监听APP是否到后台的监听器
     *
     * @return
     */
  /*  public static GestureLockWatcher getWatcher() {
        return watcher;
    }*/

    /**
     * 获取MEM协议缓存集合
     *
     * @return:Map集合
     */
    public Map<String, String> getMemProtocolCacheMap() {
        return mMemProtocolCacheMap;
    }

    /**
     * 得到上下文
     *
     * @return
     */
    public static Context getContext() {
        return mContext;
    }

    /**
     * 得到主线程里面的创建的一个hanlder
     *
     * @return
     */
    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

    /**
     * 得到主线程的线程id
     *
     * @return
     */
    public static int getMainThreadId() {
        return mMainThreadId;
    }

    /**
     * 获取资源文件中颜色的int值
     *
     * @return
     */
    public static int getcolor(int id) {
        int color = getContext().getResources().getColor(id);
        return color;
    }


    /**
     * 存放Activity的对象
     */
    private static Map<String, Activity> destoryMap = new HashMap<>();

    /**
     * 添加到销毁队列
     *
     * @param activity 要销毁的activity
     */

    public static void addDestoryActivity(Activity activity, String activityName) {
        destoryMap.put(activityName, activity);
    }

    /**
     * 销毁指定Activity
     */
    public static void destoryActivity(String activityName) {
        Set<String> keySet = destoryMap.keySet();
        for (String key : keySet) {
            destoryMap.get(key).finish();
        }
    }

    /**
     * 将Activity添加到集合中
     *
     * @param activity
     * @param activityName
     */
    public static void addActivity(Activity activity, String activityName) {
        destoryMap.put(activityName, activity);
    }

    /**
     * 获取到某个Activity
     *
     * @param activityName
     * @return
     */
    public static Activity getActivity(String activityName) {
        Set<String> keySet = destoryMap.keySet();
        for (String key : keySet) {
            return destoryMap.get(key);
        }
        return null;
    }

}

