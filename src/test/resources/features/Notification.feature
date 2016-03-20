Feature: Notification Management
  As a user,
  I would like to read my notifications,
  so that I do not need to miss the activities on my interest repo.

  @smoke
  Scenario: As a user, I should see my unread notifications.
    Given I log in with username "zhuao1051@gmail.com" and password "123456"
    When I click notification icon on the right top
    Then I should see 8 unread notifications

  @smoke
  Scenario: As a user, I should see my participating notifications.
    Given I log in with username "zhuao1051@gmail.com" and password "123456"
    When I click notification icon on the right top
    Then I should see 2 participation notifications