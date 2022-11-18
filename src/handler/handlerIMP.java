/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;
import subscribers.subscribers;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
/**
 *
 * @author hanin
 */
public class handlerIMP extends UnicastRemoteObject implements handlerInterface {
    ArrayList<subscribers> hopeRescue = new ArrayList<subscribers>();
    ArrayList<subscribers> doggieHome = new ArrayList<subscribers>();
    ArrayList<subscribers> kittensPlace = new ArrayList<subscribers>();
    ArrayList<subscribers> subscribers = new ArrayList<subscribers>();
    static handlerGUI h_UI = new handlerGUI();

    public handlerIMP() throws RemoteException {
      
    }
    
     
    public void subscribe(subscribers s) throws RemoteException{
        subscribers.add(s);
        h_UI.setSubscribers(s.getSubscriberName() + " has joined!");
        System.out.println(subscribers.size());
    }
    
    public void unsubscribe(subscribers s) throws RemoteException{
        subscribers.remove(s);
         h_UI.setSubscribers(s.getSubscriberName() + " has left");
    }
    
    public void joinGroup(int num, subscribers s) throws RemoteException{
            if(s == null){
                System.out.println("error");
            }
            if(num== 1){
                hopeRescue.add(s);
                h_UI.setSubscribers(s.getSubscriberName() + " has joined Hope Rescue shelter");
                System.out.println("HR " + hopeRescue.size());
            }
            
            else if(num== 2){
                doggieHome.add(s);
                 h_UI.setSubscribers(s.getSubscriberName() + " has joined Doggie Home shelter");
                 System.out.println("DH "+ doggieHome.size() );
            }
            else if(num== 3){
                kittensPlace.add(s);
                 h_UI.setSubscribers(s.getSubscriberName() + " has joined Kitten's Place shelter");
                 System.out.println("KP "+ kittensPlace.size() );
            }
            
        
    }
    public void sendGroupMessage(String msg, subscribers s) throws RemoteException{
        if(hopeRescue.contains(s)){
            for(int i  =0 ; i <hopeRescue.size(); i++){
                hopeRescue.get(i).receiveMsg(msg,s.getSubscriberName());
            }
        }
        if(doggieHome.contains(s)){
            for(int i  =0 ; i <doggieHome.size(); i++){
                doggieHome.get(i).receiveMsg(msg,s.getSubscriberName());
            }
        }
        if(kittensPlace.contains(s)){
            for(int i  =0 ; i <kittensPlace.size(); i++){
                kittensPlace.get(i).receiveMsg(msg,s.getSubscriberName());
            }
        }
    }
    public void sendToAllGroups(String msg,subscribers s) throws RemoteException {
        for (int i = 0; i < subscribers.size(); i++) {
            subscribers.get(i).receiveMsg(msg,s.getSubscriberName());
        }
    }
}
