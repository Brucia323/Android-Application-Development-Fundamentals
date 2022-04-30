import Constants from 'expo-constants'
import { StyleSheet, View, ScrollView } from 'react-native'
import { Link } from 'react-router-native'
import Text from './Text'

const styles = StyleSheet.create({
  container: {
    paddingTop: Constants.statusBarHeight + 12,
    height: 64,
    backgroundColor: '#d9d9d9',
    paddingLeft: 12,
    paddingBottom: 12,
    flexDirection: 'row',
  },
  Button: {
    marginLeft: 8,
    marginRight: 8,
  },
})

const AppBar = () => {
  return (
    <View style={styles.container}>
      <ScrollView horizontal>
        <View style={styles.Button}>
          <Link to='/'>
            <Text fontWeight='bold'>存储库</Text>
          </Link>
        </View>
        <View style={styles.Button}>
          <Link to='/signin'>
            <Text fontWeight='bold'>登录</Text>
          </Link>
        </View>
      </ScrollView>
    </View>
  )
}

export default AppBar
