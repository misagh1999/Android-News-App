package app.misaghpour.news.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import app.misaghpour.news.model.Article

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory),
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.newsUiState

    Column {
        when(uiState){
            is NewsUiState.Loading -> {
                Text(text = "Loading")
            }
            is NewsUiState.Success -> {
                ArticleList(articles = uiState.articles)
            }
            is NewsUiState.Error -> {
                Text(text = "error")
            }
        }

    }
}

@Composable
fun ArticleList(
    articles: List<Article>,
    modifier: Modifier = Modifier) {
    LazyColumn {
        items(articles){article ->
            Column {
                Text(text = article.title ?: "---", style = TextStyle(fontWeight = FontWeight.Bold))
                Text(text = article.description ?: "****")
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}