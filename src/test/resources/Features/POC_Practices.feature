Feature: POC about Amazon Automation script

  @TC1_Admin_CorrectCredentials
  Scenario Outline: Validate if user able to login with Correct 'Admin' credentials
      Given the 'Admin' launches the application
      When the 'Admin' enters the username and password in the "RowIndex"
      And the 'Admin' clicks on Log In Button
      And The 'User' clicks order items
      And 'User' Select lastest Order and view details
      Then 'User' Get the information



    Examples:
      | RowIndex |
      | 1        |

  @TC2_Admin_InCorrectCredentials
  Scenario Outline: Validate if user able to get error lable whne applied incorrect login with Correct 'Admin' credentials
    Given the 'Admin' launches the application
    When the 'Admin' enters the username and password in the "RowIndex"
    And the 'Admin' clicks on Log In Button


    Examples:
      | RowIndex |
      |        2 |