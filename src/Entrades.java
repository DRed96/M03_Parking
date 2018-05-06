import java.sql.SQLException;
import java.util.Scanner;


public class Entrades {
    
    private String id;
    private String plaça;
    private String dataEntrada;
    private int dies;
    private String dataSortida;
    private String motiu;
    private char matricula;
    private String vehicle;
    private int telefon;
  
    public Entrades(String pid, String pplaça, String pdataEntrada, int pdies, String pdataSortida, String pmotiu, char pmatricula, String pvehicle, int ptelefon) {
        id = pid;
        plaça = pplaça;
        dataEntrada = pdataEntrada;
        dies = pdies;
        dataSortida = pdataSortida;
        motiu = pmotiu;
        matricula = pmatricula;
        vehicle = pvehicle;
        telefon = ptelefon;
    }

 public static Entrades novaEntrada (String pid, String pplaça, String pdataEntrada, char pmatricula, String pvehicle, String ppropietari, int ptelefon){
     Scanner dades = new Scanner(System.in);
        
        System.out.println("\nIntroduir id : ");
        id = dades.next();
        System.out.println("\nIntroduir plaça");
        Scanner plaça = new Scanner(System.in);
        System.out.println("\nIntroduir data entrada");
        Scanner dataEntrada = new Scanner(System.in);
        System.out.println("\nIntroduir matricula");
        Scanner matricula = new Scanner(System.in);
        System.out.println("\nIntroduir model vehicle");
        Scanner vehicle = new Scanner(System.in);
        System.out.println("\nIntroduir Propietari");
        Scanner propietari = new Scanner(System.in);
        System.out.println("\nTelefon propietari");
        Scanner telefon = new Scanner(System.in);
        
        return new Entrades(pid, pplaça, pdataEntrada, pmatricula, pvehicle, ppropietari, ptelefon);
        
    }
}

private boolean ConsultaPlaça(String planta, String  plaça) throws SQLException{
        ResultSet rs = P.mostraInfo("planta" + "-" + "plaça");
        if(rs.next()){
            System.out.println(
                    "Informacio propietari" + "\n"
                    rs.getString("dni") + " \n " +
                    rs.getString("cognoms") + ", " +
                    rs.getString("nom") + " \n "+
                    rs.getString("telefon") + "\n" + 
                    rs.getString("adreça") + "\n" +
                    "Informacio vehicle:" + "\n" +
                    rs.getString("matricula") + " \n " +
                    rs.getString("marca") + ", " +
                    rs.getString("model") + " \n "+
                    rs.getString("cognoms") + ", " +
                    rs.getString("nom") + " \n "+
                    rs.getString("telefon") + "\n"      
        );
            return true;
        }
        else
            return false;
    }

 private String[] Modificar entrada(){
        String[] ret = new String [5];
        
        System.out.println("Introdueix el nom del propietari: ");
        ret[0] = in.nextLine();
        System.out.println("Cognoms: ");
        ret[1] = in.nextLine();
        System.out.println("Data naixement: ");
        ret[2] = in.nextLine(); 
        System.out.println("Adreça: ");
        ret[3] = in.nextLine();
        System.out.println("Telefon: ");
        ret[4] = in.nextLine();
        return ret;