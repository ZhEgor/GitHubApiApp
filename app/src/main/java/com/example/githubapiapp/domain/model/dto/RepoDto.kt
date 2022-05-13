package com.example.githubapiapp.domain.model.dto

import com.example.githubapiapp.domain.model.ui.RepoUi
import com.google.gson.annotations.SerializedName

data class RepoDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("forks_count")
    val forksCount: Int,
    @SerializedName("watchers_count")
    val watchersCount: Int,
    @SerializedName("stargazers_count")
    val stargazersCount: Int,
    @SerializedName("open_issues_count")
    val openIssuesCount: Int,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("language")
    val language: String?,
    @SerializedName("owner")
    val shortUserDto: ShortUserDto
) : Dto<RepoUi> {

    override fun toUi() = RepoUi(
        id = id,
        name = name,
        htmlUrl = htmlUrl,
        forksCount = forksCount,
        watchersCount = watchersCount,
        stargazersCount = stargazersCount,
        openIssuesCount = openIssuesCount,
        updatedAt = updatedAt,
        language = language ?: "",
        shortUserUi = shortUserDto.toUi()
    )
}
