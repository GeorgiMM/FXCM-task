Sample story

Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development
					 
Scenario:  User buyes buys six products from onlineshop
Given User opens ulr (saucedemo.com) logs in with username (<username>) password (secret_sauce)
Examples:
|username               |
|standard_user          |
|locked_out_user        |
|problem_user           |
|performance_glitch_user|
Then Home page is displayed
When User adds item () to basket
Then User can checkout the order with item ()
When User removes item ()
					 
