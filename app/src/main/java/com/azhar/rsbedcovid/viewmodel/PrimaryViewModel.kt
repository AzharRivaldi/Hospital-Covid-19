package com.azhar.rsbedcovid.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azhar.rsbedcovid.model.detail.ModelDetailResult
import com.azhar.rsbedcovid.model.detail.ModelDetailResult.ModelData.BedDetail
import com.azhar.rsbedcovid.model.detail.ModelLocationResult
import com.azhar.rsbedcovid.model.kota.ModelKotaResult
import com.azhar.rsbedcovid.model.kota.ModelKotaResult.ModelKota
import com.azhar.rsbedcovid.model.provinsi.ModelProvinsiResult
import com.azhar.rsbedcovid.model.provinsi.ModelProvinsiResult.ModelProvinsi
import com.azhar.rsbedcovid.model.rs.covid.ModelHospitalCvd
import com.azhar.rsbedcovid.model.rs.covid.ModelHospitalCvd.ModelHospitalC
import com.azhar.rsbedcovid.model.rs.noncovid.ModelHospitalNCvd
import com.azhar.rsbedcovid.model.rs.noncovid.ModelHospitalNCvd.ModelHospitalNCovid
import com.azhar.rsbedcovid.networking.ApiClient
import com.azhar.rsbedcovid.networking.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * Created by Azhar Rivaldi on 09-08-2021
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

class PrimaryViewModel : ViewModel() {

    private val modelProvinsiMutableLiveData = MutableLiveData<ArrayList<ModelProvinsi>>()
    private val modelKotaMutableLiveData = MutableLiveData<ArrayList<ModelKota>>()
    private val modelHospitalCovidMutableLiveData = MutableLiveData<ArrayList<ModelHospitalC>>()
    private val modelHospitalNonCovidMutableLiveData = MutableLiveData<ArrayList<ModelHospitalNCovid>>()
    private val modelDataMutableLiveData = MutableLiveData<ArrayList<BedDetail>>()
    private val modelLocationMutableLiveData = MutableLiveData<ModelLocationResult.ModelData>()

    //method provinsi
    fun setProvinsi() {
        val apiService: ApiInterface = ApiClient.getClient()
        val call = apiService.getListProvinces()
        call.enqueue(object : Callback<ModelProvinsiResult> {
            override fun onResponse(call: Call<ModelProvinsiResult>,
                                    response: Response<ModelProvinsiResult>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString())
                } else if (response.body() != null) {
                    val items = ArrayList(response.body().provinces)
                    modelProvinsiMutableLiveData.postValue(items)
                }
            }

            override fun onFailure(call: Call<ModelProvinsiResult>, t: Throwable) {
                Log.e("failure", t.toString())
            }
        })
    }

    //method kota
    fun setKota(ProvinsiId: String) {
        val apiService: ApiInterface = ApiClient.getClient()
        val call = apiService.getListCity(ProvinsiId)
        call.enqueue(object : Callback<ModelKotaResult> {
            override fun onResponse(call: Call<ModelKotaResult>, response: Response<ModelKotaResult>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString())
                } else if (response.body() != null) {
                    val items = ArrayList(response.body().cities)
                    modelKotaMutableLiveData.postValue(items)
                }
            }

            override fun onFailure(call: Call<ModelKotaResult>, t: Throwable) {
                Log.e("failure", t.toString())
            }
        })
    }

    //method rs covid
    fun setHospitalsCovid(ProvinsiId: String, KotaId: String) {
        val apiService: ApiInterface = ApiClient.getClient()
        val call = apiService.getListHospitalsCovid(ProvinsiId, KotaId, "1")
        call.enqueue(object : Callback<ModelHospitalCvd> {
            override fun onResponse(call: Call<ModelHospitalCvd>, response: Response<ModelHospitalCvd>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString())
                } else if (response.body() != null) {
                    val items = ArrayList(response.body().hospitals)
                    modelHospitalCovidMutableLiveData.postValue(items)
                }
            }

            override fun onFailure(call: Call<ModelHospitalCvd>, t: Throwable) {
                Log.e("failure", t.toString())
            }
        })
    }

    //method rs non covid
    fun setHospitalsNonCovid(ProvinsiId: String, KotaId: String) {
        val apiService: ApiInterface = ApiClient.getClient()
        val call = apiService.getListHospitalsNonCovid(ProvinsiId, KotaId, "2")
        call.enqueue(object : Callback<ModelHospitalNCvd> {
            override fun onResponse(call: Call<ModelHospitalNCvd>, response: Response<ModelHospitalNCvd>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString())
                } else if (response.body() != null) {
                    val items = ArrayList(response.body().hospitals)
                    modelHospitalNonCovidMutableLiveData.postValue(items)
                }
            }

            override fun onFailure(call: Call<ModelHospitalNCvd>, t: Throwable) {
                Log.e("failure", t.toString())
            }
        })
    }

    //method detail rs covid
    fun setDetailsCovid(HospitalId: String) {
        val apiService: ApiInterface = ApiClient.getClient()
        val call = apiService.getListDetails(HospitalId, "1")
        call.enqueue(object : Callback<ModelDetailResult> {
            override fun onResponse(call: Call<ModelDetailResult>, response: Response<ModelDetailResult>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString())
                } else if (response.body() != null) {
                    val items = ArrayList(response.body().data.bedDetail)
                    modelDataMutableLiveData.postValue(items)
                }
            }

            override fun onFailure(call: Call<ModelDetailResult>, t: Throwable) {
                Log.e("failure", t.toString())
            }
        })
    }

    //method detail rs non covid
    fun setDetailsNonCovid(HospitalId: String) {
        val apiService: ApiInterface = ApiClient.getClient()
        val call = apiService.getListDetails(HospitalId, "2")
        call.enqueue(object : Callback<ModelDetailResult> {
            override fun onResponse(call: Call<ModelDetailResult>, response: Response<ModelDetailResult>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString())
                } else if (response.body() != null) {
                    val items = ArrayList(response.body().data.bedDetail)
                    modelDataMutableLiveData.postValue(items)
                }
            }

            override fun onFailure(call: Call<ModelDetailResult>, t: Throwable) {
                Log.e("failure", t.toString())
            }
        })
    }

    //method map lokasi
    fun setLocation(HospitalId: String) {
        val apiService: ApiInterface = ApiClient.getClient()
        val call = apiService.getMapLocation(HospitalId)
        call.enqueue(object : Callback<ModelLocationResult> {
            override fun onResponse(call: Call<ModelLocationResult>,
                                    response: Response<ModelLocationResult>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString())
                } else if (response.body() != null) {
                    modelLocationMutableLiveData.postValue(response.body().data)
                }
            }

            override fun onFailure(call: Call<ModelLocationResult>, t: Throwable) {
                Log.e("failure", t.toString())
            }
        })
    }

    fun getProvinsi(): LiveData<ArrayList<ModelProvinsi>> = modelProvinsiMutableLiveData

    fun getKota(): LiveData<ArrayList<ModelKota>> = modelKotaMutableLiveData

    fun getHospitalsCovid(): LiveData<ArrayList<ModelHospitalC>> = modelHospitalCovidMutableLiveData

    fun getHospitalsNonCovid(): LiveData<ArrayList<ModelHospitalNCovid>> = modelHospitalNonCovidMutableLiveData

    fun getDetailsCovid(): LiveData<ArrayList<BedDetail>> = modelDataMutableLiveData

    fun getDetailsNonCovid(): LiveData<ArrayList<BedDetail>> = modelDataMutableLiveData

    fun getLocation(): LiveData<ModelLocationResult.ModelData> = modelLocationMutableLiveData
}