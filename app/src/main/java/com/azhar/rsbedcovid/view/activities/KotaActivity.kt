package com.azhar.rsbedcovid.view.activities

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.azhar.rsbedcovid.R
import com.azhar.rsbedcovid.model.kota.ModelKotaResult.ModelKota
import com.azhar.rsbedcovid.utils.Constant
import com.azhar.rsbedcovid.view.adapter.KotaAdapter
import com.azhar.rsbedcovid.viewmodel.PrimaryViewModel
import kotlinx.android.synthetic.main.activity_kota.*
import java.util.*

class KotaActivity : AppCompatActivity() {

    lateinit var primaryViewModel: PrimaryViewModel
    lateinit var kotaAdapter: KotaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kota)

        setSupportActionBar(toolbar)
        assert(supportActionBar != null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        tvTitle.setText(Constant.provinsiName)
        linearNoData.setVisibility(View.GONE)

        kotaAdapter = KotaAdapter(this)
        rvDaftarKota.setLayoutManager(LinearLayoutManager(this))
        rvDaftarKota.setAdapter(kotaAdapter)
        rvDaftarKota.setHasFixedSize(true)

        //viewmodel
        primaryViewModel = ViewModelProvider(this, NewInstanceFactory()).get(PrimaryViewModel::class.java)
        primaryViewModel.setKota(Constant.provinsiId)
        progressBar.setVisibility(View.VISIBLE)
        primaryViewModel.getKota().observe(this, Observer<ArrayList<ModelKota?>> { modelKota: ArrayList<ModelKota?> ->
            if (modelKota.size != 0) {
                kotaAdapter.setKotaAdapter(modelKota)
            } else {
                progressBar.setVisibility(View.GONE)
                linearNoData.setVisibility(View.VISIBLE)
                rvDaftarKota.setVisibility(View.GONE)
            }
            progressBar.setVisibility(View.GONE)
        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}