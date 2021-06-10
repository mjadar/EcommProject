/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensat.DAO;

import ensat.Entity.Produits;
import java.util.List;


public interface interfaceDAO {
    boolean creer(Produits p);
    boolean update (Produits p);
    boolean delete (int code);
    Produits recuperer(int code);
    List<Produits> recuperer_All();
    
}
