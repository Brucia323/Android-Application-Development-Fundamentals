import { Formik } from 'formik'
import { Pressable, StyleSheet, View } from 'react-native'
import theme from '../theme'
import FormikTextInput from './FormikTextInput'
import Text from './Text'
import * as yup from 'yup'

const styles = StyleSheet.create({
  container: {
    backgroundColor: 'white',
    padding: 12,
  },
  Button: {
    backgroundColor: theme.colors.primary,
    height: 48,
    borderRadius: 5,
    marginTop: 8,
  },
  Text: {
    color: 'white',
    textAlign: 'center',
    marginTop: 'auto',
    marginBottom: 'auto',
  },
})

const validationSchema = yup.object().shape({
  username: yup.string().required('请输入用户名'),
  password: yup.string().required('请输入密码'),
})

const SignIn = () => {
  const onSubmit = values => {
    console.log(values)
  }

  return (
    <Formik onSubmit={onSubmit} validationSchema={validationSchema} initialValues={{}}>
      {({ handleSubmit }) => (
        <View style={styles.container}>
          <FormikTextInput name='username' placeholder='用户名' />
          <FormikTextInput name='password' placeholder='密码' secureTextEntry />
          <Pressable onPress={handleSubmit} style={styles.Button}>
            <Text style={styles.Text} fontSize='subheading'>
              登录
            </Text>
          </Pressable>
        </View>
      )}
    </Formik>
  )
}

export default SignIn
