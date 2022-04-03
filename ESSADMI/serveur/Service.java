package serveur;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import modele.*;
import entite.*;
public class Service extends Thread{
private Socket s;
private BufferedReader in;
private ObjectOutputStream out;
public Service(Socket s)
{
    this.s=s;
    try {
        in=new BufferedReader(new InputStreamReader(s.getInputStream()));
        out=new ObjectOutputStream(s.getOutputStream());
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
  }
@Override
public void run()
{ int c; String req;
   ArrayList<Filiere> tf;
   ArrayList<Etudiant> te;
    try {
        while(true)
        {
     c=Integer.parseInt(in.readLine());
     if(c==-1)
     {
         tf=new ArrayList();
         req="select * from filiere";
         PreparedStatement ps=Connexion.getInstance().prepareStatement(req);
         ResultSet res=ps.executeQuery();
         while(res.next()) tf.add(new Filiere(res.getInt(1),res.getString(2)));
         out.writeObject(tf);
         out.flush();
     }
     else if(c==0)
     {
        te=new ArrayList();
         req="select * from etudiant";
         PreparedStatement ps=Connexion.getInstance().prepareStatement(req);
         ResultSet res=ps.executeQuery();
         while(res.next()) te.add(new Etudiant(res.getInt(1),res.getString(2),res.getString(3)));
         out.writeObject(te);
         out.flush(); 
     }
     else
     {
         te=new ArrayList();
         req="select * from etudiant where codef=?";
         PreparedStatement ps=Connexion.getInstance().prepareStatement(req);
         ps.setInt(1, c);
         ResultSet res=ps.executeQuery();
         while(res.next()) te.add(new Etudiant(res.getInt(1),res.getString(2),res.getString(3)));
         out.writeObject(te);
         out.flush();
         
     }
     Thread.sleep(1);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,e.getMessage());
    }
}
}
