package com.example.newsapp.persentation.navigation.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.toRoute
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.model.Source
import com.example.newsapp.persentation.ViewModel.NewsAppViewModel
import com.example.newsapp.persentation.screens.HomeScreenUI
import com.example.newsapp.persentation.screens.CategoryDetailScreenUI


@Composable
fun AppNavigation(modifier: Modifier = Modifier, viewModel: NewsAppViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeScreen) {
        composable <HomeScreen> {
            HomeScreenUI(modifier=modifier,navController  = navController, viewModel = viewModel)
        }
        composable<CategoryScreen>{
            val categoryScreen= it.toRoute<CategoryScreen>()
            var article = Article(
                author = categoryScreen.author,
                content = categoryScreen.content,
                description = categoryScreen.description,
                publishedAt = categoryScreen.publishedAt,
                source = Source(
                    id = categoryScreen.id,
                    name = categoryScreen.name
                ),
                title = categoryScreen.title,
                url = categoryScreen.url,
                urlToImage = categoryScreen.urlToImage

            )
            CategoryDetailScreenUI(article = article)
        }


        }
    }



