import { useQuery } from '@apollo/client'
import { useState } from 'react'
import { GET_REPOSITORIES } from '../graphql/queries'

const useRepositories = (order, searchKeyword) => {
  let orderDirection = 'DESC'
  let orderBy = 'CREATED_AT'
  if (order === '最新') {
    orderBy = 'CREATED_AT'
  } else {
    orderBy = 'RATING_AVERAGE'
    if (order === '评分从低到高') {
      orderDirection = 'ASC'
    } else {
      orderDirection = 'DESC'
    }
  }

  console.log('orderDirection =', orderDirection)
  console.log('orderBy =', orderBy)

  const [repositories, setRepositories] = useState()
  const { loading, error, refetch } = useQuery(GET_REPOSITORIES, {
    onCompleted: data => setRepositories(data.repositories),
    notifyOnNetworkStatusChange: true,
    fetchPolicy: 'cache-and-network',
    variables: { orderBy, orderDirection, searchKeyword },
  })

  return { repositories, loading, error, refetch }
}

export default useRepositories
