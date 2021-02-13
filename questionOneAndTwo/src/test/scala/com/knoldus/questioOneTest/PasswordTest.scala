package com.knoldus.questioOneTest

import com.knoldus.questionOne.Password
import org.scalatest.flatspec.AnyFlatSpec

/* In this class we are running our test cases for password class so that
  * we can check isPasswordValid method is executing correctly or not
 */
class PasswordTest extends AnyFlatSpec{

  /* Here in each test cases we are declaring
   * an object of class for calling the method
   * and then in method's parameter we are passing values to assert them */

  "password" should "be valid" in {
    val password = new Password()
    assert(password.isPasswordValid("Tanishkagarg@04"))
  }

  "password" should "invalid if we have blank space/tabs" in {
    val password = new Password()
    assert(!password.isPasswordValid("Tanishka Garg04@"))
  }

  "password" should "invalid if we do not have at least one digit" in {
    val password = new Password()
    assert(!password.isPasswordValid("TanishkaGarggg@"))
  }

  "password" should "invalid if length is less than 8 " in {
    val password = new Password()
    assert(!password.isPasswordValid("Tani04@"))
  }

  "password" should "invalid if length is greater than 15" in {
    val password = new Password()
    assert(!password.isPasswordValid("TanishkaGarg04@Tanishka"))
  }

  "password" should "invalid if we do not have at least one uppercase" in {
    val password = new Password()
    assert(!password.isPasswordValid("tanishkagarg04@"))
  }

  "password" should "invalid if we do not have at least one lowercase" in {
    val password = new Password()
    assert(!password.isPasswordValid("TANISHKAGARG04@"))
  }

  "password" should "invalid if we do not have at least one special symbol" in {
    val password = new Password()
    assert(!password.isPasswordValid("TanishkaGarg044"))
  }
}
