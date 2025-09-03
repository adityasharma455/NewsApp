package com.example.newsapp.persentation.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.Repo.NewRepo
import com.example.newsapp.data.model.ApiResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class NewsAppViewModel() : ViewModel() {
    val repo = NewRepo()
    private val _state = MutableStateFlow(AppState())
     val state = _state.asStateFlow()

    init {
        getHeadLine()
    }
    fun getHeadLine(country: String="US"){
      viewModelScope.launch{
          repo.getHeadLine(country).collectLatest{
              if(it.loading==true){
                  _state.value= AppState(loading = true)
              }else if (it.error.isNullOrBlank().not()){
                  _state.value= AppState(error =it.error)
              }else{

                  _state.value= AppState(data = it.data, loading = false)
                  Log.d("Vdata", "${_state.value.data}")
              }

              }
          }

      }

    fun getEverything(q: String="US"){
        viewModelScope.launch{
            repo.getEverything(q).collectLatest{
                if(it.loading==true){
                    _state.value= AppState(loading = true)
                }else if (it.error.isNullOrBlank().not()){
                    _state.value= AppState(error =it.error)
                }else{
                    _state.value= AppState(data = it.data, loading = false)
                }

            }
        }

    }
    }


data class AppState(
    var loading: Boolean? = false,
    var error : String? = "",
    var data: ApiResponse?= null
)