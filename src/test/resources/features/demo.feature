@logs @hookless
Feature: How to use logs in Selenium

  Scenario: Login with valid admin credentials
    Given I login as admin

  Scenario: Login with valid manager credentials
    Given I login as manager

  Scenario: Error level Log sample
    When I devide 8 to 0




#  DEBUG Level. This log4j level helps developer to debug application. ...
#  INFO Level. This log4j level gives the progress and chosen state information. ...
#  WARN Level. This log4j level gives a warning about an unexpected event to the user.