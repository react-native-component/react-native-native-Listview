/**
 * Created by shiyunjie on 17/5/31.
 */
/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */
import React, {Component} from 'react'
import {
    AppRegistry,
    NativeAppEventEmitter,
    NativeModules,//JS调用modules使用的类
    DeviceEventEmitter,//接受事件用到的类
} from 'react-native'


import Item from './app/ItemView'


import PullToRefreshListViewDemo from './app/NativeListView';


export default class App extends Component {


    render() {
        return (
            <PullToRefreshListViewDemo/>
        )
    }


}


AppRegistry.registerComponent('example', () => App);
AppRegistry.registerComponent('listViewItem', () => Item);
