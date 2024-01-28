/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.studentsca1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author peta
 */
public class StudentsCA1 {

    public static void main(String[] args) throws IOException {
        
        try {
            // Reading the students.txt file
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            String studentsFile = br.readLine();
            
            while (studentsFile != null) {
                studentsFile = br.readLine();
            }
            br.close();
            

            // Storing each line from the txt file into a variable
            List<String> lines = Files.lines(Paths.get("students.txt")).collect(Collectors.toList());

            // Starting point of txt file lines
            int lineZero = 0;
            int lineOne = 1;
            int lineTwo = 2;
            
            
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
            int locationLastCharStudentFullName = studentFullName.length()-1 ;
            
            // Storing name and surname in separate variables
            String name = studentFullName.substring(0,locationSpace);
            String surname = studentFullName.substring(locationSpace+1,locationLastCharStudentFullName+1);

            
            /// NUMBER OF CLASSES ///
            // CREATE EXCEPTION FOR THIS INPUT TO BE A POSITIVE INTEGER NUMBER
            String numberOfClasses = (lines.get(lineOne));
            int numberOfClassesInt = Integer.parseInt(numberOfClasses);
            

            
            /// STUDENT NUMBER ///
            String studentNumber = lines.get(lineTwo);
            
            // Using split method and regex to store the different characters into variables
            // to be able to check the appropriate conditions
            
            // First chars
            String[] studentFirstCharsSplit = studentNumber.split("(?<=\\d)(?=\\D)");
            String studentNumberFirstTwoChars = studentFirstCharsSplit[0];
            
            // Middle chars
            String[] studentMiddleCharsSplit = studentFirstCharsSplit[1].split("(?<=\\D)(?=\\d)");
            String studentNumberMiddleChars = studentMiddleCharsSplit[0];
            
            // Last chars
            String studentNumberLastCharsSplit = studentMiddleCharsSplit[1];
            String studentNumberLastChars = studentNumberLastCharsSplit;
            

            // Storing the first two chars of the student number as int for a different condition that cannot be aplied to string type
            int studentNumberFirstTwoCharsInt = Integer.parseInt(studentNumberFirstTwoChars);
            // Storing the last char of the student number as int for a different condition that cannot be aplied to string type
            int studentNumberLastCharsInt = Integer.parseInt(studentNumberLastChars);
            

            //////////////////// Exception handling ////////////////////
            
            // Condition to make sure that the first two chars of the student number are positive integers.
            if (!studentNumberFirstTwoChars.matches("^[1-9]\\d*$")) {
                System.out.println("The first two chars of the student number must be positive integer numbers.");
                // Condition to make sure that the first number of the student number is at least 20, to represent the year.
                // No need to do a regex for positive integers as this has already been parsed as integer.
                } else if (studentNumberFirstTwoCharsInt < 20) {
                    System.out.println("The first numbers of the student number must be at least 20, to represent the year.");
                    // Condition to make sure there are letters after the year in the student number.
                    } else if (!studentNumberMiddleChars.matches("[a-zA-Z]+")) {
                        System.out.println("The 3rd, 4th and possibly 5th character of the student number must be letters.");
                        // Condition to make sure there are letters after the year in the student number.
                        } else if (studentNumberMiddleChars.length() > 3) {
                            System.out.println("The letters in the student number have to be maximum 3 characters.");
                            // Condition to make sure the last number in the student number is a number
                            } else if (!studentNumberLastChars.matches("^[0-9]\\d*$")) {
                                System.out.println("Last number of the student number has to be an integer number between 1 and 200.");
                                // Condition to make sure the last number in the student number is a number between 1 and 200
                                // No need to do a regex for positive integers as this has already been parsed as integer.
                                } else if (studentNumberLastCharsInt < 1 || studentNumberLastCharsInt > 200) {
                                    System.out.println("Last number of the student number has to be an integer number between 1 and 200.");
                                    // If all conditions are met, I create the output txt file
                                    } else {
                                        String studentNumberFinal = studentNumberFirstTwoChars + studentNumberMiddleChars + studentNumberLastChars;
                                        
                                        BufferedWriter bw = new BufferedWriter(new FileWriter("status.txt", true));
                                        bw.write(studentNumberFinal + " - ");
                                        bw.close();
                                        System.out.println("The student number has been added to the status.txt file");
                                        lineTwo += 3;
            }
            

            // Condition to make sure that the first name is in letters.
            if (!name.matches("[a-zA-Z]+")) {
                System.out.println("The first name must be letters only.");
            // Condition to make sure that the surname is letters and/or numbers.
                } else if (!surname.matches("[a-zA-Z0-9]+")) {
                    System.out.println("The surname must be letters and/or numbers.");
                    } else {
                        String surnameFinal = surname;

                        BufferedWriter bw = new BufferedWriter(new FileWriter("status.txt", true));
                                                bw.write(surnameFinal + "\n");
                                                bw.close();
                                                System.out.println("The surname has been added to the status.txt file");
                                                
                        
                    }
            
            
            // Condition to make sure that the number of classes is an integer NOT WORKING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            if (!numberOfClasses.matches("^[1-9]\\d*$")) {
                System.out.println("The number of classes must be an integer value between 1 and 8 (inclusive).");
                // Condition to make sure that the number of classes is between 1 and 8 (inclusive).
                // No need to do a regex for positive integers as this has already been parsed as integer.
                } else if (numberOfClassesInt < 0 || numberOfClassesInt > 8) {
                    System.out.println("The number of classes must be an integer value between 1 and 8 (inclusive).");
                    } else {

                        int numberOfClassesFinal = numberOfClassesInt;
                        // Declaring a variable for the workload based on the number of clases
                        String workload = "";

                        if (numberOfClassesFinal == 1) {
                            workload = "Very Light";
                            } else if (numberOfClassesFinal == 2) {
                                workload = "Light";
                                } else if (numberOfClassesFinal >= 3 && numberOfClassesFinal <= 5) {
                                    workload = "Part Time";
                                    } else if (numberOfClassesFinal >= 6) {
                                        workload = "Full Time";
                                        }
                        
                        BufferedWriter bw = new BufferedWriter(new FileWriter("status.txt", true));
                        bw.write(workload + "\n");
                        bw.close();
                        System.out.println("The workload has been added to the status.txt file");
                        lineOne += 3;
                }

                        
        } catch (Exception e) {
            System.out.println(e);
        }
        }
    }
                                
            




