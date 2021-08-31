package com.azhar.rsbedcovid.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.azhar.rsbedcovid.R
import com.azhar.rsbedcovid.model.provinsi.ModelProvinsiResult.ModelProvinsi
import com.azhar.rsbedcovid.utils.Constant
import com.azhar.rsbedcovid.view.activities.KotaActivity
import kotlinx.android.synthetic.main.list_item_provinsi.view.*
import java.util.*

/**
 * Created by Azhar Rivaldi on 09-08-2021
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

class ProvinsiAdapter(private val context: Context) :
    RecyclerView.Adapter<ProvinsiAdapter.ProvinsiViewHolder>() {

    private val modelProvinsiArrayList = ArrayList<ModelProvinsi>()

    fun setProvinsiAdapter(items: ArrayList<ModelProvinsi>) {
        modelProvinsiArrayList.clear()
        modelProvinsiArrayList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinsiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_provinsi, parent, false)
        return ProvinsiViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProvinsiViewHolder, position: Int) {

        //set data to share & intent
        holder.tvProvinsi.text = modelProvinsiArrayList[position].name

        holder.cvDaftarProvinsi.setOnClickListener {
            Constant.provinsiId = modelProvinsiArrayList[position].id
            Constant.provinsiName = modelProvinsiArrayList[position].name
            val intent = Intent(context, KotaActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return modelProvinsiArrayList.size
    }

    class ProvinsiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cvDaftarProvinsi: CardView
        var tvProvinsi: TextView

        init {
            cvDaftarProvinsi = itemView.cvDaftarProvinsi
            tvProvinsi = itemView.tvProvinsi
        }
    }

}