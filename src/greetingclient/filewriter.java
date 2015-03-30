/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetingclient;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SHANKAR
 */
public class filewriter {
    public static void main(String [] args){
    File file = new File("H:\\friendslist.doc");
       if (!file.exists()) {
              try {
                  file.createNewFile();
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
                          
                        bw.write("vivek");
			bw.close();
                         } catch (IOException ex) {
                  Logger.getLogger(NewJFrame3.class.getName()).log(Level.SEVERE, null, ex);
              }
       
    }
    
}}
