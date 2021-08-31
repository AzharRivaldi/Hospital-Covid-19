package com.azhar.rsbedcovid.model.rs.noncovid

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

class ModelHospitalNCvd {
    @SerializedName("hospitals")
    lateinit var hospitals: List<ModelHospitalNCovid>

    inner class ModelHospitalNCovid : Serializable {
        @SerializedName("id")
        lateinit var id: String

        @SerializedName("name")
        lateinit var name: String

        @SerializedName("address")
        lateinit var address: String

        @SerializedName("phone")
        lateinit var phone: String

        @SerializedName("info")
        lateinit var info: String
    }
}