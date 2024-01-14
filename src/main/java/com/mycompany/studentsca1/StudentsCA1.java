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
            
            // Full name
            String studentFullName = lines.get(0);
            // Number of classes
            // CREATE EXCEPTION FOR THIS INPUT TO BE A POSITIVE INTEGER NUMBER
            Integer numberOfClasses = Integer.parseInt(lines.get(1));
            // ID
            String studentsID = lines.get(2);
            
            // Storing the first two chars of the ID to be able to check the conditions
            String studentsIDFirstTwoChars = studentsID.substring(0,2);
            // Storing the middle chars of the ID to be able to check the conditions
            String studentsIDMiddleChars;
            // Storing the last chars of the ID to be able to check the conditions
            String studentsIDLastChars;
            
            
            // Condition to make sure there is a dash in the file
            // before declaring different variables based on this dash.
            if (!studentFullName.contains(" ")) {
                System.out.println("Please include a space ' ' between the name and the surname.\n"); 
            }
            
            
            // Finding where the position of the space is to see where the name ends
            int locationSpace = studentFullName.indexOf(" ");
            
            // Finding the position of the last char to see where the surname ends
            int locationLastChar = studentFullName.length()-1 ;
            
            // Storing name and surname in separate variables
            String name = studentFullName.substring(0,locationSpace);
            String surname = studentFullName.substring(locationSpace+1,locationLastChar);

            // Exception handling.
            // 1st condition to make sure that the first name is in letters.
            if (!name.matches("[a-zA-Z]+")) {
                System.out.println("The first name must be letters only.");
                // 2nd condition to make sure that the surname is letters and/or numbers.
                } else if (!surname.matches("[a-zA-Z0-9]+")) {
                    System.out.println("The surname must be letters and/or numbers.");
                    // 3rd condition to make sure that the number of classes is between 1 and 8 (inclusive).
                    // No need to do a regex for positive integers as this has already been parsed as integer.
                    } else if (numberOfClasses < 0 || numberOfClasses > 8) {
                        System.out.println("The number of classes must be an integer value between 1 and 8 (inclusive).");
                        // 4th condition to make sure that the first two chars of the student ID number are positive integers.
                        } else if (!studentsIDFirstTwoChars.matches("[0-9]+")) {
                                System.out.println("The first two chars of the student ID number must be positive integer numbers.");
                            }
            

            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
