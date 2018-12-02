/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder.backendcomplete;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ibrahim_Khawaja
 */
public class Time {
    int Hours;
    int Mins;
    //String amPm;
    enum TimeStatus {AM,PM};
    TimeStatus amPm;
    
    public Time(){
        DateFormat df=new SimpleDateFormat("HH:mm:SS");
        Date dateobj=new Date();
        String str=(String)df.format(dateobj);
        String[] arr=str.split(":");
        this.amPm=TimeStatus.AM;
        this.Hours=Integer.parseInt(arr[0]);
        this.Mins=Integer.parseInt(arr[1]);
    }
   
    public void changeAMPM(){
        if (this.amPm==TimeStatus.AM) {
            this.amPm=TimeStatus.PM;
        }
        else{
            this.amPm=TimeStatus.AM;
        }
    }
    
    @Override
    public String toString(){
        return this.Hours+":"+this.Mins+this.amPm;
    }
}
