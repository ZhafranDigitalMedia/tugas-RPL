package com.example.tugas.Detail

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tugas.MainActivity
import com.example.tugas.R
import com.example.tugas.UrlJob
import com.example.tugas.databinding.ItemDetailBinding

class DetailJob : AppCompatActivity(R.layout.item_detail) {
    val binding: ItemDetailBinding by viewBinding()
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = intent.extras
        val company = bundle?.getString(Key_company)
        val job = bundle?.getString(Key_job)
        val title = bundle?.getString(Key_Title)
        val location = bundle?.getString(Key_Location)
        val tag = bundle?.getString(Key_Tags)
        val url = bundle?.getString(Key_url)

        binding.company.text = "$company"
        binding.job.text = "$job"
        binding.Tags.text = "$tag"
        binding.location.text = "$location"
        binding.title.text = "$title"
        binding.MoreInformation.setOnClickListener {
            val intent = Intent(this@DetailJob, UrlJob::class.java)
            intent.putExtra(UrlJob.Key_url, url)
            startActivity(intent)
        }

        binding.toolbar.setOnClickListener {
            Intent(this@DetailJob, MainActivity::class.java)
            finish()
        }

    }

    companion object {
        const val Key_url = "Key_url"
        const val Key_Tags = "Key_Tags"
        const val Key_company = "Key_company"
        const val Key_job = "Key_job"
        const val Key_Title = "Key_Title"
        const val Key_Location = "Key_Location"
    }
}