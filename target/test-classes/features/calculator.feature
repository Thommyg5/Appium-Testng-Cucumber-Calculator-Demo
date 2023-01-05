Feature: Calculator

  @nums
  Scenario: Number buttons and decimal button are clickable and print on screen
    Then user clicks all number buttons and decimal button and sees them displayed on bottom screen

  Scenario Outline: clear button clears screen
    When user clicks a number
    When user clicks clear button
    Then "<part-of-screen>" screen should be clear
  Examples:
    | part-of-screen |
    | lower          |
    | upper          |


