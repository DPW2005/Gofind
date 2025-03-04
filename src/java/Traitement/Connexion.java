package Traitement;

import java.sql.DriverManager ;
import java.sql.Connection ;
import java.sql.ResultSet ;
import java.sql.Statement ;
import java.sql.PreparedStatement ;

public class Connexion {
    public Connection con ;
    public ResultSet rs ;
    public PreparedStatement pst ;
    public Statement st ;
    
    public void Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            con = DriverManager.getConnection("jdbc:mysql://localhost/gofind","root","") ;
            System.out.println("Connexion reussie") ;
        }
        catch(Exception e){
            e.printStackTrace() ;
        }
    }
    
}
