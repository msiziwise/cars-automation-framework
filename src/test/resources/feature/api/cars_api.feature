@api
Feature: Retrieve available cars

  Scenario: Successfully retrieve cars list
    When I send a GET request to "/cars"
    Then the response status code should be 200
    And the response should contain "Clio"

  Scenario: Cars list contains required fields
    When I send a GET request to "/cars"
    Then the response status code should be 200
    And each car contains, name, price, and image

  Scenario: Cars list is not empty
    When I send a GET request to "/cars"
    Then the response status code should be 200
    And the cars list should not be empty

  Scenario: Invalid endpoint returns not found
    When I send a GET request to "/carss"
    Then the response status code should be 404
