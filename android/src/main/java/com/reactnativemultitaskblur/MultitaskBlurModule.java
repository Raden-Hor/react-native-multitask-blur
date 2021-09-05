package com.reactnativemultitaskblur;

import android.app.Activity;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = MultitaskBlurModule.NAME)
public class MultitaskBlurModule extends ReactContextBaseJavaModule {
    public static final String NAME = "MultitaskBlur";

    public MultitaskBlurModule(ReactApplicationContext reactContext) {
      super(reactContext);

    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    // Example method
    // See https://reactnative.dev/docs/native-modules-android
    @ReactMethod
    public void blur() {
      Activity activity = this.getCurrentActivity();
      activity.runOnUiThread(new Runnable() {
        @Override
        public void run() {
          activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        }
      });

    }

  @ReactMethod
  public void unBlur() {
    Activity activity = this.getCurrentActivity();
    activity.runOnUiThread(new Runnable() {
      @Override
      public void run() {
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
      }
    });

  }
}
