Feature: Calculate

  Background:
    Given I turn on the calculator

  @smoke
  Scenario: Verify one number calculate
    When I input expression "4"
    Then The result is 4

  @smoke
  Scenario: Verify one number calculate
    When I input expression "4"
    Then The result is 4

  @smoke
  Scenario: Verify one number calculate
    When I input expression "4"
    Then The result is 4

  @smoke
  Scenario: Verify two number calculate
    When I input expression "4+3"
    Then The result is 7

  @smoke
  Scenario: Verify two number calculate
    When I input expression "4-3"
    Then The result is 1

  @smoke
  Scenario: Verify two number calculate
    When I input expression "4+3-2"
    Then The result is 5

  @smoke
  Scenario: Verify two number calculate
    When I input expression "4+3-2+5"
    Then The result is 10