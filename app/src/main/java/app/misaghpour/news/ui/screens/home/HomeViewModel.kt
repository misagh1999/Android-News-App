package app.misaghpour.news.ui.screens.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import app.misaghpour.news.NewsApplication
import app.misaghpour.news.data.NewsRepository
import app.misaghpour.news.model.Article
import kotlinx.coroutines.launch

sealed interface NewsUiState {
    data class Success(val articles: List<Article>): NewsUiState

    object Error: NewsUiState

    object Loading: NewsUiState
}

class HomeViewModel (private val newsRepository: NewsRepository): ViewModel() {

    var newsUiState: NewsUiState by mutableStateOf(NewsUiState.Loading)
        private set

    init {
        getTopHeadlines()
    }

    fun getTopHeadlines(){
        viewModelScope.launch {
            newsUiState = NewsUiState.Loading
            newsUiState = try {
                val response = newsRepository.getTopHeadlines()

                NewsUiState.Success(
                    articles = response.articles
                )
            } catch (e: Exception){
                Log.e("API_ERROR", e.message.toString())
                NewsUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as NewsApplication)
                val newsRepository = application.container.newsRepository
                HomeViewModel(newsRepository = newsRepository)
            }
        }
    }
}