/* Pots modificar la matrícula d'un vehicle ?*/
public class Vehicles {
    private final Connexio conn;
    public Vehicles(String dbNom, String dbUsu, String dbPass ){
        conn = new Connexio(dbNom,dbUsu,dbPass);
    }
    
    public static boolean matriculaExisteix(String matricula){
        
    }
}
