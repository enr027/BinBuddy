package com.example.binbuddy

/**
 * User data class hold all the information for the user
 */
data class User(val firstName : String? = null,
                val lastName : String? = null,
                val address : String? = null,
                val zip : String? = null,
                val userName : String? = null,
                val email : String? = null,
                val city : String? = null)
