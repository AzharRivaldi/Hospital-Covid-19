package com.azhar.rsbedcovid.model.rs.covid

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Azhar Rivaldi on 10-08-2021
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

class ModelHospitalCvd {
    @SerializedName("hospitals")
    lateinit var hospitals: List<ModelHospitalC>

    inner class ModelHospitalC : Serializable {
        @SerializedName("id")
        lateinit var id: String

        @SerializedName("name")
        lateinit var name: String

        @SerializedName("address")
        lateinit var address: String

        @SerializedName("phone")
        var phone: String? = null

        @SerializedName("queue")
        lateinit var queue: String

        @SerializedName("bed_availability")
        lateinit var bedAvailability: String

        @SerializedName("info")
        var info: String? = null
    }

}