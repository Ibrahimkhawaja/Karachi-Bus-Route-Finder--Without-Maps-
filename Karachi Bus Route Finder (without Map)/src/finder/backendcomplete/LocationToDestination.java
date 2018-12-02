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
public class LocationToDestination extends RouteFinder{
    private String CurrentStop;
    private String DestinationStop;
    public RouteBusList list;
    
    public String getCurrentStop() {
        return CurrentStop;
    }

    public void setCurrentStop(String CurrentStop) {
        this.CurrentStop = CurrentStop;
    }

    public String getDestinationStop(){
        return DestinationStop;
    }

    public void setDestinationStop(String DestinationStop) {
        this.DestinationStop = DestinationStop;
    }
    
    public void setDestinationAndCurrentStop(String CurrentStop,String DestinationStop) {
        this.CurrentStop=CurrentStop;
        this.DestinationStop = DestinationStop;
    }
    
    public LocationToDestination(String CurrentStop,String DestinationStop) throws IOException{
        //SinglePath sp=new SinglePath();
        //sp.findPaths(CurrentStop, DestinationStop);
        //this.list=sp.returnList();
        Filing f1=new Filing("./src/finder/backendcomplete/buses.txt");
        Filing f2=new Filing("./src/finder/backendcomplete/stops.txt");
        myArrayList buses=f1.getArray();
        myArrayList stops=f2.getArray();
        Graph g=new Graph(buses,stops);
        this.list=g.getBusandRoute(CurrentStop, DestinationStop);
        
        if(list.size()==0){
            
            MultipleBusRoute mr=new MultipleBusRoute(CurrentStop,DestinationStop);
            mr.FindInFile();
            if (mr.BusList.size()>0) {
                mr.sort();
            }
            //System.out.println("heloo");
            //System.out.println(mr.BusList.RouteAndBusList[0].BusName);
            this.list=mr.returnList();
            //System.out.println("hello");
            //System.out.println(mr.BusList.RouteAndBusList[0].BusName);
            //System.out.println(mr.toString());
        }
        if(this.list.size()>0)
        this.list.sort_shortestPath(this.list);
    }

    @Override
    public void getRoutes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getShortestPath(){
        if(this.list.size()>0)
        this.list.sort_shortestPath(list);
    }

    @Override
    public String toString() {
      return this.list.toString();
    }
}
