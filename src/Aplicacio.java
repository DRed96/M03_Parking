import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Aplicacio {
    private final Scanner in; 
    private String nomOperari;
    
    private final String DB_nom ="m03_parking";
    private final String DB_usuari ="root";
    private final String DB_contrasenya ="";
    
    //Objectes
    private final Vehicles V;
    private final BaseDades DB;
    private final Consultes C;
    private final Propietaris P;
    private final Entrades E;
    
    public Aplicacio()throws SQLException{
        in = new Scanner(System.in);
        DB = new BaseDades(DB_nom,DB_usuari,DB_contrasenya);
        DB.DBConnecta_ModeModern();
        C = new Consultes(DB);
        V = new Vehicles(C);
        P = new Propietaris(C);
        E = new Entrades(C);
    }

    public static void main(String[] args) throws SQLException{
        Aplicacio app = new Aplicacio();
        app.menuPrincipal("Cognom1, Nom1");
    }
    
    //Demana a l'usuari una pregunta de si o no fins que introdueixi un resultat vàlid
    private boolean preguntaSN(String enunciat){
        System.out.println(enunciat);
        boolean resultat = false;
        do{
            System.out.println("Introdueix una opció (s/n)");
            String op = in.nextLine();
            
            if(op.contains("s") || op.contains("S"))
                resultat = true;
            if(op.contains("n") || op.contains("N"))
                resultat = !resultat;
            //Comprovem que l'usuari no pugui introduïr N i S al mateix temps
        }while(resultat == false);
        
        return resultat;
    }
    
    public void menuPrincipal(String nom) throws SQLException{
        int opcio;
        nomOperari = nom;
        do {
            System.out.println("Menú principal");
            System.out.println("--------------");
            System.out.println("Operari: "+ nomOperari);
            
            System.out.println("\n 1. Vehicles");
            System.out.println("\n 2. Propietaris");
            System.out.println("\n 3. Entrades");
            System.out.println("\n 4. Llista");
            
            System.out.println("\n\n\n 0. Tancar sessió");
            
            opcio = opcionsPrincipal();
        } while (opcio != 0);
    }
    
    private int opcionsPrincipal() throws SQLException{
        int opcio;
        try{
            //opcio = in.nextInt();
            //in.nextLine();//Netejem el buffer
            opcio = 4;
            switch (opcio) {
                case 0:
                    DB.DBDesconnecta();
                    break;
                case 1:
                    demanarVehicle();
                    break;
                case 2:
                    demanarPropietari();
                    break;
                case 3:
                    menuEntrades();
                    break;
                case 4:
                    menuLlistat();
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        }
        catch(InputMismatchException e){
            System.out.println(e.getMessage());
            opcio = -1;
        }
        
        in.nextLine();
        return opcio;
    }
    
    /*  Retorna un array amb l'informació passada
        0 - Marca; 1 - Model; 2 - DNI;
    */
    private String[] demanarCampsVehicle(){
        String[] ret = new String [3];
        
        System.out.println("Introdueix la marca del vehicle: ");
        ret[0] = in.nextLine();
        System.out.println("Model: ");
        ret[1] = in.nextLine();
        System.out.println("DNI propietari: ");
        ret[2] = in.nextLine(); 
        
        return ret;
    }
    
    private boolean matriculaDesconeguda(String matricula) throws SQLException{
        boolean ret = false;
        boolean resultat;        
        resultat = preguntaSN("No s'ha trobat un vehicle amb aquesta matricula, vols crear-lo?");
              
        if(resultat){
            String [] infoV;
            
            infoV = demanarCampsVehicle();
            
            if(V.insertarVehicle(matricula,infoV) == 1){
                System.out.println("Vehicle insertat amb èxit \n\n\n");
            }else{
                throw new SQLException("Error en l'inserció d'un vehicle");
            }
            System.out.println("\n\n");
            ret = true;
        }
        return ret;
    }
    
    private void demanarVehicle() throws SQLException{
        String [] info;
        
        System.out.println("\n");
        System.out.println("Vehicles");
        System.out.println("--------");
        System.out.print("Matricula> ");
        String matricula = "11122X";
        //in.nextLine();
        
        if(V.consultaVehicle(matricula)){
            if(preguntaSN("Vols modificar l'informació del vehicle? (s/n)")){
                info = demanarCampsVehicle();
                V.modificarVehicle(matricula,info);
            }
            else
                in.nextLine();
        }
        else{
            matriculaDesconeguda(matricula);
        }
    }
    
    private boolean consultarInfoPropietari(String dni) throws SQLException{
        ResultSet rs = P.consultaInfo(dni);
        if(rs.next()){
            System.out.println(
                    rs.getString("dni") + " - " +
                    rs.getString("cognoms") + ", " +
                    rs.getString("nom") + " - "+
                    rs.getString("telefon") + "\n" +
                    rs.getString("adreça")
            );
            return true;
        }
        else
            return false;
    }
     /*  Retorna un array amb l'informació passada
        0 - Nom; 1 - Cognoms; 2 - Data Naixement; 3 - Adreça; 4 - Telefon
    */
    private String[] demanarCampsPropietari(){
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
    }
    
    private boolean propietariDesconegut(String dni) throws SQLException{
        boolean ret = false;
        boolean resultat;        
        resultat = preguntaSN("No s'ha trobat un propietari amb aquesta matricula, vols crear-lo?");
              
        if(resultat){
            String [] infoP;
            
            infoP = demanarCampsPropietari();
            
            if(P.insertarPropietari(dni,infoP) == 1){
                System.out.println("Propietari insertat amb èxit \n\n\n");
            }else{
                throw new SQLException("Error en l'inserció d'un propietari");
            }
            System.out.println("\n\n");
            ret = true;
        }
        return ret;
    }
    
    private void demanarPropietari() throws SQLException{
        System.out.println("\n");
        System.out.println("Propietaris");
        System.out.println("--------");
        System.out.print("DNI> ");
        String dni = "12345678P";
        
        String [] infoP;
        if(consultarInfoPropietari(dni)){
            P.consultaEntrades(dni);
            if(preguntaSN("Vols modificar l'informació del propietari? (s/n)")){
                infoP = demanarCampsPropietari();
                P.modificarPropietari(dni,infoP);
            }
        }
        else{
            propietariDesconegut(dni);
        }
    }
    
    
    
    private void menuEntrades(){
        int opcio = 0;
        Scanner dades = new Scanner(System.in);
        do {
            System.out.println("\nMenú d’entrades i sortides");
            System.out.println("\n--------------------------");
            System.out.println("\nOperari: "+ nomOperari);
            System.out.println("\n");
            System.out.println("\n 1 – Entrada");
            System.out.println("\n 2 – Sortida");
            System.out.println("\n 3 – Modificació");
            System.out.println("\n 4 – Consulta per plaça");
            System.out.println("\n\n\n 0 – Enrere");
            
            opcio = opcionsEntrades();
            System.out.println("\nPressiona ENTER per a continuar");
            in.nextLine();
        } while (opcio != 0);
    }
    
    
    private int opcionsEntrades() throws SQLException{
        int opcio;
        try{
            opcio = in.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    novaEntrada();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        }
        catch(InputMismatchException e){
            System.out.println(e.getMessage());
            opcio = -1;
        }
        return opcio;
    }
    
    private void novaEntrada() throws SQLException{
        String id;
        System.out.println("\nIntroduir id : ");
        id = in.nextLine();
        System.out.println("\nIntroduir plaça");
        String plaça = in.nextLine();
        System.out.println("\nIntroduir data entrada");
        String dataEntrada = in.nextLine();
        System.out.println("\nIntroduir matricula");
        String matricula = in.nextLine();
        System.out.println("\nIntroduir model vehicle");
        String vehicle = in.nextLine();
        System.out.println("\nIntroduir Propietari");
        String propietari = in.nextLine();
        System.out.println("\nTelefon propietari");
        String telefon = in.nextLine();
        
        E.insertarEntrada(id,plaça,dataEntrada,matricula,vehicle,propietari,telefon);
    }
    
    private void menuLlistat() throws SQLException{
        int opcio = 0;
        do {
            
            System.out.println("\nMenú de llistat");
            System.out.println("\n--------------------------");
            System.out.println("\nOperari: "+nomOperari);
            System.out.println("\n");
            System.out.println("\n 1 – Vehicles pendents");
            System.out.println("\n 2 – Vehicles entrants en data");
            System.out.println("\n 3 – Vehicles sortints en data");
            System.out.println("\n 4 – Places lliures");
            System.out.println("\n\n\n 0 – Enrere");
            
            opcio = opcionsLlistat();
            System.out.println("\nPressiona ENTER per a continuar");
            in.nextLine();
        } while (opcio != 0);
    }
    
    
    private int opcionsLlistat()throws SQLException{
        int opcio;
        try{
            //opcio = 1;
            opcio = in.nextInt();in.nextLine();
            System.out.print("\n");
            String data;
            switch (opcio) {
                case 0:
                    
                    break;
                case 1:
                    C.vehiclesPendents();
                    break;
                case 2:
                    System.out.print("Vehicles entrants en data> ");
                    data = in.nextLine();
                    C.consultaVehiclesEnData(true,data);
                    break;
                case 3:
                    System.out.print("Vehicles sortints en data> ");
                    data = in.nextLine();
                    C.consultaVehiclesEnData(false,data);
                    break;
                case 4:

                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        }
        catch(InputMismatchException e){
            System.out.println(e.getMessage());
            opcio = -1;
        }
        return opcio;
    }
}
