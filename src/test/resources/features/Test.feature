Feature: Test Feature File

  Scenario: The user opens and closes browser
    Given the user opens the browser
    And the user closes the browser

  Scenario: The user logs in successfully
    Given the user opens the browser
    Given the user navigates to "https://www.saucedemo.com"
    When the user logs in with "standard_user" "secret_sauce"
    Then the user should successfully log in
    Then the user closes the browser

  Scenario: The user logs in unsuccessfully
    Given the user opens the browser
    Given the user navigates to "https://www.saucedemo.com"
    When the user logs in with "standard_user" "invalidpassword"
    Then the user should not be able to login
    Then the user closes the browser

  Scenario Outline: The user logs in
    Given the user opens the browser
    Given the user navigates to "<website>"
    When the user logs in with "<username>" "<password>"
    Then the user closes the browser
    Examples:
      | website | username | password |
      | https://www.saucedemo.com | standard_user | secret_sauce    |
      | https://www.saucedemo.com | standard_user | invalidpassword |





