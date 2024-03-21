Feature: MovieDetails Functionality
  A s a user of movie app application
  I want to login to home page
  and then navigate to pages
  Scenario:  Successful movieDetails
    Given   I enter  login page
    When I enter  username and password
    And  I click   login button
    Then  I should enter   home page
    And I check homepage  , popular displayed
    Then  I navigate to home and popular pages