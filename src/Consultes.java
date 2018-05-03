
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David Roig
 */

//"SELECT * "+
//"FROM vehicle "+
//"LEFT JOIN propietari "+
//"ON vehicle.dni_propietari = propietari.dni "+
//"WHERE matricula=?"
public class Consultes {
    
    private BaseDades BD;
    private PreparedStatement PS_infoVehicle;
    private PreparedStatement PS_entradesVehicle;
    
    public Consultes(BaseDades bd){
       preparaStatements(); 
    }
    
    private void preparaStatements(){
        
    }
    
    public ResultSet consultaInfoVehicle(String matricula) throws SQLException{
        PS_infoVehicle.setString(1, matricula);
        ResultSet rs = PS_infoVehicle.executeQuery();   
        return rs;
    }
}






        // Preparem les consultes a la base de dades.
        // Cada interrogant representa un valor que haurà de ser concretat
        // abans de l'execució.
//                PS_infoVehicle     = DB_connexio.prepareStatement (
//                        
//                );
//            PS_afegirEstudiants     = conn.DB_connexio.prepareStatement ("INSERT INTO estudiant (nom,dni,adreca) VALUES (?, ?, ?)");
//            PS_afegirProfessor     = conn.DB_connexio.prepareStatement ("INSERT INTO profesor (nom,departament) VALUES (?, ?)");
//            PS_assignarProfessor    = conn.DB_connexio.prepareStatement ("INSERT INTO curs (any,nom_assignatura,nom_professor) VALUES (?, ?, ?)");
//            PS_mostraEstudiants = conn.DB_connexio.prepareStatement ("SELECT * FROM estudiant");
//            PS_mostraAsignaturesProf = conn.DB_connexio.prepareStatement ("SELECT nom_assignatura FROM curs WHERE nom_professor=?");
//            PS_afegirAvaluacio = conn.DB_connexio.prepareStatement("INSERT INTO avaluacio (any,nota,dni_estudiant,nom_assignatura) VALUES (?, ?, ?, ?)");

//    
//    public void mostraEstudiants() throws SQLException{
//        ResultSet rs = PS_mostraEstudiants.executeQuery();
//        System.out.println();
//        System.out.println("---------------------------------------");
//        if (rs.next()) {
//            do {
//            System.out.println("Nom : "+rs.getString("nom")+", DNI : "+rs.getString("dni")+", Adreça : "+rs.getString("adreca"));
//            } while(rs.next());
//        } else {
//            System.out.println("No s'han trobat estudiants");
//        }
//        System.out.println("---------------------------------------");
//    }