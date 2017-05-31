package com.nativelistview;


import android.content.Context;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.view.ReactViewGroup;

/**
 * Created by shiyunjie on 17/5/18.
 */

public class RCTNativeListViewItemView extends ReactViewGroup {
    final EventDispatcher mEventDispatcher;
    public RCTNativeListViewItemView(Context context) {
        super(context);
        mEventDispatcher = ((ReactContext) getContext()).getNativeModule(UIManagerModule.class).getEventDispatcher();

    }

    public void setState(WritableMap map) {
        mEventDispatcher.dispatchEvent(new MyEvent(getId(), map));
    }

    private class MyEvent extends Event<MyEvent> {
        private final WritableMap map;

        private MyEvent(int viewTag,WritableMap map) {
            super(viewTag);
            this.map = map;
        }

        @Override
        public String getEventName() {
            return "onUpdateView";
        }

        @Override
        public void dispatch(RCTEventEmitter rctEventEmitter) {/*
            WritableMap eventData = Arguments.createMap();
            eventData.putInt("rowID", mRowId);*/
            rctEventEmitter.receiveEvent(getViewTag(), getEventName(), map);
        }
    }//end class;
}
