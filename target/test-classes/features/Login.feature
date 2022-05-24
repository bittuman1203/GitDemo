Feature: Application Login

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "https://rahulshettyacademy.com" site
And Click on Login link in Home page to land on secure sign in page
When User enters <username> and <password> and logs in
Then Verify that user is successfully logged in
And Close browser

Examples:
|	username					|password	|
|test99@gmail.com		|123456		|
|test123@gmail.com	|12345		|