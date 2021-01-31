/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.Currency;
import Model.ExchangeRate;

/**
 *
 * @author José Roberto Jiménez
 */
public interface ExchangeRateLoader {
    public ExchangeRate load(Currency from, Currency to);
}
