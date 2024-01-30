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

    public static void main(String[] args) {

        try {

            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter S for Standard Operation or M for Manual Input: ");
            String userChoice = scan.next();

            if (!userChoice.matches("[a-zA-Z]+$")) {
                System.out.println("Please enter S for Standard Operation or M for Manual Input.");

            } else if (userChoice.matches("S")) {

                TxtFileHandling reading = new TxtFileHandling();
                reading.standardOperation();

            } else if (userChoice.matches("M")) {

                UserInput input = new UserInput();
                input.userManualInput();

            } else {
                System.out.println("Please enter S for Standard Operation or M for Manual Input.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
