/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.studentsca1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author peta
 */
public class StudentsCA1 {

    public static void main(String[] args) {

        try {

            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter 1 for Standard Operation or 2 for Manual Input: ");
            int userChoice = scan.nextInt();

            if (userChoice == 1) {

                // Reading the students.txt file
                BufferedReader br = new BufferedReader(new FileReader("students.txt"));
                String studentsFile = br.readLine();

                // Starting point of txt file lines
                int lineZero = 0;
                int lineOne = 1;
                int lineTwo = 2;

                // Reading all lines of the file
                while (studentsFile != null) {
                    studentsFile = br.readLine();

                    // Storing each line from the txt file into a list
                    List<String> lines = Files.lines(Paths.get("students.txt")).collect(Collectors.toList());

                    /// FULL NAME ///
                    String studentFullName = lines.get(lineZero);

                    // Condition to make sure there is a space in the file
                    // before declaring different variables based on this space.
                    if (!studentFullName.contains(" ")) {
                        System.out.println("Please include a space ' ' between the name and the surname.\n");
                    }

                    // Finding where the position of the space is to see where the name ends
                    int locationSpace = studentFullName.indexOf(" ");

                    // Finding the position of the last char to see where the surname ends
                    int locationLastCharStudentFullName = studentFullName.length() - 1;

                    // Storing name and surname in separate variables
                    String name = studentFullName.substring(0, locationSpace);
                    String surname = studentFullName.substring(locationSpace + 1, locationLastCharStudentFullName + 1);

                    /// NUMBER OF CLASSES ///
                    String numberOfClasses = (lines.get(lineOne));
                    // Storing the number of classes as int for a condition that cannot be applied to string type
                    int numberOfClassesInt = Integer.parseInt(numberOfClasses);

                    // Declaring a variable for the workload based on the number of clases
                    String workload = "";

                    if (numberOfClassesInt == 1) {
                        workload = "Very Light";
                    } else if (numberOfClassesInt == 2) {
                        workload = "Light";
                    } else if (numberOfClassesInt >= 3 && numberOfClassesInt <= 5) {
                        workload = "Part Time";
                    } else if (numberOfClassesInt >= 6) {
                        workload = "Full Time";
                    }

                    /// STUDENT NUMBER ///
                    String studentNumber = lines.get(lineTwo);

                    // Using split method and regex to store the different characters
                    // into variables to be able to check the appropriate conditions
                    // First chars
                    String[] studentFirstCharsSplit = studentNumber.split("(?<=\\d)(?=\\D)");
                    String studentNumberFirstTwoChars = studentFirstCharsSplit[0];

                    // Middle chars
                    String[] studentMiddleCharsSplit = studentFirstCharsSplit[1].split("(?<=\\D)(?=\\d)");
                    String studentNumberMiddleChars = studentMiddleCharsSplit[0];

                    // Last chars
                    String studentNumberLastCharsSplit = studentMiddleCharsSplit[1];
                    String studentNumberLastChars = studentNumberLastCharsSplit;

                    // Storing the first two chars of the student number as int for a condition that cannot be applied to string type
                    int studentNumberFirstTwoCharsInt = Integer.parseInt(studentNumberFirstTwoChars);
                    // Storing the last char of the student number as int for a condition that cannot be applied to string type
                    int studentNumberLastCharsInt = Integer.parseInt(studentNumberLastChars);

                    //////////////////// Exception handling ////////////////////
                    // Condition to make sure that the first two chars of the student number are positive integers.
                    if (!studentNumberFirstTwoChars.matches("^[1-9]\\d*$")) {
                        System.out.println("The first two chars of the student number must be positive integer numbers.");
                        lineZero += 3;
                        lineOne += 3;
                        lineTwo += 3;
                        // Condition to make sure that the first number of the student number is at least 20, to represent the year.
                        // No need to do a regex for positive integers as this has already been parsed as integer.
                    } else if (studentNumberFirstTwoCharsInt < 20) {
                        System.out.println("The first numbers of the student number must be at least 20, to represent the year.");
                        lineZero += 3;
                        lineOne += 3;
                        lineTwo += 3;
                        // Condition to make sure there are letters after the year in the student number.
                    } else if (!studentNumberMiddleChars.matches("[a-zA-Z]+")) {
                        System.out.println("The 3rd, 4th and possibly 5th character of the student number must be letters.");
                        lineZero += 3;
                        lineOne += 3;
                        lineTwo += 3;
                        // Condition to make sure there are letters after the year in the student number.
                    } else if (studentNumberMiddleChars.length() < 2 || studentNumberMiddleChars.length() > 3) {
                        System.out.println("The letters in the student number have to be minimum 2 and maximum 3 characters.");
                        lineZero += 3;
                        lineOne += 3;
                        lineTwo += 3;
                        // Condition to make sure the last number in the student number is a number
                    } else if (!studentNumberLastChars.matches("^[0-9]\\d*$")) {
                        System.out.println("Last number of the student number has to be an integer number between 1 and 200.");
                        lineZero += 3;
                        lineOne += 3;
                        lineTwo += 3;
                        // Condition to make sure the last number in the student number is a number between 1 and 200
                        // No need to do a regex for positive integers as this has already been parsed as integer.
                    } else if (studentNumberLastCharsInt < 1 || studentNumberLastCharsInt > 200) {
                        System.out.println("Last number of the student number has to be an integer number between 1 and 200.");
                        lineZero += 3;
                        lineOne += 3;
                        lineTwo += 3;
                        // Condition to make sure that the student number is at least 6 chars
                    } else if (studentNumber.length() < 6) {
                        System.out.println("The student 'number' must be a minimum of 6 characters.");
                        lineZero += 3;
                        lineOne += 3;
                        lineTwo += 3;
                        // Condition to make sure that the first name is in letters.
                    } else if (!name.matches("[a-zA-Z]+")) {
                        System.out.println("The first name must be letters only.");
                        lineZero += 3;
                        lineOne += 3;
                        lineTwo += 3;
                        // Condition to make sure that the surname is letters and/or numbers.
                    } else if (!surname.matches("[a-zA-Z0-9]+")) {
                        System.out.println("The surname must be letters and/or numbers.");
                        lineZero += 3;
                        lineOne += 3;
                        lineTwo += 3;
                        // Condition to make sure that the number of classes is a positive integer
                    } else if (!numberOfClasses.matches("^[0-9]+$")) {
                        System.out.println("The number of classes must be an integer value between 1 and 8 (inclusive).");
                        lineZero += 3;
                        lineOne += 3;
                        lineTwo += 3;
                        // Condition to make sure that the number of classes is between 1 and 8 (inclusive).
                        // No need to do a regex for positive integers as this has already been parsed as integer.
                    } else if (numberOfClassesInt < 0 || numberOfClassesInt > 8) {
                        System.out.println("The number of classes must be an integer value between 1 and 8 (inclusive).");
                        lineZero += 3;
                        lineOne += 3;
                        lineTwo += 3;
                        // If all conditions are met, I create the output txt file
                    } else {

                        BufferedWriter bw = new BufferedWriter(new FileWriter("status.txt", true));
                        bw.write(studentNumber + " - " + surname + "\n");
                        bw.write(workload + "\n");
                        bw.close();
                        System.out.println("The status.txt file has been succesfully created.");

                        lineZero += 3;
                        lineOne += 3;
                        lineTwo += 3;

                    }
                }
                br.close();

            } else if (userChoice == 2) {

                // Asking the user to enter the details manually
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

                // Parsing the number of classes as string for a condition that cannot be applied to int type
                String numberOfClassesString = Integer.toString(numberOfClasses);

                // Declaring a variable for the workload based on the number of clases
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
                // into variables to be able to check the appropriate conditions
                // First chars
                String[] studentFirstCharsSplit = studentNumber.split("(?<=\\d)(?=\\D)");
                String studentNumberFirstTwoChars = studentFirstCharsSplit[0];

                // Middle chars
                String[] studentMiddleCharsSplit = studentFirstCharsSplit[1].split("(?<=\\D)(?=\\d)");
                String studentNumberMiddleChars = studentMiddleCharsSplit[0];

                // Last chars
                String studentNumberLastCharsSplit = studentMiddleCharsSplit[1];
                String studentNumberLastChars = studentNumberLastCharsSplit;

                // Storing the first two chars of the student number as int for a condition that cannot be applied to string type
                int studentNumberFirstTwoCharsInt = Integer.parseInt(studentNumberFirstTwoChars);
                // Storing the last char of the student number as int for a condition that cannot be applied to string type
                int studentNumberLastCharsInt = Integer.parseInt(studentNumberLastChars);

                // Exception handling
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
                    // Condition to make sure there are letters after the year in the student number.
                } else if (studentNumberMiddleChars.length() < 2 || studentNumberMiddleChars.length() > 3) {
                    System.out.println("The letters in the student number have to be minimum 2 and maximum 3 characters.");
                    // Condition to make sure the last number in the student number is a number
                } else if (!studentNumberLastChars.matches("^[0-9]\\d*$")) {
                    System.out.println("Last number of the student number has to be an integer number between 1 and 200.");
                    // Condition to make sure the last number in the student number is a number between 1 and 200
                    // No need to do a regex for positive integers as this has already been parsed as integer.
                } else if (studentNumberLastCharsInt < 1 || studentNumberLastCharsInt > 200) {
                    System.out.println("Last number of the student number has to be an integer number between 1 and 200.");
                    // Condition to make sure that the student number is at least 6 chars
                } else if (studentNumber.length() < 6) {
                    System.out.println("The student 'number' must be a minimum of 6 characters.");
                    // If all conditions are met, I create the output txt file
                } else {

                    BufferedWriter bw = new BufferedWriter(new FileWriter("status.txt", true));
                    bw.write(studentNumber + " - " + surname + "\n");
                    bw.write(workload + "\n");
                    bw.close();
                    System.out.println("The status.txt file has been succesfully created.");
                }

            } else {
                System.out.println("You can only enter 1 for Standard Operation or 2 for Manual Input.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
