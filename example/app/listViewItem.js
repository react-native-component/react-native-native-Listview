/**
 * Created by shiyunjie on 17/5/15.
 */
import React, {Component, PropTypes} from 'react';
import {
    NativeAppEventEmitter,
    NativeModules,
    Platform,
    StyleSheet,
    requireNativeComponent,
    View,

} from 'react-native';

const Item = requireNativeComponent('RCTNativeListViewItemView', ItemView);

export default class ItemView extends Component {
    constructor(props) {
        super(props);
    }

    static propTypes = {

        ...View.propTypes, // 包含默认的View的属性
        onUpdateView:PropTypes.func.isRequired
    }

    componentWillUpdate(nextProps, nextState) {
        console.log(`FirstTabScreen_componentWillUpdate:`, nextProps)
    }

    componentWillMount() {
        console.log(`componentWillMount:`)
    }


    componentWillReceiveProps(nextProps) {
        console.log(`RCTNativeListViewItemView_ReceiveProps:`, nextProps)
    }


    render() {
        return (
            <Item
                {...this.props}
            />

        );
    }
}