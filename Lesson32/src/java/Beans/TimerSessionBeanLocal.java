/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.ejb.Local;

/**
 *
 * @author zhumagulov_r
 */
@Local
public interface TimerSessionBeanLocal {

    void getQuotes(String symbol);
    
}
