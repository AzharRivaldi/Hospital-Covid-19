package com.azhar.rsbedcovid.model.detail

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Azhar Rivaldi on 11-08-2021
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

class ModelDetailResult {
    @SerializedName("data")
    lateinit var data: ModelData

    inner class ModelData : Serializable {
        @SerializedName("id")
        lateinit var id: String

        @SerializedName("name")
        lateinit var name: String

        @SerializedName("address")
        lateinit var address: String

        @SerializedName("phone")
        lateinit var phone: String

        @SerializedName("bedDetail")
        lateinit var bedDetail: List<BedDetail>

        inner class BedDetail {
            @SerializedName("time")
            lateinit var time: String

            @SerializedName("stats")
            lateinit var stats: ModelStats

            inner class ModelStats {
                @SerializedName("title")
                lateinit var title: String

                @SerializedName("bed_available")
                lateinit var bedAvailable: String

                @SerializedName("bed_empty")
                lateinit var bedEmpty: String

                @SerializedName("queue")
                lateinit var queue: String
            }
        }

    }

}