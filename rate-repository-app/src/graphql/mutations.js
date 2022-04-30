import { gql } from '@apollo/client'

export const SIGN_IN = gql`
  mutation mutate($credentials: AuthenticateInput) {
    authenticate(credentials: $credentials) {
      accessToken
    }
  }
`