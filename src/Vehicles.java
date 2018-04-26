
import java.sql.ResultSet;
import java.sql.SQLException;

/* Pots modificar la matrícula d'un vehicle ?*/
public class Vehicles {
    private final Connexio conn;
    public Vehicles(String dbNom, String dbUsu, String dbPass ){
        conn = new Connexio(dbNom,dbUsu,dbPass);
    }
    
    public void mostraVehicle(String matricula) throws SQLException{
        ResultSet rs = conn.consultaInfoVehicle(matricula);
        
        if(rs.next()){
            System.out.println("Historial d'entrades");
            System.out.println("--------------------");
            System.out.println("ID | Entrada | Sortida | Dies | Motiu");
            System.out.println(
                    rs.getString("matricula") + " - " +
                    rs.getString("marca") + ", " +
                    rs.getString("model") + " - "+
                    rs.getString("nom") + ", "+
                    rs.getString("cognoms") + " - "+
                    rs.getString("telefon")
            );
        }
        else{
            System.out.println("No s'ha trobat el vehicle");
        }
    }
    
    private void getInfoPropietari(){
        
    }
    
}
