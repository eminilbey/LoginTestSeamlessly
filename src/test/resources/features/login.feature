Feature: Login Functionality

  Background:
    Given user is on the login page

  @SEAMLES-1962 @wip
  Scenario Outline:
    When user enters "<username>" as username
    And user enters "<password>" as password
    And user hits Enter Key
    Then user should login successfully

    Examples: username and password
      | username  | password    |
      | Employee1 | Employee123 |
      | Employee2 | Employee123 |
      | Employee3 | Employee123 |
      | Employee4 | Employee123 |
      | Employee5 | Employee123 |


  @SEAMLES-1964 @wip
  Scenario:
    When user enters "Employee1" as username
    And user enters "Employee123" as password
    And user clicks login button
    Then user should login successfully

  @SEAMLES-1967 @wip
  Scenario:
    When user enters "" as no username
    And user enters "Employee123" as password
    And user clicks login button
    Then Please Fill Out UserName Field Displayed

  @SEAMLES-1968 @wip
  Scenario:
    When user enters "Employee1" as username
    And user enters "" as no password
    And user clicks login button
    Then Please Fill Out Password Field Displayed

  @SEAMLES-1969 @wip
  Scenario:
    When user enters faker username
    And user enters "Employee123" as password
    And user clicks login button
    Then Wrong username or password Message Displayed

  @SEAMLES-1970 @wip
  Scenario:
    When user enters "Employee1" as username
    And user enters "invalidPassword" as invalidPassword
    And user clicks login button
    Then Wrong username or password Message Displayed

  @SEAMLES-1982 @wip
  Scenario:
    When user enters "Employee123" as password
    Then password type is dotForm By Default

  @SEAMLES-1983 @wip
  Scenario:
    When user enters "Employee123" as password
    And user clicks eye icon
    Then password is visible


  @SEAMLES-1984 @wip
  Scenario:
    When user Clicks Forgot Password Button
    Then reset Password Button Is Displayed

  @SEAMLES-1985 @wip
  Scenario:
    Then user Can See userName Placeholder
    Then user can see password placeholder