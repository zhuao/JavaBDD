Feature: Log in
  As a user,
  I should login with my username and password,
  so that I would look up my personal info.

  Scenario: Fail to login when log in with wrong password
    Given I open login page
    When I log in with username "zhuao1051@gmail.com" and password "123456"
    Then I should login successfully
