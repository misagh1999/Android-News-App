package app.misaghpour.news.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.misaghpour.news.ui.theme.NewsTheme
import app.misaghpour.news.ui.theme.Purple40

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.Newspaper,
            tint = Purple40,
            contentDescription = "news",
            modifier = Modifier.size(48.dp)
        )
        Text(text = "News App", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Developed by Mohammadhossein Misaghpour", style = TextStyle(fontSize = 13.sp))
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    NewsTheme {
        SplashScreen()
    }
}
