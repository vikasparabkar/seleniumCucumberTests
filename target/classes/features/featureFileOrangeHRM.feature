@tag1
Feature: testLoginFunctionality

Background: test
Given Navigate to Orange HRM url

  @outline
  Scenario: Login scenario check
    Given Navigate to Orange HRM url
    When Login into OrangeHRM application
    Then Validate homepage url

  @test
  Scenario Outline: Login scenario check
    Given Navigate to Orange HRM url "<url>"
    When Login into OrangeHRM application with "<username>" and "<password>"
    Then Validate homepage url "<homepageUrl>"

    Examples:
      | url | username | password | homepageUrl |
      | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login | Admin    | admin123 | https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index |


