import java.sql.ResultSet;
import java.sql.SQLException;



public class Vehicles {
    private final Consultes cons;
    
    public Vehicles(Consultes _cons){
        cons = _cons;
    }
    
    public boolean consultaVehicle(String matricula) throws SQLException{
        if(cons.consultaInfoVehicle(matricula) == false){
            return false;
        }
        cons.consultaEntradesVehicle(matricula);
        return true; 
    }
    //Afegeix un nou vehicle a la base de dades
    public int insertarVehicle(String matricula,String [] infoV) throws SQLException{
        String dbg = "INSERT INTO `vehicle`(matricula,marca,model,dni_propietari) "
                    + "VALUES ( \""+matricula+"\", \""+infoV[0]+"\", \""+infoV[1]+"\", \""+infoV[2]+"\")";
        return cons.updateSQL(dbg);
    }
    //Permet modificar un vehicle de la base de dades indtroduint el dni
    public int modificarVehicle(String matricula,String [] infoV)  throws SQLException{
        String dbg = "UPDATE `vehicle` SET `marca`=\""+infoV[0]+"\",`model`=\""+infoV[1]+"\",`dni_propietari`=\""+infoV[2]+"\"";
        return cons.updateSQL(dbg);
    }
}
