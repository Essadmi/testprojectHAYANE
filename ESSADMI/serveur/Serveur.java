package serveur;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Serveur {
private ServerSocket sv;
private int port;

    public Serveur(int port) {
        this.port = port;
    try {
        sv=new ServerSocket(port);
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
    }
public void debut()
{
       try {
           while(true)
    {
            new Service(sv.accept()).start();
         }

        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
}
public static void main(String[] args) {
     new Serveur(4000).debut();
    }
}
