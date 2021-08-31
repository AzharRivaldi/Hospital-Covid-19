package com.azhar.rsbedcovid.view.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.azhar.rsbedcovid.R
import com.azhar.rsbedcovid.utils.Constant
import com.azhar.rsbedcovid.view.adapter.HospitalsPagerAdapter
import kotlinx.android.synthetic.main.activity_hospitals.*

class HospitalsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospitals)

        setSupportActionBar(toolbar)
        assert(supportActionBar != null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        tvTitle.setText(Constant.kotaName)

        viewPager.setAdapter(HospitalsPagerAdapter(supportFragmentManager))
        viewPager.setOffscreenPageLimit(2)
        tabsLayout.setupWithViewPager(viewPager)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}