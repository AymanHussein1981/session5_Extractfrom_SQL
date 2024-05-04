@DBLoginFeature @regrission
Feature: CodeFios login page functionality validation


Background:
Given User is on codfios login page


@DBLoginScenario1
Scenario: User should be able to login with valid credentials
When User enters "username" from mysql database
When User enters "password" from mysql database
When User clicks on sign in button
Then User lands on dashboard page
