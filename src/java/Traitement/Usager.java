package Traitement;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class Usager {
    public String Email ;
    public String Password ;
    public String Nom ;
    Connexion co = new Connexion() ;
    
    public void ajouterUsager(){
        try{
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("INSERT INTO usager(email,password,nom) VALUES(?,?,?)") ;
            co.pst.setString(1,Email) ;
            co.pst.setString(2, Password) ;
            co.pst.setString(3, Nom);
            co.pst.executeUpdate() ;
            co.con.close() ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
    }
    public void modifierUsager(){
        try{
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("UPDATE usager SET nom=? WHERE email=?") ;
            co.pst.setString(1, Nom) ;
            co.pst.setString(2, Email);
            co.pst.executeUpdate() ;
            co.con.close() ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
    }
    public void supprimerUsager(){
        try{
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("DELETE FROM usager WHERE email=?") ;
            co.pst.setString(1,Email) ;
            co.pst.executeUpdate() ;
            co.con.close() ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
    }
    public Usager rechercheUsager(){
        Usager us = new Usager() ;
        try{
            co.Connect() ;
            co.st = (Statement)co.con.createStatement() ;
            co.rs = co.st.executeQuery("SELECT * FROM usager") ;
            while(co.rs.next()){
                if(this.Email.equals(co.rs.getString("email"))){
                    us.Email = co.rs.getString("email") ;
                    us.Password = co.rs.getString("password") ;
                    us.Nom = co.rs.getString("nom") ;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
        return us ;
    }
    public ArrayList<Gadget> consulterGadget(){
        Gadget ga = new Gadget() ;
        ArrayList<Gadget> g = new ArrayList() ;
        try{
            co.Connect() ;
            co.st = (Statement)co.con.createStatement() ;
            co.rs = co.st.executeQuery("SELECT * FROM gadget WHERE proprietaire ="+Email) ;
            while(co.rs.next()){
                ga.Id = co.rs.getString("id") ;
                ga.Type = co.rs.getString("type") ;
                g.add(ga) ;
            }
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
        return g ;
    }
}
