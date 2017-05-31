/**
 * Created by shiyunjie on 17/5/21.
 */
/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */
__STRESS_TEST__ = false;
// import App from './app/app';

/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, {Component} from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text,
    View,
} from 'react-native';
import NListView from './nListView'

import urlData from './imageUrls'
const array = []
for (let n = 0; n < 1000; n++) {
    array.push({title: `${n}`, path: `http://o2o.doorto.cn/upload/yun-o2o/${urlData[n]}`})
}
export default class RNUIDemo extends Component {
    render() {

        return (
            <View style={styles.container}>

                <NListView
                    style={{height: 600, width: 350, backgroundColor: '#ccc'}}
                    dataSource={array}
                />
            </View>
        );
    }


    /*render() {
     return (
     <View style={{ flex: 1 }}>
     <NativeListview
     renderRow={this.renderRow}
     numRows={dataSource.length}
     rowHeight={50}
     />
     </View>
     );
     }
     renderRow(rowID) {
     return (
     <Text style={{
     width: Dimensions.get('window').width,
     height: 50,
     backgroundColor: '#ffffff'
     }}>{dataSource[rowID]}</Text>
     );
     }*/
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
    },
    welcome: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
    instructions: {
        textAlign: 'center',
        color: '#333333',
        marginBottom: 5,
    },
});

