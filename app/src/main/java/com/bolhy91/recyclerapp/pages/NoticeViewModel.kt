package com.bolhy91.recyclerapp.pages

import androidx.lifecycle.ViewModel
import com.bolhy91.recyclerapp.remote.RecyclerRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.bolhy91.recyclerapp.remote.NoticeListDto
import com.bolhy91.recyclerapp.remote.Resource
import kotlinx.coroutines.launch

@HiltViewModel
class NoticeViewModel @Inject constructor(
    private val recyclerRepositoryImpl: RecyclerRepositoryImpl
) : ViewModel() {
    private val _state: MutableState<NoticeListState> = mutableStateOf(NoticeListState())
    val state: State<NoticeListState> = _state

    init {
        getNotices()
    }

    private fun getNotices() {
        viewModelScope.launch {
            recyclerRepositoryImpl.getNotices()
                .collect { result ->
                    when (result) {
                        is Resource.Error -> {
                            _state.value = _state.value.copy(
                                isLoading = false,
                                error = result.message,
                                products = emptyList()
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
                                    products = result.data,
                                    isLoading = false,
                                    error = null
                                )
                            }
                        }
                    }
                }
        }
    }
}

data class NoticeListState(
    val products: List<NoticeListDto> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

