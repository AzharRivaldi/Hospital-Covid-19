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
import com.azhar.rsbedcovid.model.rs.covid.ModelHospitalCvd.ModelHospitalC
import com.azhar.rsbedcovid.utils.Constant
import com.azhar.rsbedcovid.view.adapter.HospitalsCAdapter
import com.azhar.rsbedcovid.viewmodel.PrimaryViewModel
import kotlinx.android.synthetic.main.fragment_hospitals.*
import java.util.*

class HospitalCFragment : Fragment() {

    lateinit var primaryViewModel: PrimaryViewModel
    lateinit var hospitalsCAdapter: HospitalsCAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hospitals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hospitalsCAdapter = HospitalsCAdapter(context)
        rvDaftarRs.setLayoutManager(LinearLayoutManager(context))
        rvDaftarRs.setAdapter(hospitalsCAdapter)
        rvDaftarRs.setHasFixedSize(true)
        linearNoData.setVisibility(View.GONE)

        //viewmodel
        primaryViewModel = ViewModelProvider(this,
            NewInstanceFactory()).get(PrimaryViewModel::class.java)
        primaryViewModel.setHospitalsCovid(Constant.provinsiId, Constant.kotaId)
        progressBar.setVisibility(View.VISIBLE)
        primaryViewModel.getHospitalsCovid().observe(viewLifecycleOwner, Observer<ArrayList<ModelHospitalC?>> { modelHospital: ArrayList<ModelHospitalC?> ->
            if (modelHospital.size != 0) {
                hospitalsCAdapter.setHospitalAdapter(modelHospital)
            } else {
                progressBar.setVisibility(View.GONE)
                linearNoData.setVisibility(View.VISIBLE)
                rvDaftarRs.setVisibility(View.GONE)
            }
            progressBar.setVisibility(View.GONE)
        })
    }

}