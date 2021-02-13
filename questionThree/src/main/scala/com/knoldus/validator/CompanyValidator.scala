package com.knoldus.validator

import com.knoldus.models.Company
import com.knoldus.db.CompanyReadDto

class CompanyValidator (companyName: CompanyReadDto, validateEmail: EmailValidator){

  /* In the below method we are checking two conditions, both should be true-
  * Firstly, we are checking the company should not already exist in the database, then
  * Secondly, we are checking the email is valid or not
   */
  def companyIsValid(company: Company): Boolean = {
    if (companyName.getCompanyByName(company.name).isEmpty &&
      validateEmail.emailIdIsValid(company.emailId))
      true
    else
      false
  }
}
