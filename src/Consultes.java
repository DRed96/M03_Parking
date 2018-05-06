
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David Roig
 */

public class Consultes {
    
    private final BaseDades DB;
    private PreparedStatement PS_diferenciaDates;
    private PreparedStatement PS_infoVehicle;
    private PreparedStatement PS_entradesVehicle;
    private PreparedStatement PS_infoPropietaris;
    private PreparedStatement PS_entradesPropietaris;
    
    public Consultes(BaseDades _DB)throws SQLException{
        DB = _DB;
        preparaEnunciats();
    }
    
    private void preparaEnunciats()throws SQLException{
        PS_diferenciaDates = DB.preparaEnunciat("SELECT DATEDIFF(?, ?)");
        
        PS_infoVehicle = DB.preparaEnunciat("SELECT * FROM vehicle "
                                            + "LEFT JOIN propietari "
                                            + "ON vehicle.dni_propietari = propietari.dni "
                                            + "WHERE matricula = ?");

        PS_entradesVehicle =  DB.preparaEnunciat("SELECT e.id,e.data_entrada,e.data_sortida,e.planta,e.plaça,m.id, m.descripcio "
                                                + "FROM entrada e "
                                                + "LEFT JOIN motiu_sortida m "
                                                + "ON m.id = e.motiu "
                                                + "WHERE matricula = ?");

        PS_entradesPropietaris =  DB.preparaEnunciat("SELECT e.id,e.data_entrada,e.data_sortida,e.planta,e.plaça, e.matricula,m.id, m.descripcio, v.marca, v.model "
                                                    + "FROM entrada e "
                                                    + "LEFT JOIN motiu_sortida m "
                                                    + "ON m.id = e.motiu "
                                                    + "LEFT JOIN vehicle v "
                                                    + "ON v.dni_propietari = ? "
                                                    + "WHERE e.dni_propietario = ?");
        
        
    }
    
    public boolean consultaInfoVehicle(String matricula) throws SQLException{
        PS_infoVehicle.setString(1, matricula);
        ResultSet rs = PS_infoVehicle.executeQuery();   
        if(rs.next()){
            System.out.println(
                    rs.getString("matricula") + " - " +
                    rs.getString("marca") + ", " +
                    rs.getString("model") + " - "+
                    rs.getString("nom") + ", "+
                    rs.getString("cognoms") + " - "+
                    rs.getString("telefon")+ "\n"
            );
            return true;
        }
        else{
            return false;
        }
    }
    
    public void consultaEntradesVehicle(String matricula) throws SQLException{
        PS_entradesVehicle.setString(1,matricula);
        ResultSet rs = PS_entradesVehicle.executeQuery();
        
        System.out.println("Historial d'entrades");
        System.out.println("--------------------");
        System.out.println("ID | Entrada | Sortida | Dies | Motiu");
        
        String [] infoV;
        if(rs.next()){
            do{
                infoV = assignarEntrades(rs);
                System.out.println(
                    rs.getString("id") + " | " +
                    rs.getString("data_entrada") + " | " +
                    infoV[0] + " | "+
                    infoV[1] + " | "+
                    infoV[2]
                );
                
            }while(rs.next());
        }
    }
 
    
    public void consultarEntradesPropietari(String dni) throws SQLException{
        PS_entradesPropietaris.setString(1, dni);
        PS_entradesPropietaris.setString(2, dni);
        
        ResultSet rs = PS_entradesPropietaris.executeQuery();
        
        System.out.println("Historial d'entrades");
        System.out.println("--------------------");
        System.out.println("ID | Entrada | Sortida | Dies | Motiu | Matrícula | Vehicle");
        
        String [] infoProp;
        if(rs.next()){
            do{
                infoProp = assignarEntrades(rs);
                System.out.println(
                    rs.getString("id") + " | " +
                    rs.getString("data_entrada") + " | " +
                    infoProp[0] + " | "+
                    infoProp[1] + " | "+
                    infoProp[2] + " | "+
                    rs.getString("matricula") + " | " +
                    rs.getString("v.marca") + ", " + rs.getString("v.model")
                );
            }while(rs.next());
        }
    }
    
    /* Torna un array d'informacio del propietari
        0 - Data Sortida/Planta; 1 - Dies; 2 - Motiu*/
    private String[] assignarEntrades(ResultSet rs) throws SQLException{
        //Restar dies o posar la plaça de parking
        String [] ret = new String[3];
        Date avui;
        //Comprovem si el cotxe ha marxat del parking
        if(rs.getString("m.id").equals("0")){
            ret[0] = rs.getString("e.planta") +"-"+ rs.getString("e.plaça");
            avui = new Date(System.currentTimeMillis());
            ret[1] = diferenciaDates(rs.getString("data_entrada"),avui.toString());
            ret[2] = "-";
        }
        else{
            ret[0] = rs.getString("data_sortida");
            ret[1] = diferenciaDates (rs.getString("data_entrada"),rs.getString("data_sortida"));
            ret[2] = rs.getString("m.descripcio");
        }
        return ret;
    }
    /*  Aquest mètode només crida a la BBDD, l'he posat aquí perquè molts objectes
        havien d'incloure l'objecte BBDD només per poder fer consultes.
        Així incloim només un objecte*/
    public ResultSet consultaSQL(String query)throws SQLException{
        return DB.consultaSQL(query);
    }
    
    public int updateSQL(String statement)throws SQLException{
        return DB.updateSQL(statement);
    }
    
    //Passem dues date SQL i ens retorna el nombre de dies
    private String diferenciaDates(String sortida, String entrada)throws SQLException{
        PS_diferenciaDates.setString(1, entrada);
        PS_diferenciaDates.setString(2, sortida);
        ResultSet rs = PS_diferenciaDates.executeQuery();
        if(rs.next() == false)
            throw new SQLException("Error amb la diferència de dates");
        return rs.getString(1);
    }
    
}