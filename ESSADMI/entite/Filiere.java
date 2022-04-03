package entite;
import java.io.Serializable;
public class Filiere implements Serializable{
  private int codef;
  private String nomf;

    public Filiere(int codef, String nomf) {
        this.codef = codef;
        this.nomf = nomf;
    }

    public int getCodef() {
        return codef;
    }

    public String getNomf() {
        return nomf;
    }
  
}
