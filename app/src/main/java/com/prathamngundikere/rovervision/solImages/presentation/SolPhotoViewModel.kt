package com.prathamngundikere.rovervision.solImages.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prathamngundikere.rovervision.core.util.Resource
import com.prathamngundikere.rovervision.solImages.domain.repository.SolPhotosRepository
import com.prathamngundikere.rovervision.solImages.util.SolPhotoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SolPhotoViewModel @Inject constructor(
    private val solPhotosRepository: SolPhotosRepository
): ViewModel() {

    private var _solPhotoState = MutableStateFlow(SolPhotoState())
    var solPhotoState = _solPhotoState.asStateFlow()

    fun getSolPhotoList(sol: Int) {
        viewModelScope.launch {
            _solPhotoState.update {
                it.copy(isLoading = true)
            }

            solPhotosRepository.getSolPhotoList(sol).collectLatest {
                when(it) {
                    is Resource.Error -> {
                        _solPhotoState.update {
                            it.copy(isLoading = false)
                        }
                    }
                    is Resource.Loading -> {
                        _solPhotoState.update {
                            it.copy(isLoading = it.isLoading)
                        }
                    }
                    is Resource.Success -> {
                        it.data?.let { photoList ->
                            _solPhotoState.update {
                                it.copy(
                                    photosList = photoList
                                )
                            }
                        }
                        _solPhotoState.update {
                            it.copy(isLoading = false)
                        }
                    }
                }
            }
        }
    }
}