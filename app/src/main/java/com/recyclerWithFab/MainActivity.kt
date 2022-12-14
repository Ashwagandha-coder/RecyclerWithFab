package com.recyclerWithFab

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.recyclerWithFab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapterForRecycler by lazy { AdapterForRecycler(listData()) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView(baseContext)


    }


    private fun setupRecyclerView(context: Context) {


        val listener = object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                // if the recycler view is scrolled
                // above hide the FAB
                if (dy > 10 && binding.fab.isShown) {
                    binding.fab.hide()
                }

                // if the recycler view is
                // scrolled above show the FAB
                if (dy < -10 && !binding.fab.isShown) {
                    binding.fab.show()
                }

                // of the recycler view is at the first
                // item always show the FAB
                if (!recyclerView.canScrollVertically(-1)) {
                    binding.fab.show()
                }

            }

        }

        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = adapterForRecycler
            adapterForRecycler.notifyDataSetChanged()
            addOnScrollListener(listener)
        }
    }


    private fun listData(): List<RecyclerViewData> {

        val list = mutableListOf<RecyclerViewData>()

        for (i in 1..10) {
            list.add(RecyclerViewData(text1 = i.toString(), text2 = (i + 1).toString()))
        }

        return list

    }

}