Feature: Login into Account
Existing etailor user should be able to login into Account using correct credentials

Scenario: Login into account with correct details
Given User navigates to etailor website
And User clicks on the Login button on homepage
And User enters a valid email
And User enter a valid password
When User click on Login button 
Then User should be taken to the successful login page     

