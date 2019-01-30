Sample story

Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development
					 
Scenario:  User buys six products from onlineshop
Given User opens ulr (saucedemo.com) logs in with username (<username>) password (secret_sauce)
Then Home page is displayed
When User adds item (Sauce Labs Backpack) to basket
Then User can checkout the order with item (Sauce Labs Backpack)
When User returns to homepage
When User adds item (Sauce Labs Bike Light) to basket
Then User can checkout the order with item (Sauce Labs Bike Light)
When User returns to homepage
When User adds item (Sauce Labs Bolt T-Shirt) to basket
Then User can checkout the order with item (Sauce Labs Bolt T-Shirt)
When User returns to homepage
When User adds item (Sauce Labs Fleece Jacket) to basket
Then User can checkout the order with item (Sauce Labs Fleece Jacket)
When User returns to homepage
When User adds item (Sauce Labs Onesie) to basket
Then User can checkout the order with item (Sauce Labs Onesie)
When User returns to homepage
When User adds item (Test.allTheThings() T-Shirt (Red)) to basket
Then User can checkout the order with item (Test.allTheThings() T-Shirt (Red))
When User returns to homepage
When User adds all items to basket
Then User checkouts the order with all items

Examples:
|username               |
|standard_user          |
|locked_out_user        |
|problem_user           |
|performance_glitch_user|
					 
Scenario:  User cancels order on last step of checkout
Given User opens ulr (saucedemo.com) logs in with username (<username>) password (secret_sauce)
Then Home page is displayed
When User adds item (Sauce Labs Backpack) to basket
Then User cancels checkout the order with item (Sauce Labs Backpack)
When User returns to homepage
Then Order (Sauce Labs Backpack) is still in basket
Examples:
|username               |
|standard_user          |
|locked_out_user        |
|problem_user           |
|performance_glitch_user|					 
					 
Scenario:  User adds item to basket, logs out, logs in and and checks basket
Given User opens ulr (saucedemo.com) logs in with username (<username>) password (secret_sauce)
Then Home page is displayed
When User adds item (Sauce Labs Backpack) to basket
Then User logs out
When User logs in with same username and password
Then Order (Sauce Labs Backpack) is still in basket
Examples:
|username               |
|standard_user          |
|locked_out_user        |
|problem_user           |
|performance_glitch_user|					 
					 
					 
					 