package com.prathamngundikere.rovervision.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prathamngundikere.rovervision.home.util.SolListState

@Composable
fun SolListScreen(
    modifier: Modifier = Modifier,
    solListState: SolListState,
    navController: NavController
) {

    val rememberLazyGridState = rememberLazyGridState()

    if (solListState.isLoading) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyVerticalGrid (
            modifier = modifier
                .fillMaxSize(),
            state = rememberLazyGridState,
            contentPadding = PaddingValues(15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            columns = GridCells.Fixed(3)
        ) {
            items(
                items = solListState.photoList,
                key = {
                    it.sol
                }
            ) {
                SolListItem(
                    photo = it,
                    navController = navController
                )
            }
        }
    }
}