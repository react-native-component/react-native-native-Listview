package com.nativelistview;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

import java.util.Map;

/**
 * Created by shiyunjie on 17/5/18.
 */

public class RCTNativeListViewItemViewManager extends ViewGroupManager<RCTNativeListViewItemView> {


    @Override
    public String getName() {
        return "RCTNativeListViewItemView";
    }

//    @ReactProp(name = "title")
//    public void setTitle(RCTNativeListView ListView, String title) {
//        Log.i("Test","get_title_"+title);
//    }

//    @ReactProp(name = "keyNum")
//    public void setkeyNum(RCTNativeListView ListView, int keyNum) {
//        Log.i("Test","get_keyNum_"+keyNum);
//    }

    @Override
    protected RCTNativeListViewItemView createViewInstance(ThemedReactContext reactContext) {
        return new RCTNativeListViewItemView(reactContext);
    }

    @Override
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder()
                .put("onUpdateView", MapBuilder.of("registrationName", "onUpdateView"))
                .build();
    }
}
