/**
 * Created by shiyunjie on 17/5/12.
 */
import React, {PropTypes, Component} from 'react';
import {
    StyleSheet,
    Text,
    View,
    Image,

} from 'react-native';
import Item from './listViewItem'

import Show from './ShowView'
export default class ItemView extends Component {

    static propTypes = {

        ...View.propTypes, // 包含默认的View的属性
        title: PropTypes.string,
        onUpdateView: PropTypes.func,

    }

    constructor(props) {
        super(props)
    }



    onUpdateView = (event) => {
         // console.log(`onUpdateView:`, event)
        this.ShowView.onUpdateView(event)
    }


    render() {
        return (
            <Item
                style={styles.container}
                onUpdateView={this.onUpdateView}>
                <Show
                    {...this.props}
                    ref={component => this.ShowView = component}
                    style={styles.welcome}
                />
            </Item>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        height: 100,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: 'blue',
    },
    welcome: {
        flex: 1
    },
    instructions: {
        textAlign: 'center',
        color: '#333333',
        marginBottom: 5,
    },
});