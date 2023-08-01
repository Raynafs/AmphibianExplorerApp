package com.example.amphibiansapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import com.example.amphibiansapp.ui.screen.AmphibiansViewModel
import com.example.amphibiansapp.ui.screen.HomeScreen

@Composable
fun AmphibiansPhotoApp() {

        Surface(
            modifier = Modifier
                .fillMaxSize()

        ) {
            val amphiViewModel: AmphibiansViewModel = viewModel(factory = AmphibiansViewModel.Factory)
            HomeScreen(
                amphiUiState = amphiViewModel.amphiUiState
              )
        }

}
