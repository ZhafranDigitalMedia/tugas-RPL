package com.example.tugas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tugas.Detail.DetailJob
import com.example.tugas.databinding.ActivityMainBinding
import com.example.tugas.model.JobResponse
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

            adater.itemJobClickListener={it ->
                val url = it.url
                val compony = it.company_name
                val title = it.title
                val job = it.job_types
                val tag = it.tags
                val location = it.location
                val bundle = Bundle()
                bundle.putString(DetailJob.Key_url,url)
                bundle.putString(DetailJob.Key_company,compony)
                bundle.putString(DetailJob.Key_Title,title)
                bundle.putString(DetailJob.Key_job,job.toString())
                bundle.putString(DetailJob.Key_Tags,tag.toString())
                bundle.putString(DetailJob.Key_Location,location)
                val intent = Intent(this@MainActivity,DetailJob::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
//        binding.search.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String): Boolean {
//                if (query.isEmpty()){
//                    Toast.makeText(this@MainActivity, "Pencarian tidak boleh kosong", Toast.LENGTH_SHORT).show()
//                    return false
//                }
//                lifecycleScope.launch {
//                    binding.progressCircular.isVisible = false
//                    val response = viewModel.searchcar(query)
//                    Log.d("CEKDATA","${response.data}")
//
//                    val adapter = MainAdapter(response)
//                    binding.recyclerview.adapter = adapter
//
//                }
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return false
//            }
//
//        })
    }
}