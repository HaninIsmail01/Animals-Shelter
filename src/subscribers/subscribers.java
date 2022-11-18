/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscribers;
import java.rmi.*;
import java.rmi.Remote.*;


/**
 *
 * @author hanin
 */
public interface subscribers extends Remote{
    public void receiveMsg(String msg, String name) throws RemoteException;
    public String getSubscriberName() throws RemoteException;
    
}
