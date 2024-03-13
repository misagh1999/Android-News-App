package app.misaghpour.news.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import app.misaghpour.news.R

@Composable
fun HomeScreen() {
    Column {
        Text(text = stringResource(R.string.home))
    }
}