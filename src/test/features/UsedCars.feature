Feature: User browses used cars

  Scenario: Validate the existence of at least one listing under used cars category
    Given I want to see subcategories as well
    When I retrieve the list of used cars
    Then the status code is 200
    And there should be at least one listing

  Scenario: Validate the existence of Kia under used cars
    Given I want to see subcategories as well
    When  I retrieve the list of used cars
    Then the status code is 200
    Then "Kia" must exist

  Scenario: User browses the details of a used car
    Given I search for used cars
    When I request for a particular listing
    Then I should get all the used car details in response


