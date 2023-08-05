Feature: Login page

  Background: Launching HrOne Website
    Given user enters the HrOne website url

  @smoke
  Scenario: Login to HrOne
    When user clicks on username field and enters username
    And user clicks on Next button
    And user clicks on password field and enters password
    And user clicks on Login button
    Then user will be taken to HrOne one home page