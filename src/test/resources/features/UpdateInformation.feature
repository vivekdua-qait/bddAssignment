Feature: Login action

  Background: User is Logged in with Valid credentials
    Given User is on the shopping site
    When User clicks on Sign In tab
    And User enters "email"
    And User enters "password"
    And User clicks on Sign In button
    Then User is logged in successfully

  Scenario: User is able to update Account Information
    When User clicks on customer account button
    And User clicks on My Personal Information tab
    And User updates first name to "Testuser1"
    And User enters old password
    And User clicks on Save button
    Then Account information is updated
