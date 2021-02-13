package com.knoldus.validator

class EmailValidator {

  /* In the below method we are checking is the email entered valid or invalid,
  * with the help of regex
   */
  def emailIdIsValid(emailId: String): Boolean = {
    val regex = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+(?:[A-Z]{2}|com|org|net|gov|mil|biz|info|mobi|name|aero|jobs|museum)\\b"
    return emailId.matches(regex)
  }

}
