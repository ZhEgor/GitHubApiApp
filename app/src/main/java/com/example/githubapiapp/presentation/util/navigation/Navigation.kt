package com.example.githubapiapp.presentation.util.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.githubapiapp.presentation.screen.repo_details.RepoDetailsScreen
import com.example.githubapiapp.presentation.screen.repo_search.RepoSearchScreen
import org.koin.androidx.compose.getViewModel

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
        composable(route = Screen.RepoDetailsScreen.route) {
            RepoDetailsScreen(
                navController = navController
            )
        }

//        }        composable(
//            route = Screen.WordListScreen.route + "/{name}",
//            arguments = listOf(
//                navArgument("categoryId") {
//                    type = NavType.StringType
//                }
//            )) { entry ->
//            entry.arguments?.getString("categoryId")?.let { categoryId ->
//                WordListScreen(
//                    categoryId = categoryId,
//                    navController = navController,
//                    viewModel = getViewModel()
//                )
//            }
//        }
    }
}
