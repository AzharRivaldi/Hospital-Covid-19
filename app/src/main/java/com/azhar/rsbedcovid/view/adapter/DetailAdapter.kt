package com.azhar.rsbedcovid.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.azhar.rsbedcovid.R
import com.azhar.rsbedcovid.model.detail.ModelDetailResult.ModelData.BedDetail
import kotlinx.android.synthetic.main.list_item_hospitals_detail.view.*
import java.util.*

/**
 * Created by Azhar Rivaldi on 09-08-2021
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.ProvinsiViewHolder>() {

    private val modelDetailResultArrayList: MutableList<BedDetail> = ArrayList()

    fun setDetailAdapter(items: ArrayList<BedDetail>) {
        modelDetailResultArrayList.clear()
        modelDetailResultArrayList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinsiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_hospitals_detail, parent, false)
        return ProvinsiViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProvinsiViewHolder, position: Int) {

        //set data to share & intent
        holder.tvTimeUpdate.text = modelDetailResultArrayList[position].time
        holder.tvTitle.text = modelDetailResultArrayList[position].stats.title
        holder.tvBedAvailability.text = modelDetailResultArrayList[position].stats.bedAvailable
        holder.tvBedEmpty.text = modelDetailResultArrayList[position].stats.bedEmpty
        holder.tvQueue.text = modelDetailResultArrayList[position].stats.queue
    }

    override fun getItemCount(): Int {
        return modelDetailResultArrayList.size
    }

    class ProvinsiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cvDetailRs: CardView
        var tvTitle: TextView
        var tvBedAvailability: TextView
        var tvBedEmpty: TextView
        var tvQueue: TextView
        var tvTimeUpdate: TextView

        init {
            cvDetailRs = itemView.cvDetailRs
            tvTitle = itemView.tvTitle
            tvBedAvailability = itemView.tvBedAvailability
            tvBedEmpty = itemView.tvBedEmpty
            tvQueue = itemView.tvQueue
            tvTimeUpdate = itemView.tvTimeUpdate
        }
    }

}