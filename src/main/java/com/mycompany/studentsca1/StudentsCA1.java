/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.studentsca1;

import java.util.Scanner;

/**
 *
 * @author peta
 */
public class StudentsCA1 {

    // Github repository: https://github.com/PetaLaurens/StudentsCA1
    
    public static void main(String[] args) {

        try {

            // Getting input from the user to see if they want Standard Operation or Manual Input program.
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter S for Standard Operation or M for Manual Input: ");
            String userChoice = scan.next();

            // Exception handling for wrong input (non S or M).
            if (!userChoice.matches("[a-zA-Z]+$")) {
                System.out.println("You can only enter S for Standard Operation or M for Manual Input.");

            // Condition to run Standard Operation program.
            } else if ((userChoice.matches("S")) || (userChoice.matches("s"))) {

                TxtFileHandling reading = new TxtFileHandling();
                reading.standardOperation();

            // Condition to run Manual Input program.
            } else if ((userChoice.matches("M")) || (userChoice.matches("m"))) {

                UserInput input = new UserInput();
                input.manualInput();

            // Exception handling for wrong input (non S or M).
            } else {
                System.out.println("You can only enter S for Standard Operation or M for Manual Input.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
