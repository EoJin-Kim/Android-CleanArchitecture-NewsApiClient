package com.ej.android_cleanarchitecture_newsapiclient.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.*
import com.ej.android_cleanarchitecture_newsapiclient.data.model.APIResponse
import com.ej.android_cleanarchitecture_newsapiclient.data.model.Article
import com.ej.android_cleanarchitecture_newsapiclient.data.util.Resource
import com.ej.android_cleanarchitecture_newsapiclient.domain.usecase.GetNewsHeadlinesUseCase
import com.ej.android_cleanarchitecture_newsapiclient.domain.usecase.GetSavedNewsUseCase
import com.ej.android_cleanarchitecture_newsapiclient.domain.usecase.GetSearchedNewsUseCase
import com.ej.android_cleanarchitecture_newsapiclient.domain.usecase.SaveNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsViewModel(
    private val app:Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getSavedNewsUseCase: GetSavedNewsUseCase
) : AndroidViewModel(app) {
    val newsHeadLines : MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getNewsHeadLines(country:String,page:Int){
        newsHeadLines.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {
                viewModelScope.launch(Dispatchers.IO) {
                    val apiResult = getNewsHeadlinesUseCase.excute(country, page)
                    newsHeadLines.postValue(apiResult)
                }
            }
            else {
                newsHeadLines.postValue(Resource.Error("Internet is not available"))
            }
        } catch (e: Exception) {
            newsHeadLines.postValue(Resource.Error(e.message.toString()))
        }


    }
    private fun isNetworkAvailable(context: Context?):Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }

    //search
    val searchedNews:MutableLiveData<Resource<APIResponse>> = MutableLiveData()
    fun searchNews(
        country: String,
        searchQuery:String,
        page:Int
    ) = viewModelScope.launch {
        searchedNews.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {
                val response = getSearchedNewsUseCase.excute(country, searchQuery, page)
                searchedNews.postValue(response)
            }
            else{
                searchedNews.postValue(Resource.Error("No internet connection"))
            }
        }catch (e:Exception){
            searchedNews.postValue(Resource.Error(e.message.toString()))
        }

    }

    fun saveArticle(article: Article) {
        viewModelScope.launch {
            saveNewsUseCase.excute(article)
        }
    }

    fun getSavedNews() = liveData {
        getSavedNewsUseCase.excute().collect{
            emit(it)
        }
    }

}