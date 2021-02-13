package com.knoldus.Validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.{Company, User}
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.mockito.MockitoSugar.{mock, when}

/* In the below class, for each test case
* we are mocking CompanyReadDto and EmailValidator upon which UserValidator depends,
* Then, While creating an object for UserValidator class we passed on the mocked parameter.
* And, then we are matching our arguments combinations by using stub methods (when, thenReturn) using Mockito functions.
* Finally, we are creating a variable in which we are accessing the userIsValid method
* with the help of object created, then in the parameters we are passing tanishkaEmployee
 */
class UserValidatorTest extends org.scalatest.flatspec.AnyFlatSpec {

  val tanishkaEmployee : User = User("Tanishka", "garg", 24, 5000000, "Software Enginner" ,"Knoldus", "tanishka.garg@knoldus.com")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  val mockedCompanyReadDto = mock[CompanyReadDto]
  val mockedEmail = mock[EmailValidator]


  "User" should "be a valid User because Company exist in DB and email is valid" in{

    when(mockedCompanyReadDto.getCompanyByName(tanishkaEmployee.companyName)) thenReturn (Option(knoldusCompany))
    when(mockedEmail.emailIdIsValid(tanishkaEmployee.emailId)) thenReturn(true)

    val uservalidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = uservalidator.userIsValid(tanishkaEmployee)
    assert(result)

  }

  "User" should "be a invalid because email is not valid" in{

    when(mockedCompanyReadDto.getCompanyByName(tanishkaEmployee.companyName)) thenReturn (Option(knoldusCompany))
    when(mockedEmail.emailIdIsValid(tanishkaEmployee.emailId)) thenReturn(false)

    val uservalidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = uservalidator.userIsValid(tanishkaEmployee)
    assert(!result)

  }

  "User" should "be a invalid because company does not exist in the DB " in{

    when(mockedCompanyReadDto.getCompanyByName(tanishkaEmployee.companyName)) thenReturn(None)
    when(mockedEmail.emailIdIsValid(tanishkaEmployee.emailId)) thenReturn(true)

    val uservalidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = uservalidator.userIsValid(tanishkaEmployee)
    assert(!result)

  }

  "User" should "be a invalid because company does not exist in the DB and email invalid" in{

    when(mockedCompanyReadDto.getCompanyByName(tanishkaEmployee.companyName)) thenReturn(None)
    when(mockedEmail.emailIdIsValid(tanishkaEmployee.emailId)) thenReturn(false)

    val uservalidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = uservalidator.userIsValid(tanishkaEmployee)
    assert(!result)

  }

}
