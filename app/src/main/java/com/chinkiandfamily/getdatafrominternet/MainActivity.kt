package com.chinkiandfamily.getdatafrominternet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chinkiandfamily.getdatafrominternet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        if (!this::_binding.isInitialized) {
            setContentView(binding.root)
        }
    }
}