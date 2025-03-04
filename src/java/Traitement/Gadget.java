package Traitement;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;



public class Gadget {
    
    public String Id ;
    public String Type ;
    public String Proprio ;
    Connexion co = new Connexion() ;
    
    public void ajouterGadget(){
        try{
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("INSERT INTO gadget(id,type,proprietaire) VALUES(?,?,?)") ;
            co.pst.setString(1,Id) ;
            co.pst.setString(2, Type) ;
            co.pst.setString(3, Proprio);
            co.pst.executeUpdate() ;
            co.con.close() ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
    }
    public void modifierGadget(){
        try{
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("UPDATE gadget SET type=?,proprietaire=? WHERE id=?") ;
            co.pst.setString(1, Type) ;
            co.pst.setString(2, Proprio) ;
            co.pst.setString(3, Id);
            co.pst.executeUpdate() ;
            co.con.close() ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
    }
    public void supprimerGadget(){
        try{
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("DELETE FROM gadget WHERE id=?") ;
            co.pst.setString(1,Id) ;
            co.pst.executeUpdate() ;
            co.con.close() ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
    }
    public Gadget rechercheGadget(){
        Gadget ga = new Gadget() ;
        try{
            co.Connect() ;
            co.st = (Statement)co.con.createStatement() ;
            co.rs = co.st.executeQuery("SELECT * FROM gadget") ;
            while(co.rs.next()){
                if(this.Id.equals(co.rs.getString("id"))){
                    ga.Id = co.rs.getString("id") ;
                    ga.Type = co.rs.getString("type") ;
                    ga.Proprio = co.rs.getString("proprietaire") ;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
        return ga ;
    }
    public ArrayList<Gadget> allGadget(){
        Gadget ga = new Gadget() ;
        ArrayList<Gadget> list = new ArrayList() ;
        try{
            co.Connect() ;
            co.st = (Statement)co.con.createStatement() ;
            co.rs = co.st.executeQuery("SELECT * FROM gadget") ;
            while(co.rs.next()){
                    ga.Id = co.rs.getString("id") ;
                    ga.Type = co.rs.getString("type") ;
                    ga.Proprio = co.rs.getString("proprietaire") ;
                    list.add(ga) ;
            }
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
        return list ;
    }
}
