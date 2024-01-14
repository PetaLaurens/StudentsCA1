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
            String studentFullName = lines.get(0);
            Integer numberOfClasses = Integer.parseInt(lines.get(1));
            String studentsID = lines.get(2);
            
            // Finding where the position of the space is to see where the name ends
            int locationSpace = studentFullName.indexOf(" ");
            
            // Finding the position of the last char to see where the surname ends
            int locationLastChar = studentFullName.length()-1 ;
            
            // Storing name and surname in separate variables
            String name = studentFullName.substring(0,locationSpace);
            String surname = studentFullName.substring(locationSpace+1,locationLastChar);
            

            System.out.println(studentFullName);
            System.out.println(numberOfClasses);
            System.out.println(studentsID);
            System.out.println(name);
            System.out.println(surname);
            

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
