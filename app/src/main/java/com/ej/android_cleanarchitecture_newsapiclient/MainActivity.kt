package com.ej.android_cleanarchitecture_newsapiclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.ej.android_cleanarchitecture_newsapiclient.databinding.ActivityMainBinding
import com.ej.android_cleanarchitecture_newsapiclient.presentation.adapter.NewsAdapter
import com.ej.android_cleanarchitecture_newsapiclient.presentation.viewmodel.NewsViewModel
import com.ej.android_cleanarchitecture_newsapiclient.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory:NewsViewModelFactory


    @Inject
    lateinit var newsAdapter:NewsAdapter

    lateinit var viewModel : NewsViewModel
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFramgment  = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFramgment.navController
        binding.bnvNews.setupWithNavController(
            navController
        )

        viewModel = ViewModelProvider(this,factory)
            .get(NewsViewModel::class.java)
    }
}