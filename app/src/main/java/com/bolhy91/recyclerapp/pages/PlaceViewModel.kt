package com.bolhy91.recyclerapp.pages

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bolhy91.recyclerapp.remote.PlaceListDto
import com.bolhy91.recyclerapp.remote.RecyclerRepositoryImpl
import com.bolhy91.recyclerapp.remote.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaceViewModel @Inject constructor(
    private val recyclerRepositoryImpl: RecyclerRepositoryImpl
) : ViewModel() {
    private val _state: MutableState<PlaceListState> = mutableStateOf(PlaceListState())
    val state: State<PlaceListState> = _state

    init {
        getPlaces()
    }

    private fun getPlaces() {
        viewModelScope.launch {
            recyclerRepositoryImpl.getPlaces().collect { result ->
                    when (result) {
                        is Resource.Error -> {
                            _state.value = _state.value.copy(
                                isLoading = false, error = result.message, places = emptyList()
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = _state.value.copy(
                                isLoading = false
                            )
                        }
                        is Resource.Success -> {
                            result.data?.let {
                                _state.value = _state.value.copy(
                                    places = result.data, isLoading = false, error = null
                                )
                            }
                        }
                    }
                }
        }
    }

}

data class PlaceListState(
    val places: List<PlaceListDto> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)