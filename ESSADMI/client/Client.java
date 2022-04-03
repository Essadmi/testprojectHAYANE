package client;
import entite.*;
import java.io.IOException;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Client {
private Socket s;
private ObjectInputStream in;
private PrintWriter out;
    public Client(String IP,int port) {
    try {
        s=new Socket(IP,port);
        in=new ObjectInputStream(s.getInputStream());
        out=new PrintWriter(s.getOutputStream(),true);
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
                
    }
public ArrayList<Etudiant> getAllEtds()
{
    try {
        out.println(0);
        return (ArrayList<Etudiant>)in.readObject();
    } catch (Exception e) {
        return null;
    }
}    
public ArrayList<Filiere> getFilieres()
{
    try {
        out.println(-1);
        return (ArrayList<Filiere>)in.readObject();
    } catch (Exception e) {
        return null;
    }
}
public ArrayList<Etudiant> getEtudiants(int cf)
{
    try {
        out.println(cf);
        return (ArrayList<Etudiant>)in.readObject();
    } catch (Exception e) {
        return null;
    }
}
    
    
}
