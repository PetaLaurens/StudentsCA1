/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.studentsca1;

import java.io.BufferedReader;
import java.io.FileReader;
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
            String studentFullName = lines.get(lineNumber);
            lineNumber =+ 1;
            // Number of classes
            // CREATE EXCEPTION FOR THIS INPUT TO BE A POSITIVE INTEGER NUMBER / also at the beginning is Integer or int
            int numberOfClasses = Integer.parseInt(lines.get(lineNumber));
            lineNumber =+ 1;
            // ID
            String studentsID = lines.get(lineNumber);
            lineNumber =+ 1;
            
            
            // Condition to make sure there is a 0 for the Student ID
            // before declaring different variables based on this 0.
            if (!studentsID.contains("0")) {
                System.out.println("""
                                   The last number after the letters in the Student ID, has to be"
                                   a positive integer between 0001 and 0200.\n"""); 
            }
            
            // Finding where the position of the 0 is to see where the letters 
            // end and where the second number starts.
            int locationZero = studentsID.indexOf("0");
            
            // Finding the position of the last char to see where the Student ID ends
            int locationLastCharStudentID = studentsID.length()-1 ;
            
            
            // Storing the first two chars of the ID to be able to check the conditions
            String studentsIDFirstTwoChars = studentsID.substring(0,2);
            
            // Storing the middle chars of the ID to be able to check the conditions
            String studentsIDMiddleChars = studentsID.substring(2,locationZero);
            // Storing the last chars of the ID to be able to check the conditions
            String studentsIDLastChars = studentsID.substring(locationZero, locationLastCharStudentID);
            // Storing the last char of the student number as int
            int studentsIDLastCharsInt = Integer.parseInt(studentsIDLastChars);
            
            
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
            String surname = studentFullName.substring(locationSpace+1,locationLastCharStudentFullName);
            

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
                        } else if (!studentsIDFirstTwoChars.matches("[0-9]+")) {
                            System.out.println("The first two chars of the student ID number must be positive integer numbers.");
                            // Condition to make sure there are letters after the year in the ID.
                            } else if (!studentsIDMiddleChars.matches("[a-zA-Z]+")) {
                                System.out.println("""
                                                   The student number must be a minimum of 6 characters with the first 2 characters
                                                   being numbers, the 3rd  and 4th characters (and possibly 5th) being a letter, and everything                                                                                            
                                                   after the last letter character being a number.""");
                                // Condition to make sure the last number in the student number is a number
                                } else if (!studentsIDLastChars.matches("[0-9]+")) {
                                    System.out.println("Last number of the student number has to be a number between 0001 and 0200");
                                    // Condition to make sure the last number in the student number is a number below 200
                                    } else if (studentsIDLastCharsInt < 0001 || studentsIDLastCharsInt > 0200) {
                                        System.out.println("Last number of the student number has to be a number between 0001 and 0200");
                                        }

            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
