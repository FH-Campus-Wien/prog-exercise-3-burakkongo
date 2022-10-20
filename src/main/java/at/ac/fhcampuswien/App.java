package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    // Assignment 1
    public static void oneMonthCalendar(int daysInMonth, int firstDayInMonth) {

        int lineBreakCounter = 0;
        int spaceCounter = 1;

        for (int i = 1; i < daysInMonth + 1; i++) {

            while(spaceCounter < firstDayInMonth){
                System.out.print("   ");
                spaceCounter++;
                lineBreakCounter++;
            }

            System.out.printf("%2d ", i);
            lineBreakCounter ++;

            if (lineBreakCounter == 7){
                System.out.println();
                lineBreakCounter = 0;
            }

        }
        if (lineBreakCounter != 0) System.out.println();
    }

    // Assignment 2
    public static long[] lcg(long seed) {

        long [] outputArray = new long[10];

        // Xi+1 = (a*Xi + c) % m

        long a = 1103515245L;
        int c = 12345;
        long m = (long)Math.pow(2,31);

        outputArray[0] = (a * seed + c) % m;

        for (int i = 1; i < 10; i++) {
            outputArray[i] = (a * outputArray[i-1] + c) % m;
        }

        return outputArray;
    }

    // Assignment 3
    public static void guessingGame(int numberToGuess) {

        int counter = 1;
        int guess;
        boolean state = false;
        Scanner input = new Scanner(System.in);

        while(state == false)
        {
            System.out.print("Guess number "+counter+": ");
            guess = input.nextInt();

            if(counter >= 10){
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                return;
            }

            if(guess > numberToGuess) {
                System.out.println("The number AI picked is lower than your guess.");
                counter++;
            }
            else if (guess < numberToGuess ) {
                System.out.println("The number AI picked is higher than your guess.");
                counter++;
            }
            else if(guess == numberToGuess){
                System.out.println("You won wisenheimer!");
                state = true;
            }

        }
    }
    public static int randomNumberBetweenOneAndHundred(){

        //return (int) (Math.random() * 100) + 1;

        Random randomNumber = new Random();
        return randomNumber.nextInt(100);
    }

    //Assignment 4
    public static boolean swapArrays(int[] arrayOne, int[] arrayTwo) {

        int arrayLength = arrayOne.length;

        if (arrayOne.length != arrayTwo.length)
            return false;
        else{
            int[] tempArray = new int[arrayLength];

            //saving the numbers of arrayOne into the tempArray
            for (int i = 0; i < arrayLength; i++) {
                tempArray[i] = arrayOne[i];
            }

            //saving the numbers of arrayTwo into the arrayOne
            for (int j = 0; j < arrayLength; j++) {
                arrayOne[j] = arrayTwo[j];
            }

            //saving the numbers of tempArray into the arrayTwo
            for (int k = 0; k < arrayLength; k++) {
                arrayTwo[k] = tempArray[k];
            }
            return true;
        }
    }

    //Assignment 5
    private static final int CHAR_UPPERCASE_MIN = 'A'; // A - 65
    private static final int CHAR_UPPERCASE_MAX = 'Z'; // Z - 90
    private static final int CHAR_LOWERCASE_MIN = 'a'; // a - 97
    private static final int CHAR_LOWERCASE_MAX = 'z'; // z - 122

    // all chars that result in whitespace
    private static final int CHAR_WHITESPACE_MIN = 28;
    private static final int CHAR_WHITESPACE_MAX = 32;
    public static boolean whiteSpaceCheck(char charValue){
        return CHAR_WHITESPACE_MIN <= charValue && CHAR_WHITESPACE_MAX >= charValue;
    }
    public static boolean validCharCheck(char charValue){
        return CHAR_UPPERCASE_MIN <= charValue && CHAR_UPPERCASE_MAX >= charValue
                || CHAR_LOWERCASE_MIN <= charValue && CHAR_LOWERCASE_MAX >= charValue;
    }
    public static char charToLowerCase(char charValue){
        if (CHAR_LOWERCASE_MIN <= charValue && CHAR_LOWERCASE_MAX >= charValue)
            return charValue;
        return (char)(charValue + 32);
    }
    public static char charToUpperCase(char charValue){

        if(CHAR_UPPERCASE_MIN <= charValue && CHAR_UPPERCASE_MAX >= charValue)
            return charValue;
        else return (char)(charValue - 32);
    }
    public static String camelCase (String inputString) {
        char[] charArray = inputString.toCharArray();
        StringBuilder camelCaseString = new StringBuilder();

        boolean nextCharToUppercase = true;

        for (char currentChar : charArray) {
            if(!validCharCheck(currentChar) && !whiteSpaceCheck(currentChar)){
                continue;
            }
            if (whiteSpaceCheck(currentChar)) {
                nextCharToUppercase = true;
                continue;
            }
            if (nextCharToUppercase) {
                camelCaseString.append(charToUpperCase(currentChar));
                nextCharToUppercase = false;
            } else {
                camelCaseString.append(charToLowerCase(currentChar));
            }
        }
        return camelCaseString.toString();
    }

    //Assignment 6
    public static int checkDigit(int[] iban) {

        int ibanLength = iban.length;
        int weightingOfDigit;
        int digitWeight;
        int ibanSum = 0;

        for (int i = 0; i < ibanLength; i++) {
            weightingOfDigit = i + 2;
            digitWeight = weightingOfDigit * iban[i];
            ibanSum += digitWeight;
        }

        int remainder = ibanSum % 11;
        int checksum = 11 - remainder;

        if (checksum == 10)
            checksum = 0;
        else if (checksum == 11)
            checksum = 5;

        return checksum;
    }

    public static void main(String[] args) {
    }
}