/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder.backendcomplete;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ibrahim_Khawaja
 */
public class Filing {
     FileReader fr;
     BufferedReader br;
     Map<String,String> bus_route;
    
    public  Filing () throws FileNotFoundException, IOException {
            this.fr=new FileReader("./src/finder/backendcomplete/Datas.txt");
            this.br=new BufferedReader(fr);
    }
    
    public  Filing (String Filename) throws FileNotFoundException, IOException {
            this.fr=new FileReader(Filename);
            this.br=new BufferedReader(fr);        
    }
    
    public String readLine() throws IOException{
        return br.readLine();
    }
    
    public void Close() throws IOException{
        br.close();
    }

    public void setBus_route(Map<String, String> bus_route) throws IOException {
        this.bus_route=this.getAllBus_route();
    }
    
    public myArrayList getArray() throws IOException{
        myArrayList temp=new myArrayList();
        String str=br.readLine();
        while(str!=null){
            temp.add(str);
            str=br.readLine();
        }   
        return temp;
    }
  
    public Map<String,String> getAllBus_route() throws IOException{
        Map<String,String> Dictionary=new HashMap<String,String>();
        String bus=br.readLine();
        String bus_r=br.readLine();
            while(bus!=null){
                Dictionary.put(bus, bus_r);  
                bus=br.readLine();
                bus_r=br.readLine();
            }    
            this.br.close();
            return Dictionary;
    }    
}
