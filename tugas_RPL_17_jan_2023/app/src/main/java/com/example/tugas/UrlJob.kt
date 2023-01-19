package com.example.tugas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tugas.Detail.DetailJob
import com.example.tugas.databinding.ItemUrlBinding

class UrlJob : AppCompatActivity(R.layout.item_url) {

    private val binding: ItemUrlBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.toolbar.setOnClickListener {
            Intent(this@UrlJob, DetailJob::class.java)
            finish()
        }
        val url = intent.getStringExtra(Key_url)
        Log.d("CEKDATA", url.toString())
        binding.webView.loadUrl(url.toString())
    }

    companion object{
        const val Key_url = "Key_url"
    }
}