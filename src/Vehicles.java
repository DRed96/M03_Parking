
import java.sql.ResultSet;
import java.sql.SQLException;

/* Pots modificar la matrícula d'un vehicle ?*/
public class Vehicles {
    private String mat;
    public Vehicles(){
    
    }
    
    
    public void mostraVehicle(String matricula) throws SQLException{
        mat = matricula;
        try{
            mostraInfo();
            mostraEntrades();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void mostraInfo() throws Exception{
//        ResultSet rs = conn.consultaInfoVehicle(mat);
//        if(rs.next()){
//            System.out.println(
//                    rs.getString("matricula") + " - " +
//                    rs.getString("marca") + ", " +
//                    rs.getString("model") + " - "+
//                    rs.getString("nom") + ", "+
//                    rs.getString("cognoms") + " - "+
//                    rs.getString("telefon")+ "\n"
//            );         
//        }
//        else{
//            throw new Exception("No s'ha trobat el vehicle amb la matricula"+mat);
//        }
    }
    
    private void mostraEntrades() throws Exception{
        //Aquesta consulta és només d'una taula així que la fem manualment
//        s
        System.out.println("Historial d'entrades");
        System.out.println("--------------------");
        System.out.println("ID | Entrada | Sortida | Dies | Motiu");
        
    }
    
}
