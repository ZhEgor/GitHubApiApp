package com.example.githubapiapp.core.util.pagination

class DefaultPaginatorImpl<Key, Item>(
    private val initialKey: Key,
    private inline val onLoadUpdated: suspend (Boolean) -> Unit,
    private inline val onRequest: suspend (nextKey: Key) -> List<Item>?,
    private inline val getNextKey: suspend (List<Item>) -> Key,
    private inline val onError: suspend () -> Unit,
    private inline val onSuccess: suspend (items: List<Item>, nextKey: Key) -> Unit,
) : Paginator<Key, Item> {

    private var currentKey = initialKey
    private var isMakingRequest = false

    override suspend fun loadNextItems() {
        if (isMakingRequest) return
        isMakingRequest = true
        onLoadUpdated(true)
        val result = onRequest(currentKey)
        isMakingRequest = false
        if (result != null) {
            currentKey = getNextKey(result)
            onSuccess(result, currentKey)
        } else {
            onError()
        }
        onLoadUpdated(false)
    }

    override fun reset() {
        currentKey = initialKey
    }
}
