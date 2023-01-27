/*
 * Copyright 2023 SOUP
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
