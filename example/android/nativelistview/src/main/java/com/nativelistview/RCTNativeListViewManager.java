package com.nativelistview;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
//import com.reactnativenavigation.params.ActivityParams;

import java.util.ArrayList;

/**
 * Created by shiyunjie on 17/5/15.
 */

public class RCTNativeListViewManager extends SimpleViewManager<RCTNativeListView> {
    ReactNativeHost reactNativeHost;
    ReactApplicationContext reactContext;
    EventDispatcher mEventDispatcher;
    LayoutInflater inflater;
    //    ActivityParams activityParams;
    UIImplementation uiImplementation;

    public RCTNativeListViewManager(ReactNativeHost reactNativeHost, ReactApplicationContext reactContext) {
        this.reactNativeHost = reactNativeHost;
        this.reactContext = reactContext;
        inflater = LayoutInflater.from(reactContext);


    }


    @Override
    public String getName() {
        return "RCTNativeListView";
    }

    @Override
    protected RCTNativeListView createViewInstance(ThemedReactContext reactContext) {
        RCTNativeListView listView = new RCTNativeListView(reactContext);
        listView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
        Log.i("test", "ViewConfiguration.getScrollFriction():" + ViewConfiguration.getScrollFriction());
//        listView.setFriction(ViewConfiguration.getScrollFriction() * 2);

        return listView;
    }

    @Override
    public void updateExtraData(RCTNativeListView root, Object extraData) {
        Log.i("test", "updateExtraData:" + extraData);
        super.updateExtraData(root, extraData);
    }

    @ReactProp(name = "dataSource")
    public void setDataSource(RCTNativeListView ListView, ReadableArray array) {

        if (array != null) {

            ArrayList<ReadableMap> arrayList = new ArrayList<>();
            for (int i = 0; i < array.size(); i++) {
                ReadableMap map = array.getMap(i);

             /*   ReadableMapKeySetIterator iterator = map.keySetIterator();
                Map<String, Object> result = new HashMap<>();
                while (iterator.hasNextKey()) {
                    String key = iterator.nextKey();
                    ReadableType type = map.getType(key);


                    switch (type) {
                        case Null:
                            break;
                        case Boolean:
                            result.put(key, map.getBoolean(key));
                            break;
                        case Number:

                            result.put(key, map.getInt(key));

                            break;
                        case String:
                            result.put(key, map.getString(key));
                            break;
                        case Map:
                            result.put(key, recursivelyDeconstructReadableMap(map.getMap(key)));
                            break;
                        case Array:
                            result.put(key, recursivelyDeconstructReadableArray(map.getArray(key)));
                            break;
                        default:
                            throw new IllegalArgumentException("Could not convert object with key: " + key + ".");
                    }

                }*/
                arrayList.add(map);
            }
            RCTAdapter adapter = new RCTAdapter(arrayList);
            ListView.setAdapter(adapter);


        }


    }


    public class RCTAdapter extends BaseAdapter {
        ArrayList<ReadableMap> dataSource;

        public RCTAdapter(ArrayList<ReadableMap> dataSource) {
            this.dataSource = dataSource;
        }


        @Override
        public int getCount() {
            return dataSource == null ? 0 : dataSource.size();
        }

        @Override
        public Object getItem(int position) {
            return dataSource.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            final ReadableMap item = dataSource.get(position);
            if (mEventDispatcher == null) {
                mEventDispatcher = reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher();
            }

            final ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
//                com.reactnativenavigation.views.ContentView contentView=new com.reactnativenavigation.views.ContentView(reactContext,"listViewItem"+position,activityParams.screenParams.navigationParams);
                holder.contentView = new ReactRootView(reactContext);
                //获取注册对象
                convertView = inflater.inflate(R.layout.layout, null);

                holder.ll = (LinearLayout) convertView.findViewById(R.id.ll_content);
//                holder.imageView=new ImageView(reactContext);
//                holder.imageView.setLayoutParams(new LinearLayout.LayoutParams(300, 300));  //设置图片宽高
//                holder.textView=new TextView(reactContext);
//                holder.textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));  //设置图片宽高

//                holder.ll.addView(holder.imageView);
              holder.contentView.startReactApplication(reactNativeHost.getReactInstanceManager(), "listViewItem", Arguments.toBundle(item));
//                holder.contentView.startReactApplication(reactNativeHost.getReactInstanceManager(), "listViewItem");

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300);
                holder.contentView.setLayoutParams(params);
//                holder.textView.setTextColor(Color.BLACK);
//                holder.ll.addView(holder.textView);
                //主布局container
                holder.ll.addView(holder.contentView);
                convertView.setTag(holder);
//                Log.i("test", "Create ContentView from reactNative:");
            } else {
                holder = (ViewHolder) convertView.getTag();
//                Log.i("test", "Get Tag from ViewHolder:" + holder.contentView.getRootViewTag());
//                ReactRootView view = holder.contentView;
//                view.setAppProperties(Arguments.toBundle(item));
//            }

            }
            RCTNativeListViewItemView view = (RCTNativeListViewItemView) holder.contentView.getChildAt(0);
            WritableMap data = Arguments.fromBundle(Arguments.toBundle(item));
            if(view!=null) {
                view.setState(data);
            }
//            holder.imageView.setImageResource(R.drawable.goods_placeholder); //图片资源
//            holder.textView.setText(position+"");


            return convertView;
        }

        class ViewHolder {
            LinearLayout ll;
            ReactRootView contentView;
//            ImageView imageView;
//            TextView textView;
        }
    }
}
