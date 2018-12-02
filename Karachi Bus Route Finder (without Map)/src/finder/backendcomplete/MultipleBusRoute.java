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
public class MultipleBusRoute extends Route{
   //Composite class 
    
    Filing file;
    String currentStop;
    String destinationStop;
    String commonStop;
    RouteBusList BusList;
     
    
    public MultipleBusRoute() throws IOException{
        this.file=new Filing(); 
        this.currentStop=null;
        this.destinationStop=null;
        this.commonStop=null;
        this.BusList=new RouteBusList();
    }
    
    public MultipleBusRoute(String currentStop,String destinationStop) throws IOException{
        this.file=new Filing();
        this.currentStop=currentStop;
        this.destinationStop=destinationStop;
        this.commonStop=null;
        this.BusList=new RouteBusList();
    }
    
    public void FindInFile() throws IOException{
        RouteBusList bList_Current=new RouteBusList();
        RouteBusList bList_Destination=new RouteBusList();        
        String bus=this.file.readLine();
        myArrayList route=new myArrayList();
        while(bus!=null){
           route=route.split(this.file.readLine(),"- "); 
            if(route.contains(this.currentStop)){
                bList_Current.add(bus,route);        
            }
            if(route.contains(this.destinationStop)){
                bList_Destination.add(bus,route);
            }
         bus=this.file.readLine();
        }
        this.file.Close();        
        searchForCommonStop(bList_Current,bList_Destination);
    }
//common stop is search in this method
    public void searchForCommonStop(RouteBusList bList_Current,RouteBusList bList_Destination){           
        for (int i = 0; i < bList_Current.size(); i++) {  
            for (int j = 0; j < bList_Destination.size(); j++) {
                int flag=0;
                for (int k = 0; k < bList_Current.RouteAndBusList[i].BusRoute.size(); k++) {
                    for (int l = 0; l < bList_Destination.RouteAndBusList[j].BusRoute.size(); l++) {
                        if (((this.BusList.hasBus(bList_Current.RouteAndBusList[i].BusName))==false) || (((this.BusList.hasBus(bList_Destination.RouteAndBusList[j].BusName)))==false)) {
                            if(bList_Current.RouteAndBusList[i].BusRoute.get(k).equals(bList_Destination.RouteAndBusList[j].BusRoute.get(l)))
                           {  
                               this.commonStop=bList_Current.RouteAndBusList[i].BusRoute.get(k);  
                               String b_name=bList_Current.RouteAndBusList[i].BusName;
                               b_name=b_name+" and "+bList_Destination.RouteAndBusList[j].BusName+" meet at "+this.commonStop;
                               myArrayList temp=bList_Current.RouteAndBusList[i].BusRoute.subArrayList(bList_Current.RouteAndBusList[i].BusRoute.getIndex(this.currentStop),bList_Current.RouteAndBusList[i].BusRoute.getIndex(this.commonStop));                               
                               myArrayList temp2=bList_Destination.RouteAndBusList[j].BusRoute.subArrayList(bList_Destination.RouteAndBusList[j].BusRoute.getIndex(this.commonStop),bList_Destination.RouteAndBusList[j].BusRoute.getIndex(this.destinationStop));
                               myArrayList temp3=temp.extend(temp2);
                            RouteBus temp4=new RouteBus(b_name,temp3);
                            this.BusList.add(temp4);  
                            flag=1;                           
                            break;
                           }                         
                        }
                    }
                    if (flag==1)
                    {
                        break;
                    }
                }
            }
        }        
    }
      
    public void sort(){
        super.sort_shortestPath(BusList);
    }    
    
    public RouteBusList returnList(){
        return this.BusList;
    }
            
    
    @Override
    public String toString(){
         //the super method is called
         return super.toString();
//         String temp="";
//         for (int i = 0; i < 10; i++) {
//            String[] str=this.BusList.RouteAndBusList[i].BusName.split(" and ");
//            RouteBus rb=null; 
//            try {
//                //System.out.println(str[0]);
//                  rb=new RouteBus(str[0]);
//                 rb.BusRoute=rb.BusRoute.subArrayList(rb.BusRoute.getIndex(this.currentStop), rb.BusRoute.getIndex(this.commonStop));
//             } catch (IOException ex) {
//                 Logger.getLogger(MultipleBusRoute.class.getName()).log(Level.SEVERE, null, ex);
//             }
//            str=str[1].split(" meet");
//           RouteBus rb1=null; 
//            try {
//                //System.out.println(str[0]);
//                  rb1=new RouteBus(str[0]);
//                 rb1.BusRoute=rb1.BusRoute.subArrayList(rb1.BusRoute.getIndex(this.commonStop), rb1.BusRoute.getIndex(this.destinationStop));
//             } catch (IOException ex) {
//                 Logger.getLogger(MultipleBusRoute.class.getName()).log(Level.SEVERE, null, ex);
//             }
//            temp=temp+rb.toString();
//            temp=temp+rb1.toString();
//        }
//         return temp;
         
    }
    
}
 