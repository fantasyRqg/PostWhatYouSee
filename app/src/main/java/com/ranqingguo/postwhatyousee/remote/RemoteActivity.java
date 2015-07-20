package com.ranqingguo.postwhatyousee.remote;

import android.app.Activity;

/**
 * @Created by ranqingguo on 20/7/15.
 */
public interface RemoteActivity {
    /**
     * use remote java binary file to load logic and view init
     *
     * @param activity activity to bind logic and view
     * @return if succeed return true ,otherwise return false
     */
    boolean bindActivity(Activity activity);
}
