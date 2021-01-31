/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Persistence.CurrenciesLoader;
import Persistence.ExchangeRateLoader;
import View.ApplicationView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author José Roberto Jiménez
 */
public class Model {
    private final CurrencyList c;
    private final ExchangeRateLoader er;
    private   List<ApplicationView> v;

    public Model(CurrenciesLoader c, ExchangeRateLoader er) {
        this.c = c.load();
        this.er = er;
        v=new ArrayList<>();
    }
    
    public Object[] currenciesList(){
        return c.currenciesList();
    }
    
    public void addView(ApplicationView v){
        this.v.add(v);
    }
    
    public void exchange(Money m, Currency to){
        m=new Money(m.getAmount()*er.load(m.getCurrency(), to).getRate(), to);
        for (ApplicationView view : v) {
            view.update(m);
        }
    }
    
    
}
