package com.example.githubapiapp.domain.model.dto

import com.example.githubapiapp.domain.model.dto.UrlRequest.Companion.ASC_VALUE
import com.example.githubapiapp.domain.model.dto.UrlRequest.Companion.DESC_VALUE
import com.example.githubapiapp.domain.model.dto.UrlRequest.Companion.DIVIDER
import com.example.githubapiapp.domain.model.dto.UrlRequest.Companion.ORDER_FIELD_NAME
import com.example.githubapiapp.domain.model.dto.UrlRequest.Companion.SORT_FIELD_NAME

class UrlRequest {

    val url: String
        get() = buildPayload()
    var sorting: SortBy = SortBy.STARS
    var query: String = ""
    var page: Int = 1
    var per_page: Int = 30

    private fun buildPayload() = BASE_PATH +
            QUERY_FIELD_NAME + query +
            DIVIDER + sorting.toUrl() +
            DIVIDER + PAGE_FIELD_NAME + page +
            DIVIDER + PER_PAGE_FIELD_NAME + per_page

    companion object {
        const val BASE_PATH = "/search/repositories?"
        const val QUERY_FIELD_NAME = "q="
        const val DIVIDER = "&"
        const val PAGE_FIELD_NAME = "page="
        const val PER_PAGE_FIELD_NAME = "per_page="
        const val SORT_FIELD_NAME = "sort="
        const val ORDER_FIELD_NAME = "order="
        const val DESC_VALUE = "desc"
        const val ASC_VALUE = "asc"
    }
}

enum class SortBy(val sortName: String, var asc: Boolean = false) {
    STARS(sortName = "stars"),
    FORKS(sortName = "forks"),
    UPDATED(sortName = "updated")
}

fun SortBy.toUrl() = SORT_FIELD_NAME + sortName + DIVIDER + ORDER_FIELD_NAME + if (asc) ASC_VALUE else DESC_VALUE