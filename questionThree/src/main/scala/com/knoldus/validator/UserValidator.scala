package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User

class UserValidator(companyName:CompanyReadDto, validateEmail:EmailValidator) {

  /* In the below method we are checking two conditions, both should be true-
  * Firstly, we are checking the company exist in the database or not , then
  * Secondly, we are checking the email is valid or not
   */
  def userIsValid(user: User): Boolean = {
    if (!companyName.getCompanyByName(user.companyName).isEmpty &&
      validateEmail.emailIdIsValid(user.emailId))
      true
    else
      false
  }
}
