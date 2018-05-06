import java.sql.ResultSet;
import java.sql.SQLException;


public class Propietaris {
    private final Consultes cons;
    
    public Propietaris(Consultes _cons){
        cons = _cons;
    }
    
    public ResultSet consultaInfo(String dni) throws SQLException{
        ResultSet rs;
        rs = cons.consultaSQL("SELECT * "
                              + "FROM propietari "
                              + "WHERE dni = \""+dni+"\"");
        return rs;
    }
    
    public void consultaEntrades(String DNI) throws SQLException{
        cons.consultarEntradesPropietari(DNI);
    }
    //Afegeix un nou propietari a la base de dades
    public int insertarPropietari(String dni,String [] infoP) throws SQLException{
        String dbg = "INSERT INTO `propietari`(dni,nom,cognoms,data_naixement,adreça,telefon) "
                    + "VALUES ( \""+dni+"\", \""+infoP[0]+"\", \""+infoP[1]+"\", \""+infoP[2]+"\", "
                    + "\""+infoP[3]+"\", \""+infoP[4]+"\")";
        return cons.updateSQL(dbg);        
    }   
    //Permet modificar un propietari de la base de dades indtroduint el dni
    public int modificarPropietari(String dni,String [] infoP)  throws SQLException{
        String dbg = "UPDATE `propietari` SET `nom`=\""+infoP[0]+"\",`cognoms`=\""+infoP[1]+"\",`data_naixement`=\""+infoP[2]+"\",`adreça`=\""+infoP[3]+"\",`telefon`=\""+infoP[4]+"\" WHERE `dni` =\""+dni+"\"";
                    
        return cons.updateSQL(dbg);
    }
}
