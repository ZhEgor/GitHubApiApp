package com.example.githubapiapp.domain.model.dto

import com.example.githubapiapp.domain.model.ui.RepoUi
import com.google.gson.annotations.SerializedName

data class GitHubListResponseDto(
    @SerializedName("items")
    val items: List<RepoDto>
): Dto<List<RepoUi>> {

    override fun toUi() = items.map { repoDto -> repoDto.toUi() }
}