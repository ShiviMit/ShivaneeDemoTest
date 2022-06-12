Feature: Adding items to the cart

  @test2
  Scenario Outline: Validate mega menu option works
    Given Automation practice application is opened
    When I click on menu "<Menu>" "<SubMenu>"
    Then I should see category on page "<CategoryName>"
    Examples:
      | Menu  | SubMenu        | CategoryName   |
      | Women | Summer Dresses | Summer Dresses |

  @test3
  Scenario Outline: Validate correct product gets added to the cart
    Given Automation practice application is opened
    When I click on menu "<Menu>" "<SubMenu>"
    And I quick select product <ProductID> and color "<Color>"
    And I click on Add to Cart
    And I proceed to the checkout
    Then I should see product <ProductID> of color "<Color>" and quantity <Quantity> added to the cart
    Examples:
      | Menu  | SubMenu        | ProductID | Product              | Color | Quantity |
      | Women | Summer Dresses | 5         | Printed Summer Dress | blue  | 1        |
