package com.navikolabs.viewpager2example

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.navikolabs.viewpager2example.databinding.ItemDummyBinding

class DummyAdapter(private val context: Context) :
    RecyclerView.Adapter<DummyAdapter.DummyViewHolder>() {

    private val users = mutableListOf<User>()

    fun setUserList(userList: List<User>) {
        users.clear()
        users.addAll(userList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DummyViewHolder {
        return DummyViewHolder(
            ItemDummyBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DummyViewHolder, position: Int) {
        val user = users[position]
        holder.bindDataToViews(user)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class DummyViewHolder(binding: ItemDummyBinding) : RecyclerView.ViewHolder(binding.root) {
        private val cardView = binding.cvRoot
        private val tvName = binding.tvName

        fun bindDataToViews(user: User) {
            tvName.text = user.name
            cardView.setCardBackgroundColor(ContextCompat.getColor(context, user.bdColor))
        }
    }

}