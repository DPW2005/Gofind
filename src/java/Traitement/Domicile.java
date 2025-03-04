package Traitement;

import java.sql.PreparedStatement ;
import java.sql.Statement ;
import java.util.ArrayList ;

public class Domicile {
    
    public String Id ;
    public String Localite ;
    public String Prix ;
    public String Type ;
    public String Proprio ;
    Connexion co = new Connexion() ;
    
    public void ajouterDomicile(){
        try{
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("INSERT INTO domicile(id,localite,prix,type,proprio) VALUES(?,?,?,?,?)") ;
            co.pst.setString(1,Id) ;
            co.pst.setString(2, Localite) ;
            co.pst.setString(3, Prix) ;
            co.pst.setString(4,Type) ;
            co.pst.setString(5, Proprio) ;
            co.pst.executeUpdate() ;
            co.con.close() ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
    }
    public void modifierDomicile(){
        try{
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("UPDATE domicile SET localite=?,prix=?,type=?,proprio=? WHERE id=?") ;
            co.pst.setString(5,Id) ;
            co.pst.setString(1, Localite) ;
            co.pst.setString(2, Prix) ;
            co.pst.setString(3,Type) ;
            co.pst.setString(4, Proprio) ;
            co.pst.executeUpdate() ;
            co.con.close() ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
    }
    public void supprimerDomicile(){
        try{
            co.Connect() ;
            co.pst = (PreparedStatement)co.con.prepareStatement("DELETE FROM domicile WHERE id=?") ;
            co.pst.setString(1,Id) ;
            co.pst.executeUpdate() ;
            co.con.close() ;
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
    }
    public ArrayList<Domicile> rechercherDomicile(String par){
        Domicile dom = new Domicile() ;
        ArrayList<Domicile> d = new ArrayList() ;
        try{
            co.Connect() ;
            co.st = (Statement)co.con.createStatement() ;
            co.rs = co.st.executeQuery("SELECT * FROM domicile") ;
            if(par.toUpperCase().equals("LOCALITE")){
                while(co.rs.next()){
                    if(Localite.equals(co.rs.getString("localite"))){
                        dom.Id = co.rs.getString("id") ;
                        dom.Localite = co.rs.getString("localite") ;
                        dom.Prix = co.rs.getString("prix") ;
                        dom.Type = co.rs.getString("type") ;
                        dom.Proprio = co.rs.getString("proprio") ;
                        d.add(dom) ;
                    }
                }
            }
            else if(par.toUpperCase().equals("PRIX")){
                while(co.rs.next()){
                    if(Prix.equals(co.rs.getString("prix"))){
                        dom.Id = co.rs.getString("id") ;
                        dom.Localite = co.rs.getString("localite") ;
                        dom.Prix = co.rs.getString("prix") ;
                        dom.Type = co.rs.getString("type") ;
                        dom.Proprio = co.rs.getString("proprio") ;
                        d.add(dom) ;
                    }
                }
            }
            else if(par.toUpperCase().equals("TYPE")){
                while(co.rs.next()){
                    if(Type.equals(co.rs.getString("type"))){
                        dom.Id = co.rs.getString("id") ;
                        dom.Localite = co.rs.getString("localite") ;
                        dom.Prix = co.rs.getString("prix") ;
                        dom.Type = co.rs.getString("type") ;
                        dom.Proprio = co.rs.getString("proprio") ;
                        d.add(dom) ;
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
        return d ;
    }
    public ArrayList<Domicile> allDomicile(){
        Domicile dom = new Domicile() ;
        ArrayList<Domicile> list = new ArrayList() ;
        try{
            co.Connect() ;
            co.st = (Statement)co.con.createStatement() ;
            co.rs = co.st.executeQuery("SELECT * FROM domicile") ;
            while(co.rs.next()){
                    dom.Localite = co.rs.getString("localite") ;
                    dom.Type = co.rs.getString("type") ;
                    dom.Proprio = co.rs.getString("proprio") ;
                    list.add(dom) ;
            }
        }
        catch(Exception e){
            e.printStackTrace() ;
            System.out.println(e.getMessage()) ;
        }
        return list ;
    }
}
