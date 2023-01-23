package soup.compose.photo.sample

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerScope
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import soup.compose.photo.ExperimentalPhotoApi
import soup.compose.photo.PhotoBox
import soup.compose.photo.rememberPhotoState

@OptIn(
    ExperimentalPagerApi::class,
    ExperimentalPhotoApi::class,
)
@Composable
fun PhotoBoxInPagerDemo() {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "PhotoBoxWithPagerDemo")
            })
        }
    ) { padding ->
        LoopHorizontalPager(
            count = 6,
            contentPadding = padding,
        ) { page ->
            Box(contentAlignment = Alignment.Center) {
                val photoState = rememberPhotoState()
                val painter = painterResource(R.drawable.wallpaper)
                photoState.setPhotoIntrinsicSize(painter.intrinsicSize)
                PhotoBox(state = photoState) {
                    Image(
                        painter,
                        contentDescription = "image $page",
                        modifier = Modifier.fillMaxSize(),
                    )
                }
                Text(
                    text = "Page $page",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                )

                val coroutineScope = rememberCoroutineScope()
                BackHandler(enabled = photoState.isScaled) {
                    coroutineScope.launch {
                        photoState.animateToInitialState()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun LoopHorizontalPager(
    count: Int,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: @Composable PagerScope.(page: Int) -> Unit,
) {
    val startIndex = Int.MAX_VALUE / 2
    val pagerState = rememberPagerState(initialPage = startIndex)
    HorizontalPager(
        count = Int.MAX_VALUE,
        state = pagerState,
        modifier = modifier,
        contentPadding = contentPadding,
        content = { index ->
            val page = (index - startIndex).floorMod(count)
            content(page)
        },
    )
}

private fun Int.floorMod(other: Int): Int = when (other) {
    0 -> this
    else -> this - floorDiv(other) * other
}
