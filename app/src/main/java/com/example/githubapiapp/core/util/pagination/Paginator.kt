package com.example.githubapiapp.core.util.pagination

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}
