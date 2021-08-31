package com.azhar.rsbedcovid.networking

import com.azhar.rsbedcovid.model.detail.ModelDetailResult
import com.azhar.rsbedcovid.model.detail.ModelLocationResult
import com.azhar.rsbedcovid.model.kota.ModelKotaResult
import com.azhar.rsbedcovid.model.provinsi.ModelProvinsiResult
import com.azhar.rsbedcovid.model.rs.covid.ModelHospitalCvd
import com.azhar.rsbedcovid.model.rs.noncovid.ModelHospitalNCvd
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Azhar Rivaldi on 18-05-2021
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * Linkedin : https://www.linkedin.com/in/azhar-rivaldi
 */

interface ApiInterface {

    @GET("get-provinces")
    fun getListProvinces() : Call<ModelProvinsiResult>

    @GET("get-cities?")
    fun getListCity(@Query("provinceid") provinceid: String
    ): Call<ModelKotaResult>

    @GET("get-hospitals?")
    fun getListHospitalsCovid(
            @Query("provinceid") provinceid: String,
            @Query("cityid") cityid: String,
            @Query("type") type: String
    ): Call<ModelHospitalCvd>

    @GET("get-hospitals?")
    fun getListHospitalsNonCovid(
            @Query("provinceid") provinceid: String,
            @Query("cityid") cityid: String,
            @Query("type") type: String
    ): Call<ModelHospitalNCvd>

    @GET("get-bed-detail?")
    fun getListDetails(
            @Query("hospitalid") hospitalid: String,
            @Query("type") type: String
    ): Call<ModelDetailResult>

    @GET("get-hospital-map?")
    fun getMapLocation(
            @Query("hospitalid") hospitalid: String
    ): Call<ModelLocationResult>

}