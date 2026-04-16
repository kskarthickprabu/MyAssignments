Feature: Login function of salesforec application
Scenario Outline: Login with valid credentials
Given Enter the username as 'kskarthickprabu.c3348082a2a2@agentforce.com'
And Enter the password as '$Surabhi@29'
When Click the Login button
And Click Verify button for OTP verification
Then User should be loggedin
When Click on toggle menu button from the left corner
And Click view All
And Click on Sales from App Launcher
And Click on Accounts tab
And Search for the account 'karthick prabu'
And Click the dropdown icon next to the account and select Edit
And Set Type to Technology Partner
And Set Industry to Healthcare
And Enter the Billing Address as 'Madurai'
And Enter the Shipping Address as 'Madurai'
And Set Customer Priority to Low
And Set SLA to Silver
And Set Active to NO
And Enter a unique number in the Phone field as '9629702668'
And Set Upsell Opportunity to No
And Click Save
Then Verify the phone number