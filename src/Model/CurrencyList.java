/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author José Roberto Jiménez
 */
public class CurrencyList {
    private final Map<String,Currency> currencies;

    public CurrencyList() {
        this.currencies = new HashMap<>();
    }
    
    public void addCurrency(Currency currency){
        currencies.put(currency.getIsoCode(), currency);
    }
    
    public Object[] currenciesList(){
        return currencies.values().toArray();
    }
}
