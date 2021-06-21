Feature: Login action

  Background: User is Logged in with Valid credentials
    Given User is on the shopping site
    When User clicks on Sign In tab
    And User enters "email"
    And User enters "password"
    And User clicks on Sign In button
    Then User is logged in successfully

  Scenario: User is able to place an order for a T-shirt
    When User clicks on "T-shirts" navigation tab
    And User selects first item from catalog and adds to cart
    And User clicks on checkout button
    And User is on "Summary" Tab and clicks on "Proceed to checkout"
    And User is on "Address" Tab and clicks on "Proceed to checkout"
    And User selects I agree checkbox on shipping tab and clicks on "Proceed to checkout"
    And User is on payment tab and selects "bankwire"
    And User clicks on "I confirm my order"
    Then Order is placed successfully
    And Order history shows recent order