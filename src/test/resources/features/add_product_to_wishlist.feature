Feature: Add product to wishlist

  Scenario: Add iPhone 16 Pro Max 256GB White Titanium to wishlist
    Given I am on the istore main page
    When I select iPhone 16 Pro Max from the menu
    And I add iPhone 16 Pro Max 256GB White Titanium to wishlist
    And I open the wishlist page
    Then iPhone 16 Pro Max 256GB White Titanium should be in the wishlist


