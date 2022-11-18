/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;
import subscribers.subscribers;
import java.rmi.*;
import java.rmi.RemoteException.*;

/**
 *
 * @author hanin
 */
public interface handlerInterface extends Remote {
    public void subscribe(subscribers s) throws RemoteException;
    public void unsubscribe(subscribers s) throws RemoteException;
    public void joinGroup(int num, subscribers s) throws RemoteException;
    public void sendGroupMessage(String msg, subscribers s) throws RemoteException;
    public void sendToAllGroups(String msg,subscribers s) throws RemoteException;
        
    
    
}
