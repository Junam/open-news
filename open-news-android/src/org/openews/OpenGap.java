package org.openews;

import android.os.Bundle;

import com.phonegap.DroidGap;

public class OpenGap extends DroidGap {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("oncreate");
        super.loadUrl("file:///android_asset/www/index.html");
    }
}