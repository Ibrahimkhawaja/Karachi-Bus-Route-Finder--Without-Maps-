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
public class RouteBusList {
     RouteBus[] RouteAndBusList;
    private int CountRoutes;
    
    public RouteBusList(){
        this.RouteAndBusList=new RouteBus[1];
        CountRoutes=0;
    }
    
    public RouteBusList(RouteBus[] temp){
        this.RouteAndBusList=temp;
    }
    
    public int getCountRoutes(){
        return this.CountRoutes;
    }
    
    public void add(String BusName,myArrayList BusRoute){
        if (this.RouteAndBusList.length==CountRoutes) {
            this.increaseSize();
        }
        this.RouteAndBusList[CountRoutes]=new RouteBus(BusName,BusRoute);
        CountRoutes++;    
    }
    
    public void add(String BusName,String BusRoute){
        if (this.RouteAndBusList.length==CountRoutes) {
            this.increaseSize();
        }
        this.RouteAndBusList[CountRoutes]=new RouteBus(BusName,BusRoute);
        CountRoutes++;
    }
    
    public RouteBusList(RouteBusList temp){
        this(temp.RouteAndBusList);
    }
    
    public void add(RouteBus temp){
        if (this.RouteAndBusList.length==CountRoutes) {
            this.increaseSize();
        }
        this.RouteAndBusList[CountRoutes]=new RouteBus(temp);
        CountRoutes++;
    }
    
    public void increaseSize(){
        RouteBus[] temp=new RouteBus[CountRoutes+1];
        for (int i = 0; i < this.RouteAndBusList.length; i++) {
            temp[i]=new RouteBus(this.RouteAndBusList[i]);
        }
        this.RouteAndBusList=temp;
    }
    
    public int size(){
        return CountRoutes;
    }
    
    public boolean hasBus(String busName){
        for (int i = 0; i < CountRoutes; i++) {
            if(this.RouteAndBusList[i].BusName.equals(busName)){
                return true;
            }   
        }
        return false;
    }
    
    public void sort_shortestPath(RouteBusList list){
        int count=0;
        while(count!=list.CountRoutes-1){
            count=0;
            for (int i = 0; i < list.CountRoutes-1; i++) {
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
        String temp="";
        for (int i = 0; i < this.RouteAndBusList.length; i++) {
            if(i>0){
                temp=temp+"\n";
            }
            temp=temp+this.RouteAndBusList[i].BusName+"\n";
            temp=temp+this.RouteAndBusList[i]+"\n";
            temp=temp+"Fare: Rs."+this.RouteAndBusList[i].fareCalculator()+"/=";
        }
        return temp;
    }
}
