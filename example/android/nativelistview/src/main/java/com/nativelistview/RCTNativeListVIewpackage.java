package com.nativelistview;

import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by shiyunjie on 17/5/15.
 */

public class RCTNativeListVIewpackage implements ReactPackage {
    ReactNativeHost reactNativeHost;

    public RCTNativeListVIewpackage(ReactNativeHost reactNativeHost) {
        this.reactNativeHost = reactNativeHost;
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Arrays.<NativeModule>asList(
                new RCTNativeListViewModal(reactContext)
        );
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList(
                new RCTNativeListViewManager(reactNativeHost,reactContext),
                new RCTNativeListViewItemViewManager()
        );

    }
}
