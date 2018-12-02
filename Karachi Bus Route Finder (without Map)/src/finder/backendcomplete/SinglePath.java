/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder.backendcomplete;

import java.io.IOException;

/**
 *
 * @author Ibrahim_Khawaja
 */
public class SinglePath extends Route{
    public RouteBusList list;
    
    public void SinglePath(){
        this.list=new RouteBusList();
    }
    
    public void findPaths(String CurrentStop,String DestinationStop) throws IOException{
        Filing file=new Filing();
        this.list=new RouteBusList();
        String Bus=file.readLine();
        myArrayList path=new myArrayList();
        
        while(Bus!=null){
            path=path.split(file.readLine(),"- ");
            if(path.contains(CurrentStop) && path.contains(DestinationStop)){
               list.add(Bus, path);
            }
         Bus=file.readLine();
        }
        for (int i = 0; i < list.size(); i++) {
            int initial=this.list.RouteAndBusList[i].BusRoute.getIndex(CurrentStop);
            //System.out.println(initial);
            int end=this.list.RouteAndBusList[i].BusRoute.getIndex(DestinationStop);
            //System.out.println(end);
            myArrayList temp=this.list.RouteAndBusList[i].BusRoute.subArrayList(initial, end);
            this.list.RouteAndBusList[i].BusRoute=temp;
        }        
    }
            
     public RouteBusList returnList(){
        return this.list;
    }
    
    @Override
    public String toString(){
       return super.toString();
    }
}
