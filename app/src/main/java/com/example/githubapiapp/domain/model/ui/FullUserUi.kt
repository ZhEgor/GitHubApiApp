package com.example.githubapiapp.domain.model.ui

data class FullUserUi(
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val url: String,
    val htmlUrl: String,
    val email: String,
    val publicReposCount: Int,
    val followersCount: Int,
    val followingCount: Int,
)
