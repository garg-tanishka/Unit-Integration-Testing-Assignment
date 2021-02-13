package com.knoldus.request

import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator

class CompanyImpl(companyValidator: CompanyValidator) {

  /* In the below method we are checking if the
  * company should not exist in the DB already and
  * the email is valid
  * then we are creating that company with the company name
  * else No
   */
  def createCompany(company: Company): Option[String] = {
    if (companyValidator.companyIsValid(company)) Option(company.name)
    else None
  }
}
