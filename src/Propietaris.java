import java.sql.ResultSet;
import java.sql.SQLException;

/* Pots modificar la matrícula d'un vehicle ?*/
public class Propietaris {
    private char dni;
        public Propietaris(){
    
    }
    
    
    public void mostraPropietaris(char identificacio) throws SQLException{
        dni = identificacio;
        try{
            mostraInfo();
            mostraEntrades();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void mostraInfo() throws Exception{
//        ResultSet rs = conn.consultaInfoPropietari(dni);
//        if(rs.next()){
//            System.out.println(dni") + " - " +
//                    rs.getString("nom") + ", " +
//                    rs.getString("telefon") + " - "+
//                    rs.getString("carrer") + ", "+
//                    rs.getString("cognoms") + " - "+
//                    rs.getString("telefon")+ "\n"
//            );         
//        }
//        else{
//            throw new Exception("No s'ha trobat cap propietari amb el dni"+dni);
//        }
    }
    
    private void mostraEntrades() throws Exception{
        //Aquesta consulta és només d'una taula així que la fem manualment
//        s
        System.out.println("Historial d'entrades");
        System.out.println("--------------------");
        System.out.println("ID | Entrada | Sortida | Dies | Motiu | Matricula | Vehicle");
        
    }
    
}
