/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.Currency;
import Model.CurrencyList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author José Roberto Jiménez
 */
public class CurrenciesCSVLoader implements CurrenciesLoader{
    private final File file;

    public CurrenciesCSVLoader(File file) {
        this.file = file;
    }

    @Override
    public CurrencyList load() {
        CurrencyList currencyList =new CurrencyList();
        try {
            BufferedReader br= new BufferedReader(new FileReader(file));
            String [] data;
            String line=br.readLine();
            while(line !=null){
                data=line.split(",");
                currencyList.addCurrency(new Currency(data[0], data[1],  data[2].toCharArray()[0]));
                line=br.readLine();
            }
        } catch (Exception e) {
            System.out.println("Se ha producido una excepcion: "+e.getMessage());
        }
        return currencyList;
    }
    
    
}
