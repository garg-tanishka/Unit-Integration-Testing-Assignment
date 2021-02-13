package com.knoldus.questionTwo

/* In this class we are extending the Trait and writing the body of the methods */
class ImplOfTrait extends DefinitionOfTrait {

  /* In the below method we are checking is the number palindrome or not,
  * by reversing the entered number and then checking
  * if reverse number == input number then palindrome number
  * else not a palindrome number
   */
  def isPalindrome(inputNumber: Int): Boolean = {
    var temporaryNumber = 0
    var reverseNumber = 0
    temporaryNumber = inputNumber
    while (temporaryNumber != 0) {
      var digit = temporaryNumber % 10
      reverseNumber = reverseNumber * 10 + digit
      temporaryNumber /= 10
    }
    if (reverseNumber == inputNumber) {
      true
    }
    else {
      false
    }
  }

  /* In the below method we are printing the factorial of the number,
  * by iterating method
   */
  def FactorialOfValue(inputNumber: Int): Int = {
    var factorial = 1
    for ( iterator <- 1 to inputNumber){
      factorial = factorial * iterator
    }
    return factorial
  }

}
