package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder



class NewsAdapter(private val listener: NewsItemClicked) : RecyclerView.Adapter<NewsViewHolder>() {
     private val items : ArrayList<News> = ArrayList()
    /* below 3 are the members of recyclerview that i have implemented . The 3 are basic steps to implement adapter*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        /* on create is called for all items that are views on the screen */
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener {
            listener.onitemclicked(items[viewHolder.absoluteAdapterPosition])
            //adapter position is returned on click. listener ke paas item jaayega
        }
        /* item news xml file is converted to view by the use of layout inflater */
        return viewHolder
    }

    override fun getItemCount(): Int {
        /* called only first time . tells how many items reside in the list */
        return items.size

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        /* binds the data inside the holder .position tells what item is to be binded*/
        val currentItem = items[position]
        holder.titleView.text = currentItem.title
        holder.author.text = currentItem.author
      //  Glide.with(holder.itemView.context.
    }
    fun updateNews(updatedNews: ArrayList<News>) {
        items.clear()
        items.addAll(updatedNews)
    }
}

class NewsViewHolder(itemView: View) : ViewHolder(itemView){
    val titleView: TextView = itemView.findViewById(androidx.core.R.id.title)
   // val image: ImageView = itemView.findViewById(R.id.image)
    val author : TextView = itemView.findViewById(R.id.author)
    /* added titleview to add the title to the view screen */
}
interface NewsItemClicked {
    fun onitemclicked(item : News)
}

