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
public class myArrayList{
    private String[] str; 
    private static int objectCounter;
    
    public myArrayList(){
        this.str=new String[1];
        objectCounter=0;
    }
    
    public void add(String str){
        if (objectCounter==this.str.length){            
            this.increaseSize();
        }
        this.str[objectCounter]=str;
        objectCounter++;              
    }
    
    public boolean contains(String str){
        for (int i = 0; i < this.str.length; i++) {
            if (this.str[i].equals(str)){
                return true;
            }
        }
        return false;
    }
    
    public void increaseSize(){
        String[] temp=new String[this.str.length+1];
        for (int i = 0; i < this.str.length; i++) {
            temp[i]=this.str[i];
        } 
        this.str=temp;
    }
    
    public void decreaseSize(){
        String[] temp=new String[this.str.length-1];
        for (int i = 0; i < this.str.length-1; i++) {
            temp[i]=this.str[i];
        }        
        this.str=temp;
    }
    
   public void delete(String str){
       if (this.contains(str)==true) {
           this.delete(this.getIndex(str));
       }       
   }
   
   public void delete(int index){
       this.str[index]=null;
       for (int i = index; i < this.str.length-1; i++) {
           this.str[i]=this.str[i+1];
       }
       objectCounter--;
       this.decreaseSize();       
   }
   
   public int getIndex(String str){
       for (int i = 0; i < this.str.length; i++) {
           if (this.str[i].equals(str)==true) {
               return i;
           }
       }
       return -1;
   }
   
   public String get(int index){
        return this.str[index];
   }
   
    public boolean isEmpty(){
        if(objectCounter==0){
            return true;
        }
        return false;
    }
    
    public int size(){
        return this.str.length;
    }
    
    public myArrayList subArrayList(int initialIndex,int finalIndex){
        myArrayList temp=new myArrayList();
        if (initialIndex>finalIndex) {
            for (int i = initialIndex; i >= finalIndex; i--) {
                temp.add(this.get(i));
            }            
        }
        else{
            for (int i = initialIndex; i <= finalIndex; i++) {
                //System.out.println(this.get(i));                
                temp.add(this.get(i));
            }
        }        
        return temp;        
    }
    
    public myArrayList extend(myArrayList temp){ 
    myArrayList temp1=new myArrayList();
        for (int i = 0; i < this.size(); i++) {
            temp1.add(this.get(i));
        }
        for (int i = 1; i < temp.size(); i++) {
            temp1.add(temp.get(i));
        }
        return temp1;
    }
    
    public myArrayList split(String str,String regex){
        myArrayList temp=new myArrayList();
        String[] str_arr=str.split(regex);
        for (int i = 0; i < str_arr.length; i++) {
            temp.add(str_arr[i]);
        }
        return temp;
    }
    
    public void set(int index,String str){
       this.str[index]=str;
    }
    
    public void sort(myArrayList temp){
        int count=0;
        while(count!=temp.size()-1){
            count=0;
            for (int i = 0; i < temp.size()-1; i++) {
                if ((temp.get(i).compareToIgnoreCase(temp.get(i+1)))>0) {
                    String temp_str=temp.get(i);
                    temp.set(i, temp.get(i+1));
                    temp.set(i+1, temp_str);
                    continue;
                }
                else{
                    count++;
                }
            }            
        }   
    }
}