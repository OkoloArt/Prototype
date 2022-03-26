package com.example.prototype

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LanguageAdapter(
    private val context: Context,
    private val dataSet: List<Languages>,
    private val onItemClicked: (Languages) -> Unit
) : RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    class LanguageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.country_name)
        val imageView: ImageView = view.findViewById(R.id.tick)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val language = dataSet[position]
        holder.textView.text = language.name
        holder.imageView.setImageResource(language.greenTick)
        if (context is LanguageDetail) {
            context.testing(position, holder.imageView)
        }
        holder.itemView.setOnClickListener {
            onItemClicked(language)
        }
    }


    override fun getItemCount() = dataSet.size
}