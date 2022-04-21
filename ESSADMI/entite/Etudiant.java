package entite;

import java.io.*;
import junit.framework.*;

public class Etudiant implements Serializable {
    private int code;
    private String nom, prenom;

    public Etudiant(int code, String nom, String prenom) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

}
