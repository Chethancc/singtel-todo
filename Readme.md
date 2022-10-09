Selenium Cucumber framework with TestNG as Unit testing Tool

1. Framework Structure
src/main/java/common
-- This Package consists all the common methods like UI actions and TestDataProviders all Page object classes extends this

src/main/java/enums
 -- All the project constants will be declared in this package
 
src/main/java/filereaders
-- Have written some common methods to read from CSV , Its simple and easily maintainable
Properites reader to read the properties like browser and URL



src/main/jave/pages
 -- All the page objects are presnt in this
 
 src/main/java/utils
 -- All the utilitis to acces db and common things related to framework support will be written in this
 
 src/test/java/stepDefinitions
 
 -- All the steps are written here
 
 -- TestRunner
 -- Cucumber testng test runner
 
 
 
  