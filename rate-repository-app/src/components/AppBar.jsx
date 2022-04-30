import Constants from 'expo-constants'
import { StyleSheet, View, ScrollView } from 'react-native'
import { Link } from 'react-router-native'
import Text from './Text'
import useAuthStorage from '../hooks/useAuthStorage'
import { useApolloClient, useQuery } from '@apollo/client'
import { ME } from '../graphql/queries'
import { useEffect, useState } from 'react'

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
  const { data } = useQuery(ME)
  const authStorage = useAuthStorage()
  const apolloClient = useApolloClient()
  const [me, setMe] = useState(null)

  const handleSignOut = () => {
    authStorage.removeAccessToken()
    apolloClient.resetStore()
  }

  useEffect(() => {
    if (data) {
      setMe(data.me)
    }
  },[data])

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
            {me ? (
              <Text fontWeight='bold' onPress={handleSignOut}>
                注销
              </Text>
            ) : (
              <Text fontWeight='bold'>登录</Text>
            )}
          </Link>
        </View>
      </ScrollView>
    </View>
  )
}

export default AppBar
