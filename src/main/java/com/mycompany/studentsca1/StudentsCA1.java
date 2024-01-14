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
            String studentsName = lines.get(0);
            Integer numberOfClasses = Integer.parseInt(lines.get(1));
            String studentsID = lines.get(2);
            
            System.out.println(studentsName);
            System.out.println(numberOfClasses);
            System.out.println(studentsID);
            

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
