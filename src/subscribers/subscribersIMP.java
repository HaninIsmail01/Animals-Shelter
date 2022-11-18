/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscribers;
import java.rmi.*;
import java.rmi.server.*;

/**
 *
 * @author hanin
 */
public class subscribersIMP extends UnicastRemoteObject implements subscribers {
    subscribersGUI s_UI; 
    String name;

    public subscribersIMP(String name) throws RemoteException {
        this.name = name;
          s_UI = new subscribersGUI();
        s_UI.setVisible(true);
        s_UI.setLabel(name);
        s_UI.getSubscriber(this);
      
    }
   public String getSubscriberName() throws RemoteException{
       return name;
   }

    public void receiveMsg(String msg,String namee) throws RemoteException {
        s_UI.addText(namee, msg);

    }

    public String getName() {
        return name;
    }
    

}