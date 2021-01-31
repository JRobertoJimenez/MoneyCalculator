/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.Currency;
import Model.ExchangeRate;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Roberto Jiménez
 */
public class ExchangeRateWebLoader implements ExchangeRateLoader{
    private final String url;

    public ExchangeRateWebLoader(String url) {
        this.url = url;
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try {
            return new ExchangeRate(from, to, LocalDate.now(), read(from.getIsoCode(),to.getIsoCode()));
        } catch (IOException ex) {
            Logger.getLogger(ExchangeRateWebLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    private double read(String from, String to) throws MalformedURLException, IOException{
        if(from.equals(to))return 1;
        String [] lines =url.split("@");
        double f=1;
        double t=1;
        if(! from.equals("EUR")){
            String line =read(new URL(lines[0]+"EUR"+lines[1]+from));
            f= Double.parseDouble(
                line.substring(line.indexOf(from)+5,line.indexOf("}")));
        }
        
        if (! to.equals("EUR")) {
            String line =read(new URL(lines[0]+"EUR"+lines[1]+to));
            t=Double.parseDouble(
                line.substring(line.indexOf(to)+5,line.indexOf("}")));
        }
        
        
        
        return t/f;
    }

    private String read(URL url) throws IOException {
        InputStream is = url.openStream();
        byte[] buffer= new byte[1024];
        int len;
        String aux="";
        while ((len = is.read(buffer)) > 0) {
            aux+=new String (buffer,0,len);
        }
        return aux;
    }
    
    
}
