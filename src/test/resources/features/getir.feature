Feature: Login and Basket test for Getir Application
  @wip
  Scenario: Getir Basket verification
    When The user opens app and enters valid credentials "hello@getir.com" and "hello"
    Then The user login successfully
    When The user clicks basket
    And The user verify that basket is empty and able to see "There is no result" message
    And User navigates to main menu
    Then The user verify that menu size is 12
    And The User navigates to "Dondurma"
    And The user adds item
    And The user navigates item "Ürün 21"
    And The user adds item
    And The user clicks basket
    Then The user verify that "74"
