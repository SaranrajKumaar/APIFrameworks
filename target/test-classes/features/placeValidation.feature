#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Valiadting place API's
  I want to use this template for my feature file

@Addplace
  Scenario: Verify if place is being Sucessfully added using AddPlaceAPI
   Given Add place from payload with "<name>" "<language>" "<address>"
   When User calls "AddPlaceAPI" with "POST" http Request
   Then the API Call is success with status code 200
   And "status" in response body is "OK"
   And "scope" in response body is "APP"
   And verify place_ID created maps to "<name>" using "GetPlaceAPI"
 Examples:
 	|name 		|language |address 						|
 	|mamatha	|Tamil		|world class Address|
# 	|Saran		|telugu		|India class Address|


@deleteplace
Scenario: Verify if Delete Place functionality is working 
Given DeletePlace Payload
When User calls "DeletePlaceAPI" with "POST" http Request
Then the API Call is success with status code 200
And "Status" in response body is "OK"

			
 
 