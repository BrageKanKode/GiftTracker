package com.example.gifttracker


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.eventsitem.view.*
import com.example.gifttracker.database.EventsDTO

class EventsAdapter(private val context: Context, val lambdaFunction: (EventsDTO) -> Unit) :
    RecyclerView.Adapter<EventsAdapter.ViewHolder>() {

    val eventsList = mutableListOf<EventsDTO>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val event_name = itemView.eventName
        val id = itemView.eventNumber

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.eventsitem, null)
        val holder = ViewHolder(view)
        holder.itemView.setOnClickListener {
            lambdaFunction(eventsList[holder.adapterPosition])
        }
        return holder
    }

    override fun getItemCount(): Int {
        return eventsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.event_name.text = eventsList[position].name
        holder.id.text = eventsList[position].id.toString()
    }

    fun setStudentsList(list: List<EventsDTO>) {
        eventsList.clear()
        eventsList.addAll(list)
        notifyDataSetChanged()
    }

}
