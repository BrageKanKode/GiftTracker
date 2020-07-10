package com.example.gifttracker

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gifttracker.data.ExampleItem
import kotlinx.android.synthetic.main.example_item.view.*


class ExampleAdapter(private val mExampleList: ArrayList<ExampleItem>) : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    class ExampleViewHolder(itemView: View, exampleItem: ExampleItem? = null) : RecyclerView.ViewHolder(itemView) {
        var mTextViewLine1: TextView
        var mTextViewLine2: TextView

    companion object{

        const val EVENT_KEY = "EVENT_KEY"
        const val DATE_KEY = "DATE_KEY"
    }

        init {

            val intent = Intent(itemView.context, Main2Activity::class.java)
            mTextViewLine1 = itemView.textView_event
            mTextViewLine2 = itemView.textView_date
            intent.putExtra(EVENT_KEY, exampleItem?.Title)
            intent.putExtra(DATE_KEY, exampleItem?.date)

            itemView.context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val customView = layoutInflater.inflate(R.layout.example_item, parent, false)


        return ExampleViewHolder(customView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = mExampleList[position]
        holder.mTextViewLine1.text = currentItem.Title
        holder.mTextViewLine2.text = currentItem.date


    }

    override fun getItemCount(): Int {
        return mExampleList.size
    }

}