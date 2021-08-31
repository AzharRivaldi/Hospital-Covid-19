package com.azhar.rsbedcovid.view.activities

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.azhar.rsbedcovid.R
import com.azhar.rsbedcovid.model.detail.ModelLocationResult
import com.azhar.rsbedcovid.utils.Constant
import com.azhar.rsbedcovid.view.adapter.DetailPagerAdapter
import com.azhar.rsbedcovid.viewmodel.PrimaryViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_detail.*

class DetailHospitalsActivity : AppCompatActivity(), OnMapReadyCallback {

    lateinit var primaryViewModel: PrimaryViewModel
    lateinit var googleMaps: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setStatusBar()

        setSupportActionBar(toolbar)
        assert(supportActionBar != null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        //show maps
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
        viewPager.setAdapter(DetailPagerAdapter(supportFragmentManager))
        viewPager.setOffscreenPageLimit(2)
        tabsLayout.setupWithViewPager(viewPager)

        fabPhone.setOnClickListener {
            val intent: Intent
            intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Constant.phoneNumber))
            startActivity(intent)
        }
    }

    override fun onMapReady(gMapReady: GoogleMap) {

        //viewmodel
        primaryViewModel = ViewModelProvider(this,
            NewInstanceFactory()).get(PrimaryViewModel::class.java)
        primaryViewModel.setLocation(Constant.hospitalId)
        primaryViewModel.getLocation().observe(this, { modelData?: ModelLocationResult.ModelData ->

            //get LatLong
            val strLatitude = modelData.lat
            val strLongitude = modelData.long
            googleMaps = gMapReady
            val latLng = LatLng(strLatitude.toDouble(), strLongitude.toDouble())
            googleMaps.addMarker(MarkerOptions().position(latLng).title(Constant.hospitalName))
            googleMaps.moveCamera(CameraUpdateFactory.newLatLng(latLng))
            googleMaps.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(strLatitude.toDouble(),
                strLongitude.toDouble()), 14f))
            googleMaps.uiSettings.setAllGesturesEnabled(true)
            googleMaps.uiSettings.isZoomGesturesEnabled = true
            googleMaps.isTrafficEnabled = true
        })
    }

    private fun setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    companion object {
        fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
            val window = activity.window
            val layoutParams = window.attributes
            if (on) {
                layoutParams.flags = layoutParams.flags or bits
            } else {
                layoutParams.flags = layoutParams.flags and bits.inv()
            }
            window.attributes = layoutParams
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}