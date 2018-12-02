/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder.backendcomplete;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Ibrahim_Khawaja
 */
public class TimeComlexity {
          int[] time;
          Time totalTrip;
          Time[] ArrivalTime;
          Time[] DepartureTime;
          //System.out.println(df.format(dateobj));
          //
          //System.out.println(str);
          //Random time=new Random();
          //System.out.println(time.nextInt(5));
          
          public TimeComlexity(RouteBus bus) throws IOException{
              
              DateFormat df=new SimpleDateFormat("HH:mm:SS");
              Date dateobj=new Date();
              Filing file=new Filing();
              Map<String,String> allData=file.getAllBus_route();
              //System.out.println(bus.BusName);
              String[] str=bus.BusName.split(" and ");
              
              if (str.length>1) {
                  this.ArrivalTime=new Time[2];
                  this.DepartureTime=new Time[2];
                  String[] str1=str[1].split(" meet at ");
                  String[] stops=allData.get(str[0]).split("- ");
                  int temp=0;
              for (int i = 1; i < stops.length; i++) {
                  temp=temp+7;
              }
              this.totalTrip=new Time();
              totalTrip.Hours=temp/60;
              totalTrip.Mins=temp%60;                      
              this.time=new int[29];
              time[0]=0;
              for (int i = 1; i < 29; i++) {
                 time[i]=time[i-1]+20;    
              }
              
              int[] times=getInitialAndFinalTime(str[0],bus.BusRoute.get(0),str1[1]);
              this.ArrivalTime[0]=this.convertToOriginalTime(times[0]);
              this.DepartureTime[0]=this.convertToOriginalTime(times[1]);
              
              ////second bus 
                  stops=allData.get(str1[0]).split("- ");
                  temp=0;
              for (int i = 1; i < stops.length; i++) {
                  temp=temp+7;
              }
              this.totalTrip=new Time();
              totalTrip.Hours=temp/60;
              totalTrip.Mins=temp%60;                      
              this.time=new int[29];
              time[0]=0;
              for (int i = 1; i < 29; i++) {
                 time[i]=time[i-1]+20;    
              }
              
              times=getInitialAndFinalTime(str[0],bus.BusRoute.get(0),str1[1]);
              this.ArrivalTime[1]=this.convertToOriginalTime(times[0]);
              this.DepartureTime[1]=this.convertToOriginalTime(times[1]);
                  
              }
              else{
              this.ArrivalTime=new Time[1];
              this.DepartureTime=new Time[1];
              String[] stops=allData.get(bus.BusName).split("- ");
              int temp=0;
              for (int i = 1; i < stops.length; i++) {
                  temp=temp+7;
              }
              this.totalTrip=new Time();
              totalTrip.Hours=temp/60;
              totalTrip.Mins=temp%60;                      
              this.time=new int[29];
              time[0]=0;
              for (int i = 1; i < 29; i++) {
                 time[i]=time[i-1]+20;    
              }
              
              int[] times=getInitialAndFinalTime(bus.BusName,bus.BusRoute.get(0),bus.BusRoute.get(bus.BusRoute.size()-1));
              this.ArrivalTime[0]=this.convertToOriginalTime(times[0]);
              this.DepartureTime[0]=this.convertToOriginalTime(times[1]);
              }
          }
          
          public TimeComlexity(String bus,String initial,String Destination) throws IOException{
              DateFormat df=new SimpleDateFormat("HH:mm:SS");
              Date dateobj=new Date();
              Filing file=new Filing();
              Map<String,String> allData=file.getAllBus_route();
              String[] stops=allData.get(bus).split("- ");
              int temp=0;
              for (int i = 1; i < stops.length; i++) {
                  temp=temp+7;
              }
              this.totalTrip=new Time();
              totalTrip.Hours=temp/60;
              totalTrip.Mins=temp%60;                      
              this.time=new int[29];
              time[0]=0;
              for (int i = 1; i < 29; i++) {
                 time[i]=time[i-1]+20;    
              }
              
              int[] times=getInitialAndFinalTime(bus,initial,Destination);
              this.ArrivalTime=new Time[1];
              this.DepartureTime=new Time[1];
              
              this.ArrivalTime[0]=this.convertToOriginalTime(times[0]);
              this.DepartureTime[0]=this.convertToOriginalTime(times[1]);
              
          }
          
