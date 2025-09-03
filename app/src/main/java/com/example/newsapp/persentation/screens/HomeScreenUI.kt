package com.example.newsapp.persentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import com.example.newsapp.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import com.example.newsapp.persentation.ViewModel.NewsAppViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.newsapp.persentation.navigation.routes.CategoryScreen

@Composable
  fun HomeScreenUI(modifier: Modifier= Modifier, navController: NavController, viewModel: NewsAppViewModel){
    val scroolstate =  rememberLazyListState()
    val selectedCategory = rememberSaveable { mutableStateOf("") }
     val searchTerm = rememberSaveable { mutableStateOf("") }
      val state = viewModel.state.collectAsState()
      val categoryToSearch = rememberSaveable { mutableStateOf(
          arrayListOf("Business", "Entertainment", "General", "Health", "Science", "Sports", "Technology"))}
      if(state.value.loading==true){
          Box(
              contentAlignment = Alignment.Center,
              modifier = Modifier.fillMaxSize()
          ){
              CircularProgressIndicator()
          }
      }else if(state.value.error.isNullOrBlank().not()){
          Text(text = state.value.error.toString())
      } else {
         Column(modifier = Modifier.fillMaxSize()){
             Row(
                 modifier = modifier.fillMaxWidth(), horizontalArrangement= Arrangement.Center,
                 ){
                 OutlinedTextField(value = searchTerm.value, onValueChange = {
                     searchTerm.value = it
                 }, label = { Text(text = "Search")},
                     singleLine = true,
                     shape = RoundedCornerShape(10.dp),
                     placeholder = { Text("Search ....")},
                     modifier=Modifier.weight(1f).padding(8.dp),
                     trailingIcon = {
                         Icon(Icons.Filled.Search, contentDescription = null,
                             modifier = modifier.clickable(enabled = searchTerm.value.isNullOrBlank().not(), onClick = {
                                 viewModel.getEverything(q = searchTerm.value)
                             }
                             )
                 )
                     }
                 )
             }
             Spacer(modifier = Modifier.height(10.dp))
             LazyRow(modifier = modifier.fillMaxWidth(), state = scroolstate ){
                 items(categoryToSearch.value){
                     Card(
                         colors = CardDefaults.cardColors(
                             containerColor = if(it==selectedCategory.value){
                                 MaterialTheme.colorScheme.primary
                             }else{
                                 MaterialTheme.colorScheme.surfaceVariant
                             }
                         ),
                         modifier = Modifier.padding(6.dp).clickable{
                         viewModel.getEverything(q = it)
                             selectedCategory.value = it



                     }){
                         Text(it, fontSize = 30.sp, modifier = Modifier.padding(5.dp))
                     }
                 }


             }
             val data = state.value.data
             if (data?.articles!!.isEmpty()) {
                 Text(text = "No Data Found")
             } else{
                 val articles = data.articles.filter{article ->
                     article.title?.contains("Removed") == false}

                 LazyColumn(modifier = Modifier.fillMaxSize()) {
                     items(articles){ article->
                         Card(
                             modifier = modifier.fillMaxWidth().wrapContentWidth().padding(8.dp).clickable{
                                 navController.navigate(CategoryScreen(
                                     author = article.author,
                                     content = article.content,
                                     description = article.description,
                                     publishedAt = article.publishedAt,
                                     id = article.source!!.id,
                                     name = article.source.name,
                                     title = article.title,
                                     url = article.url,
                                     urlToImage = article.urlToImage
                                 ))

                             }
                         ) {
                             Column{
                                 if(article.urlToImage.isNullOrBlank()){
                                     Image(painterResource(R.drawable.ic_launcher_foreground), contentDescription = null, modifier = Modifier.fillMaxWidth())

                                 }else{
                                 AsyncImage(
                                     model = article.urlToImage,
                                     contentDescription = null,
                                     placeholder = painterResource(R.drawable.ic_launcher_foreground)
                                 )}
                                 article.title?.let{Text(text = it)}

                             }

                         }
                     }
                 }
             }
         }

          }
  }









