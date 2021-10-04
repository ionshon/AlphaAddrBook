package com.inu.alphaaddrbook.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import com.inu.alphaaddrbook.R
import com.inu.alphaaddrbook.adapter.MyAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = ListView(this)
        layout_main?.addView(listView)
       // binding.layoutMain.addView(listView)

        val data = ArrayList<Class<*>>()
        data.add(ContactViewActivity::class.java)

        listView.adapter = MyAdapter(data)
        //클릭하여 입력 Activity
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, _, position, _ ->
            val adapter = parent.adapter
            val act = adapter.getItem(position) as Class<*>
            startActivity(Intent(this@MainActivity, act))
        }
    }
}