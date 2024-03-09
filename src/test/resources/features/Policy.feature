Feature: Travel Insurance Plan for Students

  Scenario: Find and Display Three Lowest International Travel Insurance Plans
    Given I am on the travel insurance website
    When I click for travel insurance plan for students
    And I select the option for 2 student people (Age 22, 21) traveling to any European country
    And I fill in further dummy details
    Then I should see the three lowest international travel insurance plans with their amounts and insurance provider companies

  Scenario: Get a Car Insurance Quote and Capture Error Message
    Given I am on the car insurance section of the website
    When I proceed without entering the car number
    And I fill in the required details
    And I provide an invalid email or phone number
    Then I should capture the error message displayed

  Scenario: Retrieve and Display Health Insurance Menu Items
    Given I am on the health insurance section of the website
    When I retrieve all the health insurance menu items
    Then I should display the retrieved menu items
