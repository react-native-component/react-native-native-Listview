package com.nativelistview;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

/**
 * Created by shiyunjie on 17/5/15.
 */

public class RCTNativeListViewModal extends ReactContextBaseJavaModule {

    public RCTNativeListViewModal(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RCTNativeListViewModal";
    }
}
