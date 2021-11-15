Feature: Calculator Adding numbers

	Adding numbers to each other.

@Adding
Scenario: Add two numbers
	Given the first number is 50
	And the second number is 70
	When the two numbers are added
	Then the result should be 120

Example: two negative numbers
	Given the first number is -50
	And the second number is -70
	When the two numbers are added
	Then the result should be -120

Example: one negative numbers
	Given the first number is 50
	And the second number is -70
	When the two numbers are added
	Then the result should be -20
		



