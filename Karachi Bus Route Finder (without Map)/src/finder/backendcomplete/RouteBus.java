/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder.backendcomplete;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ibrahim_Khawaja
 */
public class RouteBus extends RouteFinder{
   //it is implementing the abstract method
    String BusName;
    myArrayList BusRoute;
    //int fare;
    
    public RouteBus(String BusName,String BusRoute){
        this.BusName = BusName;
        this.BusRoute=new myArrayList();
        String[] temp=BusRoute.split("- ");
        for (int i = 0; i < temp.length; i++) {
            this.BusRoute.add(temp[i]);
        }
    }
    
    public RouteBus(String BusName) throws IOException{
        this.readFromFile();
        this.BusName = BusName;         
        String[] temp=this.hasAllRoutes.get(BusName).split("- ");
        this.BusRoute=new myArrayList();
        for (int i = 0; i < temp.length; i++) {            
            this.BusRoute.add(temp[i]);       
        }
    }
    
    public RouteBus(String BusName,myArrayList BusRoute){
        this.BusName=BusName;
        this.BusRoute=BusRoute;
    }
    
    public RouteBus(RouteBus temp){
        this(temp.BusName,temp.BusRoute);
    }

    @Override
    public void getRoutes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
//        String s="";
//        for (int i = 0; i < this.BusRoute.size()-1; i++) {
//            s=s+this.BusRoute.get(i);
//            s=s+" -> ";
//        }
//        s=s+this.BusRoute.get(this.BusRoute.size()-1);
//       return s;
    String s="";
        for (int i = 0; i < this.BusRoute.size()-1; i++) {
            s=s+this.BusRoute.get(i);
            s=s+" -> ";
        }
        s=s+this.BusRoute.get(this.BusRoute.size()-1)+"\n";
        TimeComlexity tc=null;
        int z=0;
        try {
             tc=new TimeComlexity(new RouteBus(this.BusName,this.BusRoute));
             z=tc.ArrivalTime.length;
        } catch (IOException ex) {
            Logger.getLogger(RouteBus.class.getName()).log(Level.SEVERE, null, ex);
        }
        s=s+"Timing:\n";
        for (int j = 0; j < z; j++) {
            if (j>0) {
               s=s+"\n"; 
            }
            s=s+"Arrival of "+this.BusName+" at "+this.BusRoute.get(0)+": "+tc.ArrivalTime[j].toString()+"\n";
            s=s+"Departure of "+this.BusName+" at "+this.BusRoute.get(this.BusRoute.size()-1)+": "+tc.DepartureTime[j].toString();
        }
        //System.out.println(this.BusRoute.size());
       return s;
    

    }
    
    public int fareCalculator(){
       String[] temp=this.BusName.split(" ");
        if (temp.length>3) {
            if (((this.BusRoute.size()/2)>4) &&((this.BusRoute.size()/2)<=7)){
                return 30;
            }
            if((this.BusRoute.size()/2)<=4){
                return 20;
            }
            if ((this.BusRoute.size()/2)>7) {
                return 40;
            }
        }
        else{
            if (this.BusRoute.size()>4 && this.BusRoute.size()<7) {
                return 15;
            }
            if (this.BusRoute.size()<=4) {
                return 10;
            }
            if (this.BusRoute.size()>7) {
                return 20;
            }
        }
        return 0;
    }
    
    @Override
    public RouteBus clone(){
        RouteBus temp=new RouteBus(this.BusName,this.BusRoute);
        return temp;
    }    
}
