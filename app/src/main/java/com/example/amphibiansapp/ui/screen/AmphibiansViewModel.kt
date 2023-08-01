package com.example.amphibiansapp.ui.screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibiansapp.data.AmphibiansPhotos
import com.example.amphibiansapp.network.AmphibiansRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibiansapp.AmphibiansApplication
import retrofit2.HttpException
import java.io.IOException

sealed interface AmphibiansUiState {
    data class Success (val photos: List<AmphibiansPhotos>): AmphibiansUiState
    object Loading : AmphibiansUiState
    object Error: AmphibiansUiState
}

class AmphibiansViewModel (private val amphibiansRepository: AmphibiansRepository) : ViewModel(){
    var amphiUiState : AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
    private set

    init {
        getPhotos()
    }

    private fun getPhotos(){
        viewModelScope.launch{

            amphiUiState = try {
                AmphibiansUiState.Success(amphibiansRepository.getAnimalPhotos())
            }
                catch (e: IOException) {
                    AmphibiansUiState.Error
                }
            catch (e: HttpException) {
                AmphibiansUiState.Error
            }
        }

    }
    companion object {
        val Factory:
                ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AmphibiansApplication)
                val amphiPhotosRepository = application.container.amphibiansRepository
                AmphibiansViewModel(amphibiansRepository = amphiPhotosRepository)
            }
        }
    }
}