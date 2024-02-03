/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentsca1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author peta
 */
public class UserInput {

    public void manualInput() {

        try {

            // Asking the user to enter the student details manually.
            /// NAME ///
            Scanner userInput = new Scanner(System.in);
            System.out.println("Please enter student name: ");
            String name = userInput.next();

            /// SURNAME ///
            System.out.println("Please enter student surname: ");
            String surname = userInput.next();

            /// NUMBER OF CLASSES ///
            System.out.println("Please enter student number of classes: ");
            int numberOfClasses = userInput.nextInt();

            /// STUDENT NUMBER ///
            System.out.println("Please enter student number: ");
            String studentNumber = userInput.next();

            // Parsing the number of classes as string for a condition that cannot be applied to int type.
            String numberOfClassesString = Integer.toString(numberOfClasses);

            // Declaring a variable for the workload based on the number of classes.
            String workload = "";

            if (numberOfClasses == 1) {
                workload = "Very Light";
            } else if (numberOfClasses == 2) {
                workload = "Light";
            } else if (numberOfClasses >= 3 && numberOfClasses <= 5) {
                workload = "Part Time";
            } else if (numberOfClasses >= 6) {
                workload = "Full Time";
            }

            // Using split method and regex to store the different characters
            // into variables to be able to check the appropriate conditions.
            // First chars.
            String[] studentFirstCharsSplit = studentNumber.split("(?<=\\d)(?=\\D)");
            String studentNumberFirstTwoChars = studentFirstCharsSplit[0];

            // Middle chars.
            String[] studentMiddleCharsSplit = studentFirstCharsSplit[1].split("(?<=\\D)(?=\\d)");
            String studentNumberMiddleChars = studentMiddleCharsSplit[0];

            // Last chars.
            String studentNumberLastCharsSplit = studentMiddleCharsSplit[1];
            String studentNumberLastChars = studentNumberLastCharsSplit;

            // Storing the first two chars of the student number as int for a condition that cannot be applied to string type.
            int studentNumberFirstTwoCharsInt = Integer.parseInt(studentNumberFirstTwoChars);
            // Storing the last char of the student number as int for a condition that cannot be applied to string type.
            int studentNumberLastCharsInt = Integer.parseInt(studentNumberLastChars);

            /////////////// Exception handling ///////////////
            // Condition to make sure that the first name is in letters.
            if (!name.matches("[a-zA-Z]+")) {
                System.out.println("The first name must be letters only.");
            // Condition to make sure that the surname is letters and/or numbers.
            } else if (!surname.matches("[a-zA-Z0-9]+")) {
                System.out.println("The surname must be letters and/or numbers.");
            // Condition to make sure that the number of classes is a positive integer
            } else if (!numberOfClassesString.matches("^[0-9]+$")) {
                System.out.println("The number of classes must be an integer value between 1 and 8 (inclusive).");
            // Condition to make sure that the number of classes is between 1 and 8 (inclusive).
            // No need to do a regex for positive integers as this has already been parsed as integer.
            } else if (numberOfClasses < 0 || numberOfClasses > 8) {
                System.out.println("The number of classes must be an integer value between 1 and 8 (inclusive).");
            // Condition to make sure that the first two chars of the student number are positive integers.
            } else if (!studentNumberFirstTwoChars.matches("^[1-9]\\d*$")) {
                System.out.println("The first two chars of the student number must be positive integer numbers.");
            // Condition to make sure that the first number of the student number is at least 20, to represent the year.
            // No need to do a regex for positive integers as this has already been parsed as integer.
            } else if (studentNumberFirstTwoCharsInt < 20) {
                System.out.println("The first numbers of the student number must be at least 20, to represent the year.");
            // Condition to make sure there are letters after the year in the student number.
            } else if (!studentNumberMiddleChars.matches("[a-zA-Z]+")) {
                System.out.println("The 3rd, 4th and possibly 5th character of the student number must be letters.");
            // Condition to make sure there are at least two letters and tops three letters, after the year in the student number.
            } else if (studentNumberMiddleChars.length() < 2 || studentNumberMiddleChars.length() > 3) {
                System.out.println("The letters in the student number have to be minimum 2 and maximum 3 characters.");
            // Condition to make sure the last number in the student number is a number
            } else if (!studentNumberLastChars.matches("^[0-9]\\d*$")) {
                System.out.println("Last number of the student number has to be an integer number between 1 and 200.");
            // Condition to make sure the last number in the student number is a number between 1 and 200
            // No need to do a regex for positive integers as this has already been parsed as integer.
            } else if (studentNumberLastCharsInt < 1 || studentNumberLastCharsInt > 200) {
                System.out.println("Last number of the student number has to be an integer number between 1 and 200.");
            // Condition to make sure that the student number is at least 6 chars.
            } else if (studentNumber.length() < 6) {
                System.out.println("The student 'number' must be a minimum of 6 characters.");
            // If all conditions are met, I create the output txt file.
            } else {

                BufferedWriter bw = new BufferedWriter(new FileWriter("status.txt", true));
                bw.write(studentNumber + " - " + surname + "\n");
                bw.write(workload + "\n");
                bw.close();
                System.out.println("The status.txt file has been succesfully created.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
