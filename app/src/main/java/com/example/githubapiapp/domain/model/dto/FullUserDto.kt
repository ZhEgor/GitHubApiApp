package com.example.githubapiapp.domain.model.dto

import com.example.githubapiapp.domain.model.ui.FullUserUi
import com.google.gson.annotations.SerializedName

data class FullUserDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("email")
    val email: String?,
    @SerializedName("public_repos")
    val publicReposCount: Int,
    @SerializedName("followers")
    val followersCount: Int,
    @SerializedName("following")
    val followingCount: Int,
) : Dto<FullUserUi> {

    override fun toUi() = FullUserUi(
        id = id,
        login = login,
        avatarUrl = avatarUrl,
        url = url,
        htmlUrl = htmlUrl,
        email = email ?: "",
        publicReposCount = publicReposCount,
        followersCount = followersCount,
        followingCount = followingCount
    )
}
