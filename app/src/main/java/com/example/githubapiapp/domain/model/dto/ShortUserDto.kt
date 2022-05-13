package com.example.githubapiapp.domain.model.dto

import com.example.githubapiapp.domain.model.ui.ShortUserUi
import com.google.gson.annotations.SerializedName

data class ShortUserDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("html_url")
    val htmlUrl: String
) : Dto<ShortUserUi> {

    override fun toUi() = ShortUserUi(
        id = id,
        avatarUrl = avatarUrl,
        url = url,
        htmlUrl = htmlUrl,
        login = login,
    )
}
