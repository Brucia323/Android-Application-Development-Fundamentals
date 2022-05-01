import { useQuery } from '@apollo/client'
import { useState } from 'react'
import { GET_REPOSITORY } from '../graphql/queries'

const useRepository = repositoryId => {
  const [repository, setRepository] = useState()
  const { loading, error } = useQuery(GET_REPOSITORY, {
    onCompleted: data => setRepository(data.repository),
    variables: { repositoryId },
    fetchPolicy: 'cache-and-network',
  })

  return { repository, loading, error }
}

export default useRepository
