package com.example.zwj.mvpdemo.utils;

import android.util.Log;

import com.example.zwj.mvpdemo.app.AppConfig;
import com.orhanobut.logger.Logger;

/**
 * <b>创建时间</b> 17/5/27 <br>
 *
 * @author zhouwenjun
 */

public class FCLogger {
    //    public static boolean AppConfig.isLOG = isLOG;
//    public static boolean AppConfig.isLOG = AppConfig.isLOG;
    public static boolean SHOW_ACTIVITY_STATE = true;

    public static final void openDebutLog(boolean enable) {
        AppConfig.isLOG = enable;
    }

    public static final void openActivityState(boolean enable) {
        SHOW_ACTIVITY_STATE = enable;
    }

    public static final void debug(String msg) {
        if (AppConfig.isLOG ) {
            Logger.t(5).i(msg);
        }
    }

    public static final void log(String packName, String state) {
        debugLog(packName, state);
    }

    public static final void debug(String msg, Throwable tr) {
        if (AppConfig.isLOG ) {
            Log.i("debug", msg, tr);
        }
    }
    public static final void json(String msg) {
        if (AppConfig.isLOG ) {
            Logger.t(5).json(msg);
        }
    }
    public static final void state(String packName, String state) {
        if (SHOW_ACTIVITY_STATE) {
            Log.d("activity_state", packName + state);
        }
    }

    public static final void debugLog(String packName, String state) {
        if (AppConfig.isLOG ) {
            Log.d("debug", packName + state);
        }
    }

    public static final void exception(Exception e) {
        if (AppConfig.isLOG ) {
            e.printStackTrace();
        }
    }

    public static final void debug(String msg, Object... format) {
        debug(String.format(msg, format));
    }
}

