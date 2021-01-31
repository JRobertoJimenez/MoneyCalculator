/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author José Roberto Jiménez
 */

public class Currency {
    private final String isoCode;
    private final String name;
    private final char  symbol;

    public Currency(String isoCode, String name, char symbol) {
        this.isoCode = isoCode;
        this.name = name;
        this.symbol = symbol;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return isoCode+", "+symbol;
    }
    
    
    
    
}
