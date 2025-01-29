package com.prathamngundikere.rovervision.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prathamngundikere.rovervision.core.util.Resource
import com.prathamngundikere.rovervision.home.domain.repository.SolListRepository
import com.prathamngundikere.rovervision.home.util.SolListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SolListViewModel @Inject constructor(
    private val solListRepository: SolListRepository
): ViewModel(){

    private var _solListState = MutableStateFlow(SolListState())
    val solListState = _solListState.asStateFlow()

    init {
        getSolList()
    }

    private fun getSolList() {
        viewModelScope.launch {
            _solListState.update {
                it.copy(isLoading = true)
            }

            solListRepository.getSolList().collectLatest {
                when(it) {
                    is Resource.Error -> {
                        _solListState.update {
                            it.copy(isLoading = false)
                        }
                    }
                    is Resource.Loading -> {
                        _solListState.update {
                            it.copy(
                                isLoading = it.isLoading
                            )
                        }
                    }
                    is Resource.Success -> {
                        it.data?.let { photoList ->
                            _solListState.update {
                                it.copy(
                                    photoList = photoList
                                )
                            }
                        }
                        _solListState.update {
                            it.copy(isLoading = false)
                        }
                    }
                }
            }
        }
    }
}