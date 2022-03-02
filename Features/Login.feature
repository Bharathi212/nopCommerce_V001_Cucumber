Feature: Login
  @regression
  Scenario: Successful login with valid credentials
    Given User launches chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page title should be "Your store. Login"
    And close browser
@sanity
  Scenario Outline: login with multiple credentials
    Given User launches chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page title should be "Your store. Login"
    And close browser
    Examples:
      | email  | password |
      | admin@yourstore.com | admin |
      | admin@yourstore.com | admin123 |


