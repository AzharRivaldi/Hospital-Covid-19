package com.azhar.rsbedcovid.model.detail

import com.google.gson.annotations.SerializedName

/**
 * Created by Azhar Rivaldi on 13-08-2021
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

class ModelLocationResult {
    @SerializedName("data")
    lateinit var data: ModelData

    inner class ModelData {
        @SerializedName("id")
        lateinit var id: String

        @SerializedName("name")
        lateinit var name: String

        @SerializedName("address")
        lateinit var address: String

        @SerializedName("lat")
        lateinit var lat: String

        @SerializedName("long")
        lateinit var long: String

        @SerializedName("gmaps")
        lateinit var gmaps: String
    }

}