Feature: MakeMyTrip Feature

@A
Scenario: MakeMyTrip login Scenario

Given user enters username and password
When  user is on MakeMyTrip Home Page
And   user capture screen shot after successfull login
Then  user is able close the browser

@B
Scenario: Mouse hover Action

Given  user is on MakeMyTrip home page after successfull login
When   verify user in MakeMyTrip home page
Then   user select on India Country and capture screen shot
Then   user quit broswer

@C
Scenario: scrollDown Action

Given  user is on MakeMyTrip home page
When   verify title of MakeMyTrip
Then   user perform scrolldown action and capture screen shot
Then   user close broswer

@D
Scenario: OneWay Scenario
Given user is on MakeMyTrip Application home page 
When  user select OneWay Trip
And   user enter Source and Destination
And   user capture screen shot of flight deatils
And   user click on Booknow button
Then  user close an broswer


@E
Scenario: RoundWay Scenario

Given when user is on MakeMyTrip home page after successfull login
When  user select RoundWay Trip
When  user select Source and Destination
And   user click on Travel date
And   user click on return Date
And   user should able to book RoundWay Flight Ticket
Then  user close the browser

@Excelsheet
Scenario: Data from Excel
Given user is on MakeMyTrip Home

@F
Scenario: Wallet Scenario
Given when user is on MMT Home Page successfull
And   user click on Wallet from the list
And   user capture screen shot as wallet
Then  user quit the browser 

@G
Scenario: Logout Scenario
Given when user is on MMT Home Page after login successfully
And   user click on logout
Then  user should close the browser 

