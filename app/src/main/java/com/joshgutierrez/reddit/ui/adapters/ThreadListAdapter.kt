package com.joshgutierrez.reddit.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joshgutierrez.reddit.R
import com.joshgutierrez.reddit.data.Children
import com.joshgutierrez.reddit.data.threadResult
import com.joshgutierrez.reddit.extensions.ctx
import kotlinx.android.synthetic.main.item_thread.view.*

class ThreadListAdapter(private val threadList: threadResult, val clickListener: (Children) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_thread, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    (holder as ViewHolder).bindChild(threadList.data.children[position], clickListener)
  }


  override fun getItemCount(): Int = threadList.data.children.size

  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bindChild(child: Children, clickListener: (Children) -> Unit) {

      itemView.title.text = child.data.title.orEmpty()

      itemView.num_comments.text = "Comments: " + child.data.num_comments.toString()

      itemView.author_fullname.text = "Author: " + child.data.author_fullname.orEmpty()
      itemView.setOnClickListener { clickListener(child)}
    }
  }


}