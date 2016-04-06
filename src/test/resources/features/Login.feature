@login
Feature: Log in
  As a user,
  I should login with my username and password,
  so that I would look up my personal info.

  Background:
    Given I locate at login page

  Scenario: I could login with username or email address
    When I login with following username and password:
      | name                | password      |
      | rightname           | rightpassword |
      | rightname@gmail.com | rightpassword |
    Then I should see my profile info

  Scenario Outline: Fail to login when log in with wrong password
    When I log in with invalid username "<username>" and password "<password>"
    Then I should see same error message "Incorrect username or password."

    Examples:
      | username | password |
      | abc@gmail.com | 123456 |
      | abc | 2344fe |

