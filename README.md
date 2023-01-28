# PhotoView for Jetpack Compose

This library provides alternative implementation of PhotoView for Jetpack Compose.

<a href="https://opensource.org/licenses/Apache-2.0"><img src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
<a href="https://developer.android.com"><img src="http://img.shields.io/badge/platform-android-green.svg"/></a>
<a href="https://mvnrepository.com/artifact/io.github.fornewid/photo-compose"><img src="https://img.shields.io/maven-central/v/io.github.fornewid/photo-compose"/></a>

![](https://user-images.githubusercontent.com/3405740/215278825-f3d2e5df-6e14-4be6-90be-0c19b67453df.gif)

## Dependency

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
    repositories {
        mavenCentral()
    }
}

buildscript {
    repositories {
        mavenCentral()
    }	
}
```

Then, add the library to your module `build.gradle`
```gradle
dependencies {
    implementation 'io.github.fornewid:photo-compose:<version>'
}
```

## Usage

There is a [sample](https://github.com/fornewid/photo-compose/tree/main/sample) provided which shows how to use the library.

Here is a simple example that works:

```kotlin
val painter = painterResource(R.drawable.image)
val photoState = rememberPhotoState()
photoState.setPhotoIntrinsicSize(painter.intrinsicSize)
PhotoBox(state = photoState) {
    Image(
        painter,
        contentDescription = "image",
        modifier = Modifier.fillMaxSize(),
    )
}
```

## License

Licensed under the Apache 2.0 license. See [LICENSE](https://github.com/fornewid/photo-compose/blob/main/LICENSE) for details.
