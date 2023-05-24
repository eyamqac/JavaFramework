Feature: Test Feature File

  Scenario: The user logs in successfully
    Given the browser is open
    Given the website "https://www.saucedemo.com" is open
    When the user logs in with "standard_user" "secret_sauce"
    Then the user should successfully log in
    Then the user closes the browser

  Scenario: The user logs in unsuccessfully
    Given the browser is open
    Given the website "https://www.saucedemo.com" is open
    When the user logs in with "standard_user" "invalidpassword"
    Then the user should not be able to login
    Then the user closes the browser

  Scenario Outline: The user logs in
    Given the browser is open
    Given the website "<website>" is open
    When the user logs in with "<username>" "<password>"
    Then the user closes the browser
    Examples:
      | website                   | username      | password        |
      | https://www.saucedemo.com | standard_user | secret_sauce    |
      | https://www.saucedemo.com | standard_user | invalidpassword |

  Scenario: The user purchases an item
    Given the browser is open
    Given the website "https://www.saucedemo.com" is open
    When the user logs in with "standard_user" "secret_sauce"
    And the user checks out an item with their information "temp" "generic" "1234"
    Then the user's purchase was successful
    Then the user closes the browser

Scenario: Go to about page
  Given the browser is open
  Given the website "https://www.saucedemo.com" is open
  When the user logs in with "standard_user" "secret_sauce"
  And the user navigates to the about page
  Then the user closes the browser




