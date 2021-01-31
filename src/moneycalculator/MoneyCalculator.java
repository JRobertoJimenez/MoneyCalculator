/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator;


import Model.Model;
import Persistence.CurrenciesCSVLoader;
import Persistence.ExchangeRateWebLoader;
import View.ApplicationView;
import java.io.File;

/**
 *
 * @author José Roberto Jiménez
 */
public class MoneyCalculator {

    /**
     * @param args the command line arguments
     */
        private static final String fileNameCurrencies="Currencies.txt";
   private static final String urlRates="http://data.fixer.io/api/latest?access_key="
           + "5a2ceb13dfe99d0f5d74090fcd6d3b13"
           + "&base=@&symbols=@";
   
    public static void main(String[] args) {
        ApplicationController c= new ApplicationController(new Model(new CurrenciesCSVLoader(new File(fileNameCurrencies)),
            new ExchangeRateWebLoader(urlRates)));
        
        c.getModel().addView(new ApplicationView(c));
    }
    
}
