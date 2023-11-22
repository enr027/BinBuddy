package com.example.binbuddy

/**
 * JobData data class that will hold the data of each job to be done
 */
data class JobData(val trash : String? = null,
                   val amount : String? = null,
                   val date : String? = null,
                   val address : String? = null)
