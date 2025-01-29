package com.prathamngundikere.rovervision.solImages.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.prathamngundikere.rovervision.solImages.domain.model.Photos

@Composable
fun SolPhotoItem(
    modifier: Modifier = Modifier,
    photos: Photos,
    navController: NavController
) {
    Log.d("SolPhotoItem-Image-Src", photos.img_src)
    val imageState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(photos.img_src)
            .size(Size.ORIGINAL)
            .build()
    ).state

    Box(
        modifier = modifier
            .aspectRatio(1f),
        contentAlignment = Alignment.Center
    ) {
        if (imageState is AsyncImagePainter.State.Error) {
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = "Error Icon",
                tint = MaterialTheme.colorScheme.error
            )
        }
        if (imageState is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator()
        }
        if (imageState is AsyncImagePainter.State.Empty) {
            CircularProgressIndicator()
        }
        if (imageState is AsyncImagePainter.State.Success) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = imageState.painter,
                contentDescription = photos.img_src,
                contentScale = ContentScale.Crop
            )
        }
    }
}