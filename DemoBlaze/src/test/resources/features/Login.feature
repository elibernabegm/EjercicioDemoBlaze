@login
Feature: Buy products on Demoblaze
  As a user
  I want to buy products on Demoblaze
  So I can complete my purchase successfully

  Background:
    Given I access the Demoblaze page

  Scenario Outline: Buy products
    When I enter Username <username> and Password <password>
    And I add products to the cart
    And I view the cart
    And I complete the purchase form: <name>, <country>, <city>, <credit_card>, <month>, <year>
    Then I should see the purchase confirmation

    Examples:
      | username   | password | name          | country | city   | credit_card | month | year |
      | eligomez   | 123456   | Elí Gómez     | Perú    | Lima   | 1234-5678   | 12    | 2025 |
      | admindemo1 | 123456   | Administrador | USA     | Kansas | 9876-5432   | 06    | 2027 |