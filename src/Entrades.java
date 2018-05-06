import java.sql.SQLException;
import java.util.Scanner;


public class Entrades {
    
    private final Consultes cons;
    
    public Entrades(Consultes _cons) {
        cons = _cons;
    }

    public void insertarEntrada (String pid, String pplaça, String pdataEntrada, String pmatricula, String pvehicle, String ppropietari, int ptelefon){
       // No ens ha donat temps a acabar aquest mètode
    }
}
//
//private boolean ConsultaPlaça(String planta, String  plaça) throws SQLException{
//        ResultSet rs = P.mostraInfo("planta" + "-" + "plaça");
//        if(rs.next()){
//            System.out.println(
//                    "Informacio propietari" + "\n"
//                    rs.getString("dni") + " \n " +
//                    rs.getString("cognoms") + ", " +
//                    rs.getString("nom") + " \n "+
//                    rs.getString("telefon") + "\n" + 
//                    rs.getString("adreça") + "\n" +
//                    "Informacio vehicle:" + "\n" +
//                    rs.getString("matricula") + " \n " +
//                    rs.getString("marca") + ", " +
//                    rs.getString("model") + " \n "+
//                    rs.getString("cognoms") + ", " +
//                    rs.getString("nom") + " \n "+
//                    rs.getString("telefon") + "\n"      
//        );
//            return true;
//        }
//        else
//            return false;
//    }
//
//    private String[] Modificar entrada(){
//        String[] ret = new String [5];
//        
//        System.out.println("Introdueix el nom del propietari: ");
//        ret[0] = in.nextLine();
//        System.out.println("Cognoms: ");
//        ret[1] = in.nextLine();
//        System.out.println("Data naixement: ");
//        ret[2] = in.nextLine(); 
//        System.out.println("Adreça: ");
//        ret[3] = in.nextLine();
//        System.out.println("Telefon: ");
//        ret[4] = in.nextLine();
//        return ret;
//    }
