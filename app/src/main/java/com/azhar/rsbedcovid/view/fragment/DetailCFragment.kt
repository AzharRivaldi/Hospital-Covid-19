package com.azhar.rsbedcovid.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.azhar.rsbedcovid.R
import com.azhar.rsbedcovid.model.detail.ModelDetailResult.ModelData.BedDetail
import com.azhar.rsbedcovid.utils.Constant
import com.azhar.rsbedcovid.view.adapter.DetailAdapter
import com.azhar.rsbedcovid.viewmodel.PrimaryViewModel
import kotlinx.android.synthetic.main.fragment_hospitals.*
import java.util.*

class DetailCFragment : Fragment() {

    lateinit var primaryViewModel: PrimaryViewModel
    lateinit var detailAdapter: DetailAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hospitals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailAdapter = DetailAdapter(context)
        rvDaftarRs.setLayoutManager(LinearLayoutManager(context))
        rvDaftarRs.setAdapter(detailAdapter)
        rvDaftarRs.setHasFixedSize(true)
        linearNoData.setVisibility(View.GONE)

        //viewmodel
        primaryViewModel = ViewModelProvider(this,
            NewInstanceFactory()).get(PrimaryViewModel::class.java)
        primaryViewModel.setDetailsCovid(Constant.hospitalId)
        progressBar.setVisibility(View.VISIBLE)
        primaryViewModel.getDetailsCovid().observe(viewLifecycleOwner, Observer<ArrayList<BedDetail?>> { modelHospital: ArrayList<BedDetail?> ->
            if (modelHospital.size != 0) {
                detailAdapter.setDetailAdapter(modelHospital)
            } else {
                progressBar.setVisibility(View.GONE)
                linearNoData.setVisibility(View.VISIBLE)
                rvDaftarRs.setVisibility(View.GONE)
            }
            progressBar.setVisibility(View.GONE)
        })
    }

}