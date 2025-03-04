package Traitement;

import java.util.Map;
import java.sql.PreparedStatement ;
import java.sql.Statement ;
import java.util.ArrayList;

public class Trajet {
    
    public String Id ;
    public String Depart ;
    public String Arrivee ;
    public static int nbre = 1 ;
    Connexion co = new Connexion() ;
    
    public void ajouterTrajet(){
        try{
            Id = nbre+"" ;
            nbre++ ;
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("INSERT INTO trajet(id,depart,arrivee) VALUES(?,?,?)") ;
            co.pst.setString(1,Id) ;
            co.pst.setString(2, Depart) ;
            co.pst.setString(3, Arrivee) ;
            co.pst.executeUpdate() ;
            co.con.close() ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
    }
    public void modifierTrajet(){
        try{
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("UDDATE trajet SET depart=?,arrivee=? WHERE id=?") ;
            co.pst.setString(3,Id) ;
            co.pst.setString(1, Depart) ;
            co.pst.setString(2, Arrivee) ;
            co.pst.executeUpdate() ;
            co.con.close() ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
    }
    public void supprimerTrajet(){
        try{
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("DELETE * FROM trajet WHERE id=?") ;
            co.pst.setString(1,Id) ;
            co.pst.executeUpdate() ;
            co.con.close() ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
    }
    public ArrayList<Trajet> rechercherTrajet(String par){
        Trajet tr = new Trajet() ;
        ArrayList<Trajet> t = new ArrayList() ;
        try{
            co.Connect() ;
            co.st = (Statement)co.con.createStatement() ;
            co.rs = co.st.executeQuery("SELECT * FROM trajet") ;
            if(par.toUpperCase().equals("DEPART")){
                while(co.rs.next()){
                    if(Depart.equals(co.rs.getString("depart"))){
                        tr.Id = co.rs.getString("id") ;
                        tr.Depart = co.rs.getString("depart") ;
                        tr.Arrivee = co.rs.getString("arrivee") ;
                        t.add(tr) ;
                    }
                }
            }
            else if(par.toUpperCase().equals("ARRIVEE")){
                while(co.rs.next()){
                    if(Arrivee.equals(co.rs.getString("arrivee"))){
                        tr.Id = co.rs.getString("id") ;
                        tr.Depart = co.rs.getString("depart") ;
                        tr.Arrivee = co.rs.getString("arrivee") ;
                        t.add(tr) ;
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
        return t ;
    }
    public ArrayList<Trajet> allTrajet(){
        Trajet tr = new Trajet() ;
        ArrayList<Trajet> list = new ArrayList() ;
        try{
            co.Connect() ;
            co.st = (Statement)co.con.createStatement() ;
            co.rs = co.st.executeQuery("SELECT * FROM trajet") ;
            while(co.rs.next()){
                    tr.Id = co.rs.getString("id") ;
                    tr.Depart = co.rs.getString("depart") ;
                    tr.Arrivee = co.rs.getString("arrivee") ;
                    list.add(tr) ;
            }
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
        return list ;
    }
}