Feature: Registering to automation practice

  Scenario: Validate user is able to register
    Given Automation practice application is opened
    When I click sign in
    And I create account with emailid "testRandom@testauto.com"
    Then I should be able to register with my below details
      | Gender | FirstName | LastName  | Password  | Address            | City      | State  | Zip  | Mobile     |
      | Mr     | TestFName | TestLName | Password1 | 100 Spencer Street | Anchorage | Alaska | 30000 | 0406345454 |


  ## Some Suggestions -
  # Config file can be added with all test URLs. This way code can be run on multiple environments
  # Run time parameters can be added to pass the environment = ST/SIT/UAT, browser etc.
  # Logging can be added to the framework

  @test1
  Scenario Outline: Validate error message for incorrect email address
    Given Automation practice application is opened
    When I click sign in
    And I create account with emailid "<EmailAddress>"
    Then I should see an error message "<ErrorMessage>"
    Examples:
      | EmailAddress  | ErrorMessage                                                                                                         |
      | test@test.com | An account using this email address has already been registered. Please enter a valid password or request a new one. |
      | test@@test.co | Invalid email address.                                                                                               |
      | test.co       | Invalid email address.                                                                                               |


