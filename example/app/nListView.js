/**
 * Created by shiyunjie on 17/5/15.
 */
import React, { Component, PropTypes } from 'react';
import {
    NativeAppEventEmitter,
    NativeModules,
    Platform,
    StyleSheet,
    requireNativeComponent,
    View,

} from 'react-native';
const NListView = requireNativeComponent('RCTNativeListView', ListView);

export default class ListView extends Component {
    constructor(props) {
        super(props);
    }

    static propTypes = {

        ...View.propTypes, // 包含默认的View的属性
        dataSource:PropTypes.array,

    }

    render() {
        return (
            <NListView
                {...this.props}
            />
        );
    }
}