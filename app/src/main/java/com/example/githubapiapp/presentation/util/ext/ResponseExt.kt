package com.example.githubapiapp.presentation.util.ext

import com.example.githubapiapp.domain.model.dto.Dto
import retrofit2.Response

@Suppress("UNCHECKED_CAST")
fun <T1 : Dto<T2>, T2> Response<T1>.toUi(): Response<T2> {
    return if (isSuccessful) {
        Response.success(body()?.toUi())
    } else {
        Response.error(errorBody(), raw())
    }
}
