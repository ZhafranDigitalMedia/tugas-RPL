package com.example.tugas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tugas.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: JobViewModel by viewModels()
    private val binding: ActivityMainBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            binding.progressCircular.isVisible = false
            val response = viewModel.searchcar("")
            Log.d("CEKDATA", "${response.data}")

            val adater = MainAdapter(response)
            binding.recyclerview.adapter = adater
        }
        binding.search.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                if (query.isEmpty()){
                    Toast.makeText(this@MainActivity, "Pencarian tidak boleh kosong", Toast.LENGTH_SHORT).show()
                    return false
                }
                lifecycleScope.launch {
                    binding.progressCircular.isVisible = false
                    val response = viewModel.searchcar(query)
                    Log.d("CEKDATA","${response.data}")

                    val adapter = MainAdapter(response)
                    binding.recyclerview.adapter = adapter
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }
}