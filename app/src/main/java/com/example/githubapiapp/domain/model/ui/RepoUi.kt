package com.example.githubapiapp.domain.model.ui

data class RepoUi(
    val id: Int,
    val name: String,
    val htmlUrl: String,
    val url: String,
    val forksCount: Int,
    val watchersCount: Int,
    val stargazersCount: Int,
    val openIssuesCount: Int,
    val updatedAt: String,
    val createdAt: String,
    val language: String,
    val owner: ShortUserUi
)
