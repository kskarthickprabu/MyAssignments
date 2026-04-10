Feature: Salesforce Legal Entity
Scenario: Verify error message for missing Name field
Given Launch the browser
And Load the url
And Enter the username as kskarthickprabu.c3348082a2a2
And Enter the password as $Surabhi@29
When Click on the Login button
And Click Verify button for OTP verification
Then User should be loggedin
When Click on the App Launcher
And Click on View All 
And Click Sales from App Launcher
And Click on Account tab
And Click on New button
And Enter your name as Account name
And Select Ownership as Public
And Click Save button
Then User should save and Verify Account Name


