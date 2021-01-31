/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator;

import Model.Currency;
import Model.CurrencyList;
import Model.Model;
import Model.Money;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

/**
 *
 * @author José Roberto Jiménez
 */
public class ApplicationController implements Controller{
    private  JComboBox from;
    private  JComboBox to;
    private  JTextArea amount;
    
    private final  Model m;

    public ApplicationController(Model m) {
        this.m = m;
    }
            
    
    
    @Override
    public ActionListener calcular(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!amount.getText().isEmpty()&&from.getSelectedItem()!=to.getSelectedItem()){
                m.exchange(new Money(Double.parseDouble(amount.getText()),(Currency) from.getSelectedItem()),
                        (Currency) to.getSelectedItem());
                }
            }
        };
    }
    
    @Override
    public JComboBox from() {
        from=new JComboBox(m.currenciesList());
        return from;
    }
    
    @Override
    public JTextArea amount() {
        amount=new JTextArea(1, 5);
        amount.setEditable(true);
        return amount;
    }

    @Override
    public JComboBox to() {
        to= new JComboBox<>(m.currenciesList());
        return to;
    }
    
    public void setModel(CurrencyList model){
        
    }

    Model getModel() {
        return m;
    }
   
}
