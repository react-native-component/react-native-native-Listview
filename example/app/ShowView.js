/**
 * Created by shiyunjie on 17/5/19.
 */
/**
 * Created by shiyunjie on 17/5/12.
 */
import React, {PropTypes, Component} from 'react';
import {
    StyleSheet,
    Text,
    View,
    Image

} from 'react-native';

import defaultImage from './images/goods_placeholder.png'
export default class ShowView extends Component {

    static propTypes = {

        ...View.propTypes, // 包含默认的View的属性
        title: PropTypes.string,

    }

    constructor(props) {
        super(props)
        this.state = {
            title: this.props.title,
            path: ''
        }
        this.onUpdateView = this.onUpdateView.bind(this);
    }

    onUpdateView = (event) => {
        // console.log(`showView:`, event.nativeEvent)
        this.setState({title: event.nativeEvent.title, path: event.nativeEvent.path})
    }

    render() {
        return (
            <View
                style={styles.container}
            >
                <View style={{width: 100, height: 100}}>
                    <Image
                        style={{width: 100, height: 100}}
                        source={defaultImage}
                    />
                    {this.state.path ?
                    <Image
                        style={{width: 100, height: 100, position: 'absolute', left: 0, top: 0}}
                        source={{uri: this.state.path}}
                    /> : null}
                </View>
                <View style={{flex: 1, flexDirection: 'column'}}>
                    <Text
                        style={styles.welcome}
                    >
                        {`id:${this.state.title}`}
                    </Text>
                    <Text style={{color: 'black',}}>
                        {`${this.state.path}`}
                    </Text>
                </View>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        height: 100,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: 'blue',
        flexDirection: 'row'
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