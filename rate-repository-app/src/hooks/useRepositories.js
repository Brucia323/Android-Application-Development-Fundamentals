import { useQuery } from '@apollo/client'
import { useEffect, useState } from 'react'
import { GET_REPOSITORIES } from '../graphql/queries'

const useRepositories = () => {
  const { data, loading } = useQuery(GET_REPOSITORIES, {
    fetchPolicy: 'cache-and-network',
    // Other options
  })
  const [repositories, setRepositories] = useState()

  const fetchRepositories = () => {
      setRepositories(data.repositories)
  }

  useEffect(() => {
    if (data) {
      fetchRepositories()
    }
  }, [data])

  return { repositories, loading, refetch: fetchRepositories }
}

export default useRepositories