          public Time getHoursAndMins(){
              DateFormat df=new SimpleDateFormat("HH:mm:SS");
              Date dateobj=new Date();
              String str=(String)df.format(dateobj);
              String[] arr=str.split(":");
          
          Time temp =new Time();
          String amPm="A.M";
          temp.Hours=Integer.parseInt(arr[0]);
          if (temp.Hours>12) {
            temp.Hours=temp.Hours-12;
            amPm="P.M";
          }
          temp.Mins=Integer.parseInt(arr[1]);
          //System.out.println(temp.Hours+":"+temp.Mins+" "+amPm);
          return temp;
          }
          
          public int getInitialTime(String Bus,String Location) throws IOException{
              Filing file=new Filing();
              Map<String,String> allData=file.getAllBus_route();
              String[] stops=allData.get(Bus).split("- ");
              int currentTime=this.convertCurrentTime();
              int index=getIndex(Location,stops);
              for (int i = 0; i < this.time.length; i++) {
                  int[] temp= this.getTimesOfAllStops(this.time[i], stops);
                  if (currentTime<temp[index]) {
                       return temp[index];
                  }
              }
              return -1;
          }
          
          public int getIndex(String str,String[] stops){
              for (int i = 0; i < stops.length; i++) {
                  if (stops[i].equals(str)) {
                      return i;
                  }
              }
              return -1;
          }
          
          public int[] getTimesOfAllStops(int time,String[] stops){
              int[] temp=new int[stops.length];
              Random traffic=new Random();
              temp[0]=time;
              for (int i = 1; i < stops.length; i++) {
                  temp[i]=temp[i-1]+7+traffic.nextInt(5);
                  //System.out.println(temp[i]);
              }
              return temp;
          }
          public int[] getInitialAndFinalTime(String Bus,String InitialLocation,String FinalLocation) throws IOException{
              int[] temp=new int[2];
              Filing file=new Filing();
              Map<String,String> allData=file.getAllBus_route();
              String[] stops=allData.get(Bus).split("- ");
              int currentTime=this.convertCurrentTime();
             // System.out.println(currentTime);
              int InitialIndex=getIndex(InitialLocation,stops);
              int FinalIndex=getIndex(FinalLocation,stops);
              for (int i = 0; i < stops.length; i++) {
                  int[] temp1= this.getTimesOfAllStops(this.time[i], stops);
                  for (int j = 0; j < temp1.length; j++) {
                      //System.out.println(temp1[i]);
                  }
                  if (currentTime<temp1[InitialIndex]) {
                        temp[0]=currentTime;
                       // System.out.println(temp[0]);
                        temp[1]=temp1[FinalIndex];
                        //System.out.println(temp[1]);
                        break;
                  }
              }
              return temp;
          }
          public int convertCurrentTime(){
              Time temp=new Time();
              temp.Hours=temp.Hours-7;
              //System.out.println(temp.Hours);
              int temp1=temp.Hours*60;
              temp1=temp1+temp.Mins;
              //System.out.println(temp.Mins);
              //System.out.println(temp1);
              return temp1;
          }
          public Time convertToOriginalTime(int time){
              Time temp=new Time();
              //System.out.println(time);
              temp.Hours=(time/60)+7;
              temp.Mins=time%60;
              //System.out.println(temp.Hours+":"+temp.Mins);
              if (temp.Hours>12) {
                  temp.Hours=temp.Hours-12;
                  temp.changeAMPM();
              }
              if (temp.Hours==12) {
                  temp.changeAMPM();
              }
              
              return temp;
          }
}
