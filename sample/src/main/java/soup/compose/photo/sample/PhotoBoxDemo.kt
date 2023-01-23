package soup.compose.photo.sample

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.launch
import soup.compose.photo.ExperimentalPhotoApi
import soup.compose.photo.PhotoBox
import soup.compose.photo.rememberPhotoState

@OptIn(ExperimentalPhotoApi::class)
@Composable
fun PhotoBoxDemo() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "PhotoBoxDemo") })
        }
    ) { padding ->
        val painter = painterResource(R.drawable.wallpaper)
        val photoState = rememberPhotoState()
        photoState.setPhotoIntrinsicSize(painter.intrinsicSize)
        PhotoBox(
            state = photoState,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        ) {
            Image(
                painter,
                contentDescription = "drawable",
                modifier = Modifier.fillMaxSize(),
            )
        }

        val coroutineScope = rememberCoroutineScope()
        BackHandler(enabled = photoState.isScaled) {
            coroutineScope.launch {
                photoState.animateToInitialState()
            }
        }
    }
}
