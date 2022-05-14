import { render } from '@testing-library/react-native'
import React from 'react'
import { FlatList, StyleSheet, View } from 'react-native'
import RepositoryItem from '../../components/RepositoryItem'

const RepositoryItemTest = () => {
  const styles = StyleSheet.create({
    separator: {
      height: 10,
    },
  })

  const repositories = [
    {
      id: 'jaredpalmer.formik',
      fullName: 'jaredpalmer/formik',
      description: 'Build forms in React, without the tears',
      language: 'TypeScript',
      forksCount: 1589,
      stargazersCount: 21553,
      ratingAverage: 88,
      reviewCount: 4,
      ownerAvatarUrl: 'https://avatars2.githubusercontent.com/u/4060187?v=4',
    },
    {
      id: 'rails.rails',
      fullName: 'rails/rails',
      description: 'Ruby on Rails',
      language: 'Ruby',
      forksCount: 18349,
      stargazersCount: 45377,
      ratingAverage: 100,
      reviewCount: 2,
      ownerAvatarUrl: 'https://avatars1.githubusercontent.com/u/4223?v=4',
    },
    {
      id: 'django.django',
      fullName: 'django/django',
      description: 'The Web framework for perfectionists with deadlines.',
      language: 'Python',
      forksCount: 21015,
      stargazersCount: 48496,
      ratingAverage: 73,
      reviewCount: 5,
      ownerAvatarUrl: 'https://avatars2.githubusercontent.com/u/27804?v=4',
    },
    {
      id: 'reduxjs.redux',
      fullName: 'reduxjs/redux',
      description: 'Predictable state container for JavaScript apps',
      language: 'TypeScript',
      forksCount: 13902,
      stargazersCount: 52869,
      ratingAverage: 0,
      reviewCount: 0,
      ownerAvatarUrl: 'https://avatars3.githubusercontent.com/u/13142323?v=4',
    },
  ]

  const ItemSeparator = () => <View style={styles.separator} />

  return (
    <FlatList
      data={repositories}
      ItemSeparatorComponent={ItemSeparator}
      renderItem={({ item }) => <RepositoryItem item={item} />}
    />
  )
}

describe('RepositoryItem', () => {
  it('renders a fullname on repository item', () => {
    const { debug, getByText } = render(<RepositoryItemTest />)

    debug()

    expect(getByText('jaredpalmer/formik')).toBeDefined()
    expect(getByText('rails/rails')).toBeDefined()
    expect(getByText('django/django')).toBeDefined()
    expect(getByText('reduxjs/redux')).toBeDefined()
  })

  it('renders a description on repository item', () => {
    const { debug, getByText } = render(<RepositoryItemTest />)

    debug()

    expect(getByText('Build forms in React, without the tears')).toBeDefined()
    expect(getByText('Ruby on Rails')).toBeDefined()
    expect(
      getByText('The Web framework for perfectionists with deadlines.')
    ).toBeDefined()
    expect(
      getByText('Predictable state container for JavaScript apps')
    ).toBeDefined()
  })
})
