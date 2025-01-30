package com.prathamngundikere.rovervision.solImages.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prathamngundikere.rovervision.solImages.util.SolPhotoState

@Composable
fun SolPhotoScreen(
    modifier: Modifier = Modifier,
    solPhotoState: SolPhotoState,
    navController: NavController,
    photoId: Int,
    id: (Int) -> Unit
) {
    LaunchedEffect(photoId) {
        id(photoId)
    }

    val rememberLazyListState = rememberLazyListState()

    if (solPhotoState.isLoading) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn (
            modifier = modifier.fillMaxSize(),
            state = rememberLazyListState,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(
                items = solPhotoState.photosList,
                key = {
                    it.id
                }
            ) {
                SolPhotoItem(
                    photos = it
                )
            }
        }
    }
}