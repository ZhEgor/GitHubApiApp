package com.example.githubapiapp.presentation.util.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.githubapiapp.presentation.screen.repodetails.RepoDetailsScreen
import com.example.githubapiapp.presentation.screen.reposearch.RepoSearchScreen
import com.example.githubapiapp.presentation.util.ext.replaceFakeSlash
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.RepoSearchScreen.route
    ) {
        composable(route = Screen.RepoSearchScreen.route) {
            RepoSearchScreen(
                navController = navController
            )
        }
        composable(
            route = Screen.RepoDetailsScreen.route + "/{repoUrl}/{userUrl}",
            arguments = listOf(
                navArgument("repoUrl") {
                    type = NavType.StringType
                },
                navArgument("userUrl") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            RepoDetailsScreen(
                viewModel = getViewModel(
                    parameters = {
                        parametersOf(
                            entry.arguments?.getString("repoUrl")?.replaceFakeSlash(),
                            entry.arguments?.getString("userUrl")?.replaceFakeSlash()
                        )
                    }
                )
            )
        }
    }
}
