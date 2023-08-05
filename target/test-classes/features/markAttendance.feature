Feature: Login page

  Background: User has to be on HrOne Home page
    Given user enters the HrOne website url
    And user performs valid login operation

  @smoke
  Scenario: Mark the attendance daily
    Given user in in HrOne home page
    When user closes all the pop ups
    Then user will mark the attendance