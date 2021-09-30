package com.openclassroom.testing;

public class Calculator {

    /**
     * Sum of two numbers
     * @param a first number
     * @param b second number
     * @return the result of the sum from the two numbers.
     */
    public int addTwoNumbers(int a, int b){
        return a+b;
    }

    /**
     * Subtraction of two numbers
     * @param a first number, the number that will be subtracted
     * @param b second number, the number that will subtract the first number
     * @return the result of the subtraction
     */
    public int subtractTwoNumbers(int a, int b) {
        return a-b;
    }

    /**
     * Multiplication of two numbers
     * @param a first number
     * @param b second number
     * @return the result of multiplication
     */
    public int multiplyTwoNumbers(int a, int b) {
        return a*b;
    }

    /**
     * Division of two numbers
     * @param a first number, the number that will be divided
     * @param b second number, the number that divide the first number
     * @return the result from the division
     */
    public float divideTwoNumbers(int a, int b) {
        return a/b;
    }

    /**
     * Gives the power of an number
     * @param a the number
     * @return the power of the number
     */
    public int powerOfNumber(int a) {
        return (int) Math.pow(a,2);
    }

    /**
     *  'Unsuported fot the moment'
     */
    public void cos(double a) {
        throw new UnsupportedOperationException();
    }

    /**
     * Makes a slow calculation
     * @param a time we will wait in miliseconds
     */
    public void slowCalculation(long a) {
        try {
            Thread.sleep(a);
        } catch (InterruptedException e) {
            System.out.println("This Operation completed afther 3 seconds");
        }
    }
}
