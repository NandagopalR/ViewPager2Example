package com.navikolabs.viewpager2example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.navikolabs.viewpager2example.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DummyAdapter
    private var users = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUserList()
        adapter = DummyAdapter(this)
        viewpager.adapter = adapter
        adapter.setUserList(users)

        with(binding.viewpager) {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = users.size
        }

        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin)
        val offsetPx = resources.getDimensionPixelOffset(R.dimen.offset)
        binding.viewpager.setPageTransformer(MultiScreenTransformer(offsetPx, pageMarginPx))
    }

    private fun setUserList() {
        for (i in 0..10) {
            users.add(User("Name - $i", R.color.teal_200))
        }
    }
}