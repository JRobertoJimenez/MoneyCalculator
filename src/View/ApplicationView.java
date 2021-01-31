/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Money;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import moneycalculator.Controller;

/**
 *
 * @author José Roberto Jiménez
 */
public class ApplicationView extends JFrame implements View{
    
    private final Controller con;
    private final JLabel text;

    public ApplicationView(Controller con) throws HeadlessException {
        this.setTitle("MoneyCalculator");
        this.con=con;
        text=new JLabel();
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setSize(300,
                150);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        this.getContentPane().add(dialogFrom(), BorderLayout.NORTH);
        this.getContentPane().add(dialogTo(), BorderLayout.CENTER);
        this.getContentPane().add(dialogExchange(), BorderLayout.SOUTH);
        this.setVisible(true);
    }

    private JPanel dialogFrom() {
        JPanel panel=new JPanel();
        panel.add(con.comboFrom(),BorderLayout.WEST);
        JTextArea t=con.textAmount();
        panel.add(t,BorderLayout.EAST);
        panel.setSize(this.getWidth(), this.getHeight()/3);
        
        
        return panel;
    }

    private JPanel dialogTo() {
        JPanel panel=new JPanel();
        panel.add(con.comboTo(),BorderLayout.WEST);
        panel.add(createButton(), BorderLayout.EAST);
        panel.setSize(this.getWidth(), this.getHeight()/3);
        return panel;
    }

    private JPanel dialogExchange() {
        JPanel panel=new JPanel();
        panel.add(text);
        panel.setSize(this.getWidth(), this.getHeight()/3);
        return panel;
    }

    private JButton createButton() {
        JButton b=new JButton();
        b.setText("Calcular");
        b.addActionListener(con.buttonCalcular());
        return b;
    }
    
    public void update(Money text){
        this.text.setText(text.toString());
    }
    
}
