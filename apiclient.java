/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xerxis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pannels.UserInt;


        

/**
 *
 * @author ZEUS
 */
public  class apiclient {
    List<String> ur = new LinkedList<>();
    List<JSONObject> rout = new LinkedList<>();
    readwrite gh = new readwrite();
    Dictionary dict;
    JSONParser hh = new JSONParser();
    JSONObject kk = null;
    JSONArray jk = null;
    JSONArray jj = null;

    /**
     *
     */
    public String[] comboselector = null;
    
    
   
    
    String urllink = null;
    URL url;

    public apiclient() {
        //this.comboselector = new String[]{"m","g","z","n"};
        
        
    }
   
    /**
     *
     * @param in
     * @return
     */
    public  JSONObject apiclient1(String in) {
        
        Date now = new Date();

            
                urllink = (String) in;
                try {
                    apiclient.this.url = new URL(urllink);
                }catch (MalformedURLException ex) {
                    Logger.getLogger(apiclient.class.getName()).log(Level.SEVERE, null, ex);
                }  try {
                    HttpsURLConnection hp = (HttpsURLConnection)url.openConnection();
                    hp.setRequestMethod("GET");
                    int Status = hp.getResponseCode();
                    System.out.println(Status);
                    if (Status == 200){
                        InputStream val = hp.getInputStream();
                        System.out.println("a");
                        InputStreamReader val1 = new InputStreamReader(val);
                        System.out.println("b");
                        try (BufferedReader bb = new BufferedReader(val1)) {
                            System.out.println("c");
                            String ss =(bb.readLine());
                            System.out.println("d"+ss);
                            //jj = (JSONArray) hh.parse(ss);
                            //List <Object> dd = (List <Object>) jj.get(0);
                            //System.out.println(dd.get(0));
                            
                            try {kk = (JSONObject)hh.parse(ss);
                            System.out.println(kk);
                            //if (kk == null){
                            //jj = (JSONArray) hh.parse(ss);
                            //List <Object> dd = (List <Object>) jj.get(0);
                            //System.out.println(dd.get(0));
                            //System.out.println(kk);}
                            
                            }
                            catch(ClassCastException e){jk = (JSONArray)hh.parse(ss);
                            
                            UserInt.bitfinexask = (JSONArray)hh.parse(ss);
                            
                            
                            
                            }
                            
                            return kk;
                        }
                        
                    }
                    else{System.out.println("Having Connectivity Issues");}
                } catch (IOException ex) {IOException f = ex;
                gh.readwrite(f);
                System.out.println("Having Connectivity issues");
                }  catch (ParseException ex) {
                    Logger.getLogger(apiclient.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        
     return kk;    
    }
        
    /**
     *
     * @param v
     * @param x
     * @return 
     */
    public List<JSONObject> exchangeselector(String v,String x) {
        List<JSONObject> hud;
        List<JSONObject> huds;
        List<JSONObject> hudf;
        
       // hud = new ArrayList<>();
        //huds = new ArrayList<>();
        //hudf = new ArrayList<>();
        
        switch (v){
            case "bitfinex":
                //setcomboselectorbitfinex();
                hud = bitfinexselectormod(x);             
                
                System.out.println(1);
                return hud;
            case "tidex":
                //setcomboselectortidex();
                //huds = tidexselector(x);
                //System.out.println(2);
                //return huds;
            case "binance":
                //setcomboselectorbinance();
                hudf = binanceselectormod(x);
                System.out.println(3);
                return hudf;
            default:
               // setcomboselectorbitfinex();
                hudf = bitfinexselectormod(x);
                System.out.println("default");
                return hudf;
        }
        
}
    
    
    public List<JSONObject> bitfinexselectormod(String x){
    String traded = UserInt.VS;
    List<JSONObject> var = new ArrayList<>();
        System.out.println(String.format("https://api.bitfinex.com/v2/book/t%s%s/P0",x.toUpperCase(),traded.toUpperCase()));
        var.add(apiclient1(String.format("https://api.bitfinex.com/v2/book/t%s%s/P0",x.toUpperCase(),traded.toUpperCase())));
        var.add(apiclient1(String.format("https://api.bitfinex.com/v1/pubticker/%s%s",x.toLowerCase(),traded.toLowerCase())));
        return var; 
    }
    public List<JSONObject> binanceselectormod(String x){
    List<JSONObject> var;
    var = new ArrayList<>();
    String traded = UserInt.VS;
        var.add(apiclient1(String.format("https://api.binance.com/api/v1/depth?symbol=%s%s&limit=10",x.toUpperCase(),traded.toUpperCase())));
        var.add(apiclient1(String.format("https://api.binance.com/api/v1/ticker/24hr?symbol=%s%s",x.toUpperCase(),traded.toUpperCase())));
        return var; 
    }
    
    public List<JSONObject> bitfinexselector(int x){
    List<JSONObject> var = new ArrayList<>();
    
    switch (x){
        case 0:
            var.add(apiclient1("https://api.bitfinex.com/v2/book/tETHUSD/P0"));
            var.add(apiclient1("https://api.bitfinex.com/v1/pubticker/ethusd"));
            return var; 
            
        case 1:
            var.add(apiclient1("https://api.bitfinex.com/v2/book/tXRPUSD/P0"));
            var.add(apiclient1("https://api.bitfinex.com/v1/pubticker/xrpusd"));
            return var; 
        case 2:
            var.add(apiclient1("https://api.bitfinex.com/v2/book/tXVGUSD/P0"));
            var.add(apiclient1("https://api.bitfinex.com/v1/pubticker/xvgusd"));
            return var; 
        case 3:
            var.add(apiclient1("https://api.bitfinex.com/v2/book/tTRXUSD/P0"));            
            var.add(apiclient1("https://api.bitfinex.com/v1/pubticker/trxusd"));
            return var; 
        case 4:            
            var.add(apiclient1("https://api.bitfinex.com/v2/book/tYYWUSD/P0"));
            var.add(apiclient1("https://api.bitfinex.com/v1/pubticker/yywusd"));
            return var; 
        default:            
            var.add(apiclient1("https://api.bitfinex.com/v2/book/tBTCUSD/P0"));
            var.add(apiclient1("https://api.bitfinex.com/v1/pubticker/btcusd"));
            return var; 
    }
        
}
    public List<JSONObject> tidexselector(int x){
    List<JSONObject> var;
    var = new ArrayList<>();
    //var = null;
    switch (x){
        case 0:
            var.add(apiclient1("https://api.binance.com/api/v1/depth?symbol=ADAETH&limit=10"));
            var.add(apiclient1("https://api.tidex.com/api/3/ticker/stq_eth")); 
            return var; 
        case 1:
            var.add(apiclient1("https://api.binance.com/api/v1/depth?symbol=ADAETH&limit=10"));
            var.add(apiclient1("https://api.tidex.com/api/3/ticker/hav_eth"));
            return var; 
        default:
            var.add(apiclient1("https://api.binance.com/api/v1/depth?symbol=ADAETH&limit=10"));
            var.add(apiclient1("https://api.tidex.com/api/3/ticker/hav_eth"));
            return var; 
    }
         
}
    
    public List<JSONObject> binanceselector(int x){
    List<JSONObject> var;
    var = new ArrayList<>();
    switch (x){
        case 0:
            var.add(apiclient1("https://api.binance.com/api/v1/depth?symbol=XVGETH&limit=10"));
            var.add(apiclient1("https://api.binance.com/api/v1/ticker/24hr?symbol=XVGETH"));
            System.out.println(1);
            return var; 
        case 1:
            var.add(apiclient1("https://api.binance.com/api/v1/depth?symbol=ADAETH&limit=10"));
            var.add(apiclient1("https://api.binance.com/api/v1/ticker/24hr?symbol=ADAETH"));
            System.out.println(2);
            return var; 
        case 2:
            var.add(apiclient1("https://api.binance.com/api/v1/depth?symbol=POEETH&limit=10"));
            var.add(apiclient1("https://api.binance.com/api/v1/ticker/24hr?symbol=POEETH"));
            System.out.println(3);
            return var; 
        case 3:
            var.add(apiclient1("https://api.binance.com/api/v1/depth?symbol=CNDETH&limit=10"));
            var.add(apiclient1("https://api.binance.com/api/v1/ticker/24hr?symbol=CNDETH"));
            System.out.println(4);
            return var; 
        case 4:
            var.add(apiclient1("https://api.binance.com/api/v1/depth?symbol=NCASHETH&limit=10"));
            var.add(apiclient1("https://api.binance.com/api/v1/ticker/24hr?symbol=NCASHETH"));
            System.out.println(5);
            return var; 
        default:
            var.add(apiclient1("https://api.binance.com/api/v1/depth?symbol=BTCETH&limit=10"));
            var.add(apiclient1("https://api.binance.com/api/v1/ticker/24hr?symbol=BTCETH"));
            System.out.println("default");
            return var; 
    }
       
}

    //private void setcomboselectorbitfinex() {
      //  this.comboselector = new String[]{"ETH/USD","XRP/USD","XVG/USD","TRX/USD"};
        //To change body of generated methods, choose Tools | Templates.
    //}

    //private void setcomboselectortidex() {
      //  this.comboselector = new String[]{"STQ/ETH","HAV/ETH"};
        
    //}

    //private void setcomboselectorbinance() {
      //      this.comboselector = new String[]{"XVG/ETH","ADA/ETH","POE/ETH","CND/ETH","NCASH/ETH","BTC/ETH"};
    //}

   

}
