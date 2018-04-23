
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David Roig
 */
class Menus {
    
    private Scanner in; 
    
    public Menus(){
        in = new Scanner(System.in);
    }
    
    public String identificaOperari(){
        String ret;
        System.out.println("Grua municipal de Terrassa");
        System.out.println("--------------------------");
        System.out.print("Identificació>");
        ret = in.nextLine();
        
        // buscar a la base de dades
        
        
        return ret;
    }
    
    public void menuPrincipal(String nomOperari){
        int opcio = 0;
        do {
            System.out.println("Menú principal");
            System.out.println("--------------");
            System.out.println("Operari: "+ nomOperari);
            
            System.out.println("\n 1. Gestió de platges");
            System.out.println("\n 2. Gestió de zones");
            System.out.println("\n 3. Gestió de velomars");
            System.out.println("\n 4. Gestió d'ombrel.les");
            System.out.println("\n 5. Gestió d'hamaques");
            System.out.println("\n 6. Gestió d'encarregats");
            
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
    
    private void menuEntrades(){
        int opcio = 0;
        Scanner dades = new Scanner(System.in);
        do {
            
            System.out.println("\nMenú d’entrades i sortides");
            System.out.println("\n--------------------------");
            System.out.println("\nOperari: "  );
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
}
