/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
/**
 *
 * @author hanin
 */
public class handlermain {
    public static void main(String[] args) throws Exception {
        handlerIMP h = new handlerIMP();
        Registry r  = LocateRegistry.createRegistry(1099);
        r.rebind("subscribe",h);
        r.rebind("unsubscribe", h);
        r.rebind("join", h);
        r.rebind("sendGroup", h);
        r.rebind("sendAll",h);
        h.h_UI.setVisible(true);
        System.out.println("Handler Running");
        
    }
    
}
