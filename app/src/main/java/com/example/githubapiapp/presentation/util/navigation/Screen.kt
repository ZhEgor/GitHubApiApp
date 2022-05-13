package com.example.githubapiapp.presentation.util.navigation

sealed class Screen(val route: String) {

    object RepoSearchScreen : Screen("repo_search_screen")
    object RepoDetailsScreen : Screen("repo_details_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { args ->
                append("/$args")
            }
        }
    }
}
