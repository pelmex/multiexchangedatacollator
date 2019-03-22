/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xerxis;

import Frames.UIX;
import pannels.UserInt;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 *
 * @author ZEUS
 */
public class Xerxis {
    public static String currentprice = null;
    String VAL; 
    public static List <String> price = new ArrayList<>();
    public static List <String> volume = new ArrayList<>() ;
    public static List <String> price1 = new ArrayList<>();
    public static List <String> biding1 = new ArrayList<>();
    public static List <String> biding = new ArrayList<>();
    public static List <String> bidingvolume1 = new ArrayList<>() ;
    public static List <String> bidingvolume = new ArrayList<>() ;
    public static List <String> volume1 = new ArrayList<>() ;
    public static JSONArray kl =  null;
    public static JSONArray kz =  null;
    String[] args = null;
    static List<JSONObject> jk ;
    
    
    
    
    
    
    Xerxis(){
    price = null;
    volume = null;
    
     
    }
    
    public static boolean timer(){try {
        Thread.sleep(15000);

        } catch (InterruptedException ex) {
            Logger.getLogger(Xerxis.class.getName()).log(Level.SEVERE, null, ex);
        }
            return true;}
    
    public static void seterrordisplay(String in){
        
        //UserInt.addtoverticalpane(in);
        
    }
    
    public static void binancedejsonify(String val){
        // String val used to be INt val this section was created to test the stringed combo selector program
        //price = null;
        apiclient hh = new apiclient(); 
        
        price1 = new ArrayList<>();
        jk = hh.exchangeselector("binance", val);
        volume1 = new ArrayList<>();
        bidingvolume1 =new ArrayList<>();
        biding1=new ArrayList<>();
        try {kl = (JSONArray) jk.get(0).get("asks");
        kz = (JSONArray) jk.get(0).get("bids");} 
            catch (NullPointerException e){seterrordisplay("having null issues at binance "
                    + "dejsonifying level 1 getting empty result from "
                    + "webpage, check connectivity please");}
        try {UserInt.high = (String) jk.get(1).get("highPrice");
        UserInt.low = (String) jk.get(1).get("lowPrice");
        UserInt.price =(String) jk.get(1).get("lastPrice"); 
        }catch(NullPointerException e){seterrordisplay("having null issues at binance "
         + "dejsonifying level 2 getting empty result from webpage, check connectivity please");}
        for(int i = 0;i<6;i++){System.out.println(i);
        try {List kk = (List) kl.get(i);
        List ky = (List) kz.get(i);
        String km = (String) kk.get(0);
        String kw = (String) ky.get(0);
        Xerxis.price1.add(kw);
        Xerxis.biding1.add(km);
        Xerxis.bidingvolume1.add((String) kk.get(1));
        Xerxis.volume1.add((String) ky.get(1));

        }catch (NullPointerException e){
            seterrordisplay("having null issues at binance dejsonifying level 3"
                    + " getting empty result from webpage, check connectivity please");}}
        price = price1;
        volume = volume1;
        biding = biding1;
        bidingvolume = bidingvolume1;

                
        
        

}
    
    public static void bitfinexdejsonify(String val){
        // String val used to be INt val this section was created to test the stringed combo selector program
    //UserInt.timerrunning = false;
    apiclient bit = new apiclient();
    List<JSONObject> boom = bit.exchangeselector("bitfinex", val);
    List<JSONArray> got = bit.jk;
   try{UserInt.price = boom.get(1).get("last_price").toString();
   UserInt.high = boom.get(1).get("high").toString();
   UserInt.low = boom.get(1).get("low").toString();
   }catch(NullPointerException e){seterrordisplay("having null issues at bitfinex"
    + " dejsonifying level getting empty result from webpage, check connectivity please");}
   



}
   
   
     private void cull(){
         
        dbase get = new dbase();
        ResultSet vv = get.connectmsftsql("select * from tokens");
        System.out.println(vv);
        dbase get1 = new dbase();
        ResultSet v = get1.connectsqlite("select * from token");
        
        try {
            ResultSetMetaData bb = v.getMetaData();// this gets all the datas of the table and stores it
            System.out.println(bb.getColumnName(2));// this prints out the colun name of column 2
            System.out.println(bb.getColumnCount());// this counts the number of available columns in the table
            while (v.next()){System.out.println(v.getString(2) + v.getString("uid"));}// we can identify the data to be printed either by the column names or by the column numbers
            
        } catch (SQLException ex) {
            Logger.getLogger(Xerxis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public static void exchangecall(){
       
        String cons;// change back to int if we want to use index number from combo selector
        //cons = UserInt.comboselected;
        cons = UserInt.comboset;
        System.out.println(cons+UserInt.VS);
        String exchange = UserInt.activeexchange;
        if (exchange.equals("bitfinex")){bitfinexdejsonify(cons);}
        if (exchange.equals("binance")){binancedejsonify(cons);}
        if (exchange.equals("tidex")){seterrordisplay("now pooling data from tidex");}
        //switch (exchange){
          //  case "bitfinex":
            //    bitfinexdejsonify(cons);
              //  seterrordisplay("now pooling data from bitfinex");
       //     case "binance":
         //       binancedejsonify(cons);
           //     seterrordisplay("now pooling data from binance");
           // case "tidex":
             //   seterrordisplay("now pooling data from tidex");
            //default :
              //  bitfinexdejsonify(cons);
        
       // }
}
     public static void main(String[] args) {
         
        UIX.main(args);
        //UserInt o = new UserInt();
        while(true){
            try {
                
                //bitfinexdejsonify(1);
                
                exchangecall();
                Thread.sleep(1000);
                
                
                //try{
                //binancedejsonify(2);
                //UserInt.ask=Xerxis.price ;
                //UserInt.askvolume = Xerxis.volume;
                //price = new ArrayList<>();
                //volume = new ArrayList<>();}
                //catch(NullPointerException e){System.out.println("having null issues");}
            } catch (InterruptedException ex) {
                Logger.getLogger(Xerxis.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
           
}
        
             
}
}