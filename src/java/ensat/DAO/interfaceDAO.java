/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensat.DAO;

import java.util.List;


public interface interfaceDAO <T> {
    boolean creer(T p);
    boolean update (T p);
    boolean delete (int code);
    T recuperer(int code);
    List<T> recuperer_All();
    
}
