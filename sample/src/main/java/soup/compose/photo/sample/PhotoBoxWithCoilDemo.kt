package soup.compose.photo.sample

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import kotlinx.coroutines.launch
import soup.compose.photo.ExperimentalPhotoApi
import soup.compose.photo.PhotoBox
import soup.compose.photo.rememberPhotoState

@OptIn(ExperimentalPhotoApi::class)
@Composable
fun PhotoBoxWithCoilDemo() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "PhotoBoxWithCoilDemo") }
            )
        }
    ) { padding ->
        val photoState = rememberPhotoState()
        PhotoBox(
            state = photoState,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        ) {
            AsyncImage(
                model = "https://images.unsplash.com/photo-1577643816920-65b43ba99fba?ixlib=rb-1.2.1&auto=format&fit=crop&w=3300&q=80",
                contentDescription = "coil",
                modifier = Modifier.fillMaxSize(),
                transform = {
                    if (it is AsyncImagePainter.State.Success) {
                        photoState.setPhotoIntrinsicSize(it.painter.intrinsicSize)
                    }
                    it
                }
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
