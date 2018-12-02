/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder.backendcomplete;

//import java.io.BufferedReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Asad
 */
public class FileInputBusesNamesForList {
    
    public ArrayList<String> readInput(String path) throws IOException{
            ArrayList<String> lines = new ArrayList<>();
            File f = new File(path);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String temp="";
            while((temp=br.readLine()) != null){
                lines.add(temp);
            }
            return lines;
    }
}
