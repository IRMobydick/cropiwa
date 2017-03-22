package com.steelkiwi.cropiwa.sample.util;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

/**
 * Created by yarolegovich on 22.03.2017.
 */

public class Permissions {

    public static boolean isGranted(Activity activity, String permission) {
        return ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
    }

}
