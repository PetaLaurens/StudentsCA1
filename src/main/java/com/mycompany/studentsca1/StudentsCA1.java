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
import java.util.stream.Collectors;

/**
 *
 * @author peta
 */
public class StudentsCA1 {

    public static void main(String[] args) {
        
        try {
            // Reading the students.txt file
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            String studentsFile = br.readLine();
            
            while (studentsFile != null) {
                studentsFile = br.readLine();
            }

            br.close();
            

            // Storing each line from the txt file in a variable
            List<String> lines = Files.lines(Paths.get("students.txt")).collect(Collectors.toList());
            
            // Declaring a variable for the line number in the txt file (WILL CREATE A FOR LOOP LATER ON)
            int lineNumber = 0;
            
            // Full name
            String studentFullName = lines.get(0);
            // Number of classes
            // CREATE EXCEPTION FOR THIS INPUT TO BE A POSITIVE INTEGER NUMBER / also at the beginning is Integer or int
            int numberOfClasses = Integer.parseInt(lines.get(1));
            // ID
            String studentNumber = lines.get(2);
            
            
            // Condition to make sure there is a 0 for the Student number
            // before declaring different variables based on this 0.
            if (!studentNumber.contains("0")) {
                System.out.println("""
                                   The last number after the letters in the Student number,
                                   has to be a positive integer between 0001 and 0200.\n"""); 
            }
            
            // Finding where the position of the 0 is to see where the letters 
            // end and where the second number starts.
            int locationZero = studentNumber.indexOf("0");
            
            // Finding the position of the last char to see where the student number ends
            int locationLastCharStudentNumber = studentNumber.length()-1;
            
            
            // Storing the first two chars of the student number to be able to check the conditions
            String studentNumberFirstTwoChars = studentNumber.substring(0,2);
            // Storing the first two chars of the student number as int for a different condition that cannot be aplied to string type
            int studentNumberFirstTwoCharsInt = Integer.parseInt(studentNumberFirstTwoChars);
            
            // Storing the middle chars of the student number to be able to check the conditions
            String studentNumberMiddleChars = studentNumber.substring(2,locationZero);
            
            // Storing the last chars of the student number to be able to check the conditions
            String studentNumberLastChars = studentNumber.substring(locationZero, locationLastCharStudentNumber);
            // Storing the last char of the student number as int for a different condition that cannot be aplied to string type
            int studentNumberLastCharsInt = Integer.parseInt(studentNumberLastChars);
            
            
            // Condition to make sure there is a dash in the file
            // before declaring different variables based on this dash.
            if (!studentFullName.contains(" ")) {
                System.out.println("Please include a space ' ' between the name and the surname.\n"); 
            }
            
            // Finding where the position of the space is to see where the name ends
            int locationSpace = studentFullName.indexOf(" ");
            
            // Finding the position of the last char to see where the surname ends
            int locationLastCharStudentFullName = studentFullName.length()-1 ;
            
            // Storing name and surname in separate variables
            String name = studentFullName.substring(0,locationSpace);
            String surname = studentFullName.substring(locationSpace+1,locationLastCharStudentFullName+1);

            
            // Declaring a variable for the workload based on the number of clases / TO CREATE CLASSES TO BE ABLE TO CALL THIS VARIABLE
            String workload;
            
            if (numberOfClasses == 1) {
                workload = "Very Light";
                } else if (numberOfClasses == 2) {
                    workload = "Light";
                    } else if (numberOfClasses >= 3 && numberOfClasses <= 5) {
                        workload = "Part Time";
                        } else if (numberOfClasses <= 6) {
                            workload = "Full Time";
                            }
            
            

            // Exception handling.
            // Condition to make sure that the first name is in letters.
            if (!name.matches("[a-zA-Z]+")) {
                System.out.println("The first name must be letters only.");
                // Condition to make sure that the surname is letters and/or numbers.
                } else if (!surname.matches("[a-zA-Z0-9]+")) {
                    System.out.println("The surname must be letters and/or numbers.");
                    // Condition to make sure that the number of classes is between 1 and 8 (inclusive).
                    // No need to do a regex for positive integers as this has already been parsed as integer.
                    } else if (numberOfClasses < 0 || numberOfClasses > 8) {
                        System.out.println("The number of classes must be an integer value between 1 and 8 (inclusive).");
                        // Condition to make sure that the first two chars of the student ID number are positive integers.
                        } else if (!studentNumberFirstTwoChars.matches("[0-9]+")) {
                            System.out.println("The first two chars of the student number must be positive integer numbers.");
                            // Condition to make sure that the first two chars of the student ID number are between 22 and 25, to represent the year.
                            } else if (studentNumberFirstTwoCharsInt < 22 || studentNumberFirstTwoCharsInt > 25) {
                                System.out.println("The first two chars of the student number must be between 22 and 25, to represent the year");
                                // Condition to make sure there are letters after the year in the ID.
                                } else if (!studentNumberMiddleChars.matches("[a-zA-Z]+")) {
                                    System.out.println("""
                                                       The student number must be a minimum of 6 characters with the first 2 characters
                                                       being numbers, the 3rd  and 4th characters (and possibly 5th) being a letter, and everything                                                                                            
                                                       after the last letter character being a number.""");
                                    // Condition to make sure the last number in the student number is a number
                                    } else if (!studentNumberLastChars.matches("[0-9]+")) {
                                        System.out.println("Last number of the student number has to be an integer number between 0001 and 0200");
                                        // Condition to make sure the last number in the student number is a number below 200
                                        } else if (studentNumberLastCharsInt < 0001 || studentNumberLastCharsInt > 0200) {
                                            System.out.println("Last number of the student number has to be an integer number between 0001 and 0200");
                                            } else {
                                                BufferedWriter bw = new BufferedWriter(new FileWriter("status.txt", true));
                                                bw.write(studentNumber + " - " + surname + "\n" + "Workload");
                                                bw.close();
                                                System.out.println("The status.txt file has been succesfully created.");
                                                }
            
            

            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
