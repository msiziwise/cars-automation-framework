@ui
Feature: Cars Showroom UI
  As a user
  I want to browse cars in the showroom
  So that I can view car details and validate displayed information

  Background:
    Given I navigate to the Cars Showroom page

  Scenario: Cars Showroom page loads successfully
    Then the page title should contain "Cars Showroom Test page for Automation Testing"
    And at least one car card should be displayed

  Scenario: View list of available cars
    Then each car card should display:
    And each car card should have a View Details button

#    fail scenario
#  Scenario: Selecting a car shows the error message when details are unavailable
#    When I click View Details on the first car
#    Then I should see a message containing "We couldn't find results for VW Golf."

  Scenario: Refresh Cars Showroom page
    When I refresh the page
    Then the cars list should still be displayed

  Scenario: Validate car list count matches API response
    Given I retrieve the list of cars from the API "/cars"
    Then the number of cars displayed should match the API response

  Scenario: Validate car details match API data
    Given I retrieve the list of cars from the API "/cars"
    Then the car name should match the API response
    And the car price should match the API response
