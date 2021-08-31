package com.azhar.rsbedcovid.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.azhar.rsbedcovid.view.fragment.DetailCFragment
import com.azhar.rsbedcovid.view.fragment.DetailNCFragment

/**
 * Created by Azhar Rivaldi on 10-08-2021
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

class DetailPagerAdapter(fragmentManager: FragmentManager)
    : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = DetailCFragment()
            1 -> fragment = DetailNCFragment()
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        var strTitleTabs = ""
        when (position) {
            0 -> strTitleTabs = "Covid-19"
            1 -> strTitleTabs = "Non Covid-19"
        }
        return strTitleTabs
    }

}