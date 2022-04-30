import { StyleSheet, View } from 'react-native'
import { Navigate, Route, Routes } from 'react-router-native'
import AppBar from './AppBar'
import RepositoryList from './RepositoryList'
import SignIn from './SignIn'

const styles = StyleSheet.create({
  container: {
    // marginTop: Constants.statusBarHeight,
    flexGrow: 1,
    flexShrink: 1,
    backgroundColor: '#d9d9d9',
  },
})

const Main = () => {
  return (
    <View style={styles.container}>
      <AppBar />
      <Routes>
        <Route path='/' element={<RepositoryList />} exact />
        <Route path='/signin' element={<SignIn />} exact />
        <Route path='*' element={<Navigate to='/' replace />} />
      </Routes>
    </View>
  )
}

export default Main
