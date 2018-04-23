import java.util.InputMismatchException;
import java.util.Scanner;

public class Aplicacio {
    private Scanner in; 
    private String nomOperari;
    
    private final String DB_nom ="m03_parking";
    private final String DB_usuari ="root";
    private final String DB_contrasenya ="";
    
    public Aplicacio(){
        in = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Aplicacio app = new Aplicacio();
        app.menuPrincipal("Cognom1, Nom1");
    }
    
    public void menuPrincipal(String nom){
        int opcio = 0;
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
    
    private int opcionsPrincipal(){
        int opcio;
        try{
            opcio = in.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuVehicles();
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
    private void menuVehicles(){
        System.out.println("Vehicles");
        System.out.println("--------");
        System.out.print("Matricula> ");
        in.nextLine();
        
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
        } while (opcio != 0);
    }
    
    
    private int opcionsEntrades(){
        int opcio;
        try{
            opcio = in.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
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
    
    private void menuLlistat(){
        int opcio = 0;
        Scanner dades = new Scanner(System.in);
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
        } while (opcio != 0);
    }
    
    
    private int opcionsLlistat(){
        int opcio;
        try{
            opcio = in.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:

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
}
