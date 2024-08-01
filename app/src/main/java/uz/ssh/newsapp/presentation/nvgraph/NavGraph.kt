package uz.ssh.newsapp.presentation.nvgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import uz.ssh.newsapp.presentation.home.HomeScreen
import uz.ssh.newsapp.presentation.home.HomeViewModel
import uz.ssh.newsapp.presentation.onboarding.OnBoardingScreen
import uz.ssh.newsapp.presentation.onboarding.OnBoardingViewModel
import uz.ssh.newsapp.presentation.search.SearchScreen
import uz.ssh.newsapp.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String,
) {
    val navController = rememberNavController()

    println("startDestination $startDestination")
    NavHost(navController, startDestination = startDestination) {


        composable(route = Route.OnBoardingScreen.route) {
            val viewModel: OnBoardingViewModel = hiltViewModel()
            OnBoardingScreen(viewModel::onEvent)
        }

        composable(route = Route.HomeScreen.route) {
            val viewModel: HomeViewModel = hiltViewModel()
            val articles = viewModel.news.collectAsLazyPagingItems()
            HomeScreen(articles, navigate = { navController.navigate(Route.SearchScreen.route) })
        }

        composable(route = Route.SearchScreen.route) {
            val viewModel: SearchViewModel = hiltViewModel()
            SearchScreen(
                state = viewModel.state.value,
                event = viewModel::onEvent,
                navigate = {})
        }
        composable(route = Route.DetailsScreen.route) {
//            DetailScreen(
//                article = viewModel.article.value,
//                event = viewModel::onEvent,
//                navigateUp = { navController.navigateUp() }
//            )
        }

    }
}
