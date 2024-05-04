@CodeFiosLogin.feature @regrission
Feature: CodeFios login page functionality validation


Background:
Given User is on codfios login page
When User enters username as "demo@codefios.com"

@LoginScenario1
Scenario: User should be able to login with valid credentials
When User enters password as "abc123"
When User clicks on sign in button
Then User lands on dashboard page

@LoginScenario2 @Smoke
Scenario: User should be able to login with valid credentials
When User enters password as "abc124"
When User clicks on sign in button
Then User lands on dashboard page

@LoginScenario3
Scenario: User should be able to login with valid credentials
When User enters password as ""
When User clicks on sign in button
Then User lands on dashboard page
