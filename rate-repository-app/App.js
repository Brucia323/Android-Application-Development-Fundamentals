import Main from './src/components/Main'
import { NativeRouter } from 'react-router-native'
import { StatusBar } from 'expo-status-bar'

const App = () => {
  return (
    <>
      <NativeRouter>
        <Main />
      </NativeRouter>
      <StatusBar style='auto' />
    </>
  )
}

export default App
