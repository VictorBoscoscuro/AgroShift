/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroshift;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author victo
 */
public class tests {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = "2021-08-09";
        LocalDate parsedDate = LocalDate.parse(date,formatter);
        System.out.println(parsedDate+"\n"+date);
        if(parsedDate.isAfter(LocalDate.now())){
            System.out.println("OK----");
        }
        
    }
}
