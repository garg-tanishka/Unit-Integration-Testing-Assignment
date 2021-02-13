package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}

/* In the below class, for each test case
* we are mocking UserValidator upon which UserImpl depends,
* Then, While creating an object for UserImpl class we passed on the mocked parameter.
* And, then we are matching our arguments combinations by using stub methods (when, thenReturn) using Mockito functions.
* Finally, we are creating a variable in which we are accessing the createUser method
* with the help of object created, then in the parameters we are passing values
 */
class UserImplTest extends org.scalatest.flatspec.AnyFlatSpec{
  val mockedUserValidate = mock[UserValidator]
  val tanishkaUser : User = User("Tanishka", "garg", 24, 5000000, "Software Enginner" ,"Knoldus", "tanishka.garg@knoldus.com")
  val akashUser : User = User("Akash", "tiwari", 24, 500000000, "Software Enginner" ,"Tiwari hoisery", "tiwari.akash@gmail.com")

  "User" should "be valid" in{
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(tanishkaUser)) thenReturn(true)
    val result = userImpl.createUser((tanishkaUser))
    assert(!result.isEmpty)
  }

  "User" should "be not be valid" in{
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(akashUser)) thenReturn(false)
    val result = userImpl.createUser((akashUser))
    assert(result.isEmpty)
  }

}
