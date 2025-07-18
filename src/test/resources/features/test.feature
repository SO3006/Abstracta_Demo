@OpenCart_Demo
  Feature: Test the Cart functionality for OpenCart website.

@Story1 @Scenario1 @Iphone
  Scenario: Add an Iphone to Cart, verify the items in the cart and then remove from the cart.
  Given The Opencart site is displayed
  When The user search for an "Iphone"
  And Press the first Iphone item
  And The user adds the Iphone to the cart
  Then The user verifies if the Iphone is on the cart
  And the user removes the Iphone from the cart
  Then The user validates if the page displays: "Your shopping cart is empty!"