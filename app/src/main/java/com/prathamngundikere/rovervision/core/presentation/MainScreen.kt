package com.prathamngundikere.rovervision.core.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prathamngundikere.rovervision.core.util.SolListScreenNav
import com.prathamngundikere.rovervision.home.presentation.SolListScreen
import com.prathamngundikere.rovervision.home.presentation.SolListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val solListViewModel = hiltViewModel<SolListViewModel>()
    val solListState = solListViewModel.solListState.collectAsState().value

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Curiosity Sol List")
                }
            )
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = SolListScreenNav
        ) {
            composable<SolListScreenNav> {
                SolListScreen(
                    modifier = Modifier.padding(padding),
                    solListState = solListState,
                    navController = navController
                )
            }
        }
    }
}