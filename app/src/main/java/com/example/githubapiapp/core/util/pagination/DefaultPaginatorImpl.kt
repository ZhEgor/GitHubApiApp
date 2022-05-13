package com.example.githubapiapp.core.util.pagination

import okhttp3.ResponseBody
import retrofit2.Response

class DefaultPaginatorImpl<Key, Item>(
    private val initialKey: Key,
    private inline val onLoadUpdated: suspend (Boolean) -> Unit,
    private inline val onRequest: suspend (nextKey: Key) -> Response<List<Item>>,
    private inline val getNextKey: suspend (List<Item>) -> Key,
    private inline val onError: suspend (ResponseBody?) -> Unit,
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
        if (result.isSuccessful) {
            result.body()?.let { items ->
                currentKey = getNextKey(items)
                onSuccess(items, currentKey)
            }
        } else {
            onError(result.errorBody())
        }
        onLoadUpdated(false)
    }

    override fun reset() {
        currentKey = initialKey
    }
}
