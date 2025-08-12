Feature: To validate the Flipkart functionality

Background: To validate search functionality
 Given To launch the browser and enter url
 When Enter text in the search field
 Then Search result should get displayed
 Then Take screenshot and close browser
 
@tc002 @smoke
Scenario Outline: To test the search functianlity with diffrent values
Given  Launch the browser and enter url
When Enter "<text>" in the Search field
Then Search result should be displayed
Then Verify the reult
And Take  the screenshot and close  the browser
 
Examples:
|text|
|Mobiles|
|Tshirt|
|Tv|
|Bottles|

@tc003
Scenario: Test search data table
  Given I launch the browser and navigate to the application URL
  When I enter the following text in the Search field
    | Mobiles  |
    | Tshirt   |
    | Tv       |
    | Bottles  |
  Then The corresponding search results should be displayed
  And I verify the search

