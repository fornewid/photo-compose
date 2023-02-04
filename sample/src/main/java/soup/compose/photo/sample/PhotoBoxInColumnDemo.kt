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
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import soup.compose.photo.ExperimentalPhotoApi
import soup.compose.photo.PhotoBox
import soup.compose.photo.rememberPhotoState

@OptIn(ExperimentalPhotoApi::class)
@Composable
fun PhotoBoxInColumnDemo() {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "PhotoBoxInColumnDemo")
            })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState()),
            horizontalAlignment = Alignment.Start,
        ) {
            Spacer(modifier = Modifier.padding(5.dp))
            for (i in 1..20) {
                Text(
                    text = "Item $i",
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Box {
                val photoState = rememberPhotoState()
                val painter = painterResource(R.drawable.wallpaper)
                photoState.setPhotoIntrinsicSize(painter.intrinsicSize)
                PhotoBox(state = photoState) {
                    Image(
                        painter,
                        contentDescription = "image",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                }

                val coroutineScope = rememberCoroutineScope()
                BackHandler(enabled = photoState.isScaled) {
                    coroutineScope.launch {
                        photoState.animateToInitialState()
                    }
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            for (i in 21..40) {
                Text(
                    text = "Item $i",
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
        }
    }
}
