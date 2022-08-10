package com.chinkiandfamily.getdatafrominternet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.chinkiandfamily.getdatafrominternet.adapter.PostAdapter
import com.chinkiandfamily.getdatafrominternet.databinding.ActivityMainBinding
import com.chinkiandfamily.getdatafrominternet.util.ApiState
import com.chinkiandfamily.getdatafrominternet.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding
    private lateinit var postAdapter: PostAdapter
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        if (this::_binding.isInitialized) {
            setContentView(binding.root)
        }
        initRecyclerView()

        mainViewModel.getPost()

        lifecycleScope.launchWhenStarted {
            mainViewModel._postStateFlow.collect { it ->
                when (it) {
                    is ApiState.Loading -> {
                        binding.recyclerView.isVisible = false
                        binding.progressBar.isVisible = true
                    }
                    is ApiState.Failure -> {
                        binding.recyclerView.isVisible = false
                        binding.progressBar.isVisible = false
                        Log.d("MainActivity", "onCreate :: ${it.msg}")
                    }
                    is ApiState.Success -> {
                        binding.recyclerView.isVisible = true
                        binding.progressBar.isVisible = false
                        postAdapter.setData(it.data)
                        postAdapter.notifyDataSetChanged()
                    }
                    is ApiState.Empty -> {}
                }
            }
        }
    }

    private fun initRecyclerView() {
        postAdapter = PostAdapter(ArrayList())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }
}