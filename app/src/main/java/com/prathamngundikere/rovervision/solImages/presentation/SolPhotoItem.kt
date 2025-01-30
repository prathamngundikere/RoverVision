package com.prathamngundikere.rovervision.solImages.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.prathamngundikere.rovervision.solImages.domain.model.Photos

@Composable
fun SolPhotoItem(
    modifier: Modifier = Modifier,
    photos: Photos
) {
    val imageState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(photos.img_src)
            .size(Size.ORIGINAL)
            .build()
    ).state

    Column (
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (imageState is AsyncImagePainter.State.Error) {
            Box(
                modifier = Modifier
                    .height(500.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = "Error Icon",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
        if (imageState is AsyncImagePainter.State.Loading) {
            Box(
                modifier = Modifier
                    .height(500.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        if (imageState is AsyncImagePainter.State.Empty) {
            Box(
                modifier = Modifier
                    .height(500.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        if (imageState is AsyncImagePainter.State.Success) {
            Box(
                modifier = Modifier
                    .height(500.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = imageState.painter,
                    contentDescription = photos.img_src,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}