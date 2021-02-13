package com.knoldus.questionTwoTest

import com.knoldus.questionTwo.ImplOfTrait
import org.scalatest.flatspec.AnyFlatSpec

/* In this class we are running our test cases for ImplOfTrait class so that
  * we can check isPalindrome method and FactorialOfValue are executing correctly or not
 */
class ImplOfTraitTest extends AnyFlatSpec {

  /* Here in each test cases we are declaring
   * an object of class for calling the method
   * and then in method's parameter we are passing values to assert them */

  /* Test cases for palindrome*/
  "Number" should "valid if number is zero" in {
    val palindrome = new ImplOfTrait()
    assert(palindrome.isPalindrome(0))
  }

  "Number" should "valid if number is palindrome number" in {
    val palindrome = new ImplOfTrait()
    assert(palindrome.isPalindrome(111))
  }

  "Number" should "invalid if number is negative" in {
    val palindrome = new ImplOfTrait()
    assert(!palindrome.isPalindrome(-72))
  }

  "Number" should "invalid if number is non palindrome number" in {
    val palindrome = new ImplOfTrait()
    assert(!palindrome.isPalindrome(12))
  }

  /* Test cases for factorial*/
  "Number" should "be valid " in {
    val factorial = new ImplOfTrait()
    assert(factorial.FactorialOfValue(4)===24)
  }

  "Number" should "be invalid " in {
    val factorial = new ImplOfTrait()
    assert(!(factorial.FactorialOfValue(6)===72))
  }

  "Number" should "be valid if number is zero " in {
    val factorial = new ImplOfTrait()
    assert(factorial.FactorialOfValue(0)===1)
  }

}
