name := "UnitTesting-IntegrationTesting-Assignment"

version := "0.1"

scalaVersion := "2.13.4"

/* Creating a module for question1 and question2 then providing testing dependencies */
lazy val questionOneAndTwo = project.in(file("questionOneAndTwo"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.3" % Test,
      "org.mockito" %% "mockito-scala" % "1.5.12" % Test
    )
  )

/* Creating a module for question3 then providing testing dependencies  */
lazy val questionThree = project.in(file("questionThree"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.3" % Test,
      "org.mockito" %% "mockito-scala" % "1.5.12" % Test
    )
  )

/* We are providing the classpath because our modules are dependent on each other */
lazy val root = project.in(file(".")).aggregate(questionOneAndTwo, questionThree)
