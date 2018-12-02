/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder.backendcomplete;

/**
 *
 * @author Ibrahim_Khawaja
 */
public class Route {
    
   private RouteBusList routeBus;
    
    public Route(){
        this.routeBus=new RouteBusList();
    }
    
   public void sort_shortestPath(RouteBusList list){
        int count=0;
        while(count!=list.getCountRoutes()-1){
            count=0;
            for (int i = 0; i < list.getCountRoutes()-1; i++) {
                if (list.RouteAndBusList[i].BusRoute.size()>list.RouteAndBusList[i+1].BusRoute.size()) {
                    RouteBus temp=new RouteBus(list.RouteAndBusList[i]);
                    list.RouteAndBusList[i]=list.RouteAndBusList[i+1].clone();
                    list.RouteAndBusList[i+1]=temp.clone();
                    //continue;                    
                }
                else{
                    count++;
                }
            }
        }
    }
   
   @Override
   public String toString(){
       return this.routeBus.toString();
   }
}
