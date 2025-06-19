Feature: Purchase iPhone 16 Pro Max from istore.ua

  Scenario: Buy iPhone 16 Pro Max 256GB White Titanium and verify it appears in the cart
    Given I am on the istore main page
    When I select iPhone 16 Pro Max from the menu
    And I choose iPhone 16 Pro Max 256GB White Titanium
    And I click Buy button
    Then Product should appear in the cart