package modele;
import java.sql.*;
import javax.swing.JOptionPane;
public class Connexion {
    private static Connection con=null;
    private static Connexion c=null;
    private Connexion()
    {
        try {
            con=DriverManager.getConnection("jdbc:derby://localhost:1527/ecole");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
            
    }
    public static Connection getInstance()
    {
        if(c==null) c=new Connexion();
        return con;
    }
}
