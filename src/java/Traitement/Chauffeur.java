package Traitement;

import java.sql.PreparedStatement;
import java.sql.Statement;



public class Chauffeur {
    
    public String Id ;
    public String Password ;
    public String Nom ;
    public int Place ;
    Connexion co = new Connexion() ;
    
    public void ajouterChauffeur(){
        try{
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("INSERT INTO chauffeur(id,password,nom,place) VALUES(?,?,?,?)") ;
            co.pst.setString(1,Id) ;
            co.pst.setString(2, Password) ;
            co.pst.setString(3, Nom);
            co.pst.setString(4,Place+"") ;
            co.pst.executeUpdate() ;
            co.con.close() ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
    }
    public void modifierChauffeur(){
        try{
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("UPDATE chauffeur SET nom=?,place=? WHERE id=? AND password=?") ;
            co.pst.setString(1, Nom) ;
            co.pst.setString(2,Place+"") ;
            co.pst.setString(3, Id);
            co.pst.setString(4, Password);
            co.pst.executeUpdate() ;
            co.con.close() ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
    }
    public void supprimerChauffeur(){
        try{
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("DELETE FROM chauffeur WHERE id=? AND password=?") ;
            co.pst.setString(1,Id) ;
            co.pst.setString(2,Password) ;
            co.pst.executeUpdate() ;
            co.con.close() ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
    }
    public Chauffeur rechercheChauffeur(){
        Chauffeur ch = new Chauffeur() ;
        try{
            co.Connect() ;
            co.st = (Statement)co.con.createStatement() ;
            co.rs = co.st.executeQuery("SELECT * FROM chauffeur") ;
            while(co.rs.next()){
                if(this.Id.equals(co.rs.getString("id"))){
                    ch.Id = co.rs.getString("id") ;
                    ch.Nom = co.rs.getString("nom") ;
                    ch.Place = Integer.valueOf(co.rs.getString("place")) ;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
        return ch ;
    }
}
