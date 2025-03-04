package Traitement ;

import java.sql.PreparedStatement ;
import java.sql.Statement ;
import java.util.ArrayList ;

public class Bailleur {
    
    public String Id ;
    private String Password ;
    public String Nom ;
    Connexion co = new Connexion() ;
    
    public void ajouterBailleur(){
        try{
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("INSERT INTO bailleur(id,password,nom) VALUES(?,?,?)") ;
            co.pst.setString(1,Id) ;
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
    public void modifierBailleur(){
        try{
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("UDDATE bailleur SET nom=? WHERE id=?") ;
            co.pst.setString(1, Nom) ;
            co.pst.setString(2, Id);
            co.pst.executeUpdate() ;
            co.con.close() ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
    }
    public void supprimerBailleur(){
        try{
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("DELETE * FROM bailleur WHERE id=?") ;
            co.pst.setString(1,Id) ;
            co.pst.executeUpdate() ;
            co.con.close() ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
    }
    public Bailleur rechercheBailleur(){
        Bailleur ba = new Bailleur() ;
        try{
            co.Connect() ;
            co.st = (Statement)co.con.createStatement() ;
            co.rs = co.st.executeQuery("SELECT id,nom FROM bailleur WHERE id="+Id) ;
            ba.Id = co.rs.getString("id") ;
            ba.Nom = co.rs.getString("nom") ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
        return ba ;
    }
    public ArrayList<Domicile> conculterDomicile(){
        Domicile dom = new Domicile() ;
        ArrayList<Domicile> d = new ArrayList() ;
        try{
            co.Connect() ;
            co.st = (Statement)co.con.createStatement() ;
            co.rs = co.st.executeQuery("SELECT * FROM domicile WHERE proprio ="+Id) ;
            while(co.rs.next()){
                dom.Id = co.rs.getString("id") ;
                dom.Localite = co.rs.getString("localite") ;
                dom.Prix = co.rs.getString("prix") ;
                dom.Type = co.rs.getString("type") ;
                d.add(dom) ;
            }
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
        return d ;
    }
}
