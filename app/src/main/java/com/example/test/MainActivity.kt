package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),getTotal{
    var mListOfPrice=ArrayList<Price>(10)
    var total=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in 0..9){
            mListOfPrice.add(i, Price(0,0,0))
        }
        recyclerView.layoutManager=LinearLayoutManager(this)
        val adapter=ListAdapter(this,mListOfPrice)
        recyclerView.adapter=adapter

        calculate.setOnClickListener(){
            txtCalculatedTotal.text=total.toString()
        }
    }

    override fun itemClick(mList: ArrayList<Price>) {
          Log.e("aaaaaaaaaaaaa",""+mList.size)

        for (i in 0 until mList.size){
            total=total+mList[i].total
        }
    }



}
