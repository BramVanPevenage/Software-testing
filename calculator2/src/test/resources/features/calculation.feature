Feature: Adding two numbers
  As a user i want to add two numbers so that i can solve a calculation.

  Scenario: Adding two positive numbers
    Given a student is using the Calculator
    When 2 and 5 are added
    Then the student is shown 7