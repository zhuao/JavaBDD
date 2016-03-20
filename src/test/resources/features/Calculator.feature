Feature: Calculate

  Background:
    Given I turn on the calculator

  @smoke
  Scenario: Verify calculator result
    When I add 4 and 7
    Then The result is 11