package com.example.tugas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tugas.databinding.ItemJobBinding
import com.example.tugas.model.Data
import com.example.tugas.model.JobResponse

class MainAdapter(private val job: JobResponse): RecyclerView.Adapter<MainAdapter.JobViewHolder>() {

    class JobViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding : ItemJobBinding by viewBinding()

        fun bindView(item: Data) = with(binding){
            companyName.text = "Company name : ${item.company_name}"
            title.text = "Title : ${item.title}"
            location.text= "Job area : ${item.location}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_job, parent, false)
        return JobViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val item = job.data[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return job.data.size
    }
}