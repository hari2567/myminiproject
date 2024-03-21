Feature: HeaderSection Functionality
  A s a user of movie app application
  I want to login to home page
  and then redirected to login page and
  verify headerSection are displayed
  Scenario:  Successful HeaderSection
    Given   I enter on the login page
    When I enter with username and password
    And  I click  the login button
    Then  I should enter to  home page
    And I check homepage  and popular displayed
