Feature: Login function of salesforec application
Scenario Outline: Login with valid credentials
Given Enter the username as kskarthickprabu.c3348082a2a2@agentforce.com
And Enter the password as $Surabhi@29
When Click the Login button
And Click Verify button for OTP verification
Then User should be loggedin
When Click on toggle menu button from the left corner
And Click view All
And Click on Sales from App Launcher
And Click on Accounts tab
And Click on New button
And Enter account name as <accountName>
And Select Ownership as Public
And Click on save
Then Account should be created

Examples:
|accountName|
|karthick prabu|