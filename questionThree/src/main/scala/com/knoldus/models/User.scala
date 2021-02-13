package com.knoldus.models

/* Here we are creating a model for user with different fields */
case class User(firstName: String,
                lastName: String,
                age: Int,
                salary: Double,
                designation: String,
                companyName: String,
                emailId: String)
