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