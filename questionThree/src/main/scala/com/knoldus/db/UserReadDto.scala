package com.knoldus.db
import com.knoldus.models.User
import scala.collection.immutable.HashMap

/* In the below class we are,
* Firstly, doing entry in database depending upon the fields defined in the model,
* Secondly, we are mapping them as users using HashMap,
* Thirdly, we have created a method getUserByName where we creating the users
 */
class UserReadDto {
  val tanishkaEmployee : User = User("Tanishka", "garg", 24, 5000000, "Software Enginner" ,"Knoldus", "tanishka.garg@knoldus.com")
  val divyaEmployee: User = User("Divya","gupta" , 24, 7000000, "Software Enginner", "Philips", "divya.gupta@phiplips.com")
  val users: HashMap[String, User] = HashMap("Tanishka" -> tanishkaEmployee, "Divya" -> divyaEmployee)

  def getUserByName(name: String): Option[User] = users.get(name)

}
