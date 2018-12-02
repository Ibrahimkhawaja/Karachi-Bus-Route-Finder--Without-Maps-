/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder.backendcomplete;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Ibrahim_Khawaja
 */
public abstract class RouteFinder {
    protected Map<String,String> hasAllRoutes;
    
    public void readFromFile() throws IOException{
        Filing file=new Filing();
        this.hasAllRoutes=file.getAllBus_route();
    }
    public abstract void getRoutes();
    
    @Override
    public abstract String toString();
    
}
