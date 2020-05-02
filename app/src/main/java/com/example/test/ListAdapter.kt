package com.example.test

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapterview.view.*

class ListAdapter ( var itemClickListener: getTotal,val mListOfPrice:ArrayList<Price>): RecyclerView.Adapter<ListAdapter.ViewHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.adapterview,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
       return mListOfPrice.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

       holder.bind()


        holder.edtQunt!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val qnt:Int= holder.edtQunt!!.text.toString().toInt()
                val price:Int= holder.edtPrice!!.text.toString().toInt()
                val total=price*qnt
                holder.txtTotal!!.text=total.toString()


                val data=Price(price,qnt,total)
               mListOfPrice.add(position, data)



            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        holder.edtPrice!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val qnt:Int= holder.edtQunt!!.text.toString().toInt()
                val price:Int= holder.edtPrice!!.text.toString().toInt()
                val total=price*qnt
                holder.txtTotal!!.text=total.toString()


                val data=Price(price,qnt,total)
                mListOfPrice.set(position, data)


            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })


        itemClickListener.itemClick(mListOfPrice)





    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView) {
        var edtPrice:EditText?=null
        var edtQunt:EditText?=null
        var txtTotal:TextView?=null

        fun bind(){
            edtPrice=itemView.edtPrice
            edtQunt=itemView.edtQun
            txtTotal=itemView.txtPrice



        }

    }


}