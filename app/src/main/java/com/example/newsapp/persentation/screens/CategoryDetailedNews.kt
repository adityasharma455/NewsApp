package com.example.newsapp.persentation.screens

import com.example.newsapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.model.Source
import java.nio.file.Files.size

@Preview(showBackground = true, showSystemUi = true)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDetailScreenUI(modifier: Modifier = Modifier, article: Article = Article(
    source = Source(
        id = "google-news",
        name = "Google News"
    ),
    author= "Barron's",
    title = "Super Micro Stock Is Under Pressure. What Could Turn It Around. - Barron's",
    description = null,
    url = "https://news.google.com/rss/articles/CBMifkFVX3lxTFBVNHpWSmdWdFBkZzVlVHQxWjJqb29xZTZEY3pHTFNZWDhjZkkwRzM0U25ucUZsd3k5dWhTVFU4cjM5dVVNWXFDMUI0dFRReXhKaGMyUDlqN0hzNUczZXNK",
    urlToImage = null,
    publishedAt = "2024-12-17T10:49:00Z",
    content = null



)){

    Scaffold (
        modifier = modifier.fillMaxSize(),
        topBar ={
            TopAppBar(
                //modifier = Modifier.height(size),
                title = {
                    Text(text = "Detail News", fontSize = 20.sp)
                },
                colors = TopAppBarDefaults.topAppBarColors(Color.Gray)
            )

        }
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it).padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally)
        {
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Title:  "+article.title.toString(),
                fontStyle = FontStyle.Italic,
                style= TextStyle(
                  fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp,
                    lineHeight = 20.sp
                )
            )
            Spacer(modifier = Modifier.height(24.dp).padding(it))

            Card(modifier = Modifier.height(200.dp),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                shape= RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp,
                    bottomStart = 10.dp,
                    bottomEnd = 10.dp
                )
                ) {
                Column {
                    Card(
                        modifier = Modifier.wrapContentHeight(),
                        shape = RoundedCornerShape(
                            topStart = 30.dp,
                            topEnd = 30.dp,
                            bottomStart = 10.dp,
                            bottomEnd = 10.dp
                        )
                    ) {
                        Column (modifier = Modifier.padding(16.dp)){
                            AsyncImage(
                                model = article.urlToImage,
                                contentDescription = null,
                                placeholder = painterResource(R.drawable.ic_launcher_foreground),
                                modifier = Modifier.fillMaxWidth().height(120.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Author:${article.author.toString()}",

                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "PublishedAt: ${article.publishedAt.toString()}",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Description: ${article.description.toString()}",
                style= TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp,
                    lineHeight = 20.sp
                )
            )
        }
    }
}