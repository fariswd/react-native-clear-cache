package com.fariswd.module.rnclearcache;

import android.content.Context;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import java.io.File;

public class RNClearCacheModule extends ReactContextBaseJavaModule {

    public RNClearCacheModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNClearCacheModule";
    }

    @ReactMethod
    public void show(String message, Callback callback) {
        Toast.makeText(getReactApplicationContext(), message, Toast.LENGTH_LONG).show();
        callback.invoke("success");
    }

    @ReactMethod
    public void clear(Callback callback) {
        deleteCache(getReactApplicationContext(), callback);
    }

    public static void deleteCache(Context context, Callback callback) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
            callback.invoke(true);
        } catch (Exception e) {
            e.printStackTrace();
            callback.invoke(false);
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }

}
