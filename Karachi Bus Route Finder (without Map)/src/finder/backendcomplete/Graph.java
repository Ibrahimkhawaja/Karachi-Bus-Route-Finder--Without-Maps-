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
public class Graph {
    int[][] graph;
    myArrayList buses;
    myArrayList stops;
    
    public Graph(myArrayList buses,myArrayList stops) throws IOException {
        this.buses=buses;
        this.stops=stops;
        graph=new int[buses.size()][stops.size()];
        RouteBusList list=new RouteBusList();
        for (int i = 0; i < buses.size(); i++) {
            RouteBus temp=new RouteBus(buses.get(i));
            list.add(temp);
        }
        for (int i = 0; i < buses.size(); i++) {
            for (int j = 0; j < stops.size(); j++) {
               if( list.RouteAndBusList[i].BusRoute.contains(stops.get(j))==true){
                   graph[i][j]=1;
               }
               else{
                   graph[i][j]=0;
               }                
            }
        }        
    }
    
    public RouteBusList getBusandRoute(String currentLocation,String destinationLocation) throws IOException{
        RouteBusList temp=new RouteBusList();
        int cl=stops.getIndex(currentLocation);
        int dl=stops.getIndex(destinationLocation);
        for (int i = 0; i < 106; i++) {
            if ((graph[i][cl]==1) && (graph[i][dl]==1)) {
                RouteBus temp1=new RouteBus(buses.get(i));
                temp1.BusRoute=temp1.BusRoute.subArrayList(temp1.BusRoute.getIndex(currentLocation),temp1.BusRoute.getIndex(destinationLocation));
                temp.add(temp1);
            }
        }
        return temp;
    }
}
