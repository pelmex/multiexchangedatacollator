/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xerxis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ZEUS
 */
public  class readwrite {
      

    public void readwrite(IOException In) {
        //File fw = new File("C:\\Users\\ZEUS\\Documents\\log.txt");
    
          
        try {
            
            FileReader fr = new FileReader("C:\\Users\\ZEUS\\Documents\\log.txt");
            BufferedReader br = new BufferedReader(fr);
            String datainfile = br.readLine();
            FileWriter gh = new FileWriter("C:\\Users\\ZEUS\\Documents\\log.txt");
            BufferedWriter bw = new BufferedWriter(gh);
                        
            
            
            bw.write(datainfile);
            //bw.newLine();
            bw.append(In.toString());
            bw.flush();            
            bw.close();
           
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(readwrite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(readwrite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    
    
}
