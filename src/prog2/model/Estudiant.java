package prog2.model;

public class Estudiant extends Usuari{
    /**
     * @param email
     * @param nom
     * @param adreca
     * Constructor de la classe, passa atributs de la classe superior amb el super.
     */
    public Estudiant(String email, String nom, String adreca){
        super(email, nom, adreca);
    }

    /**
     * @return
     * Mètode que ens diu quin tipus d'usuari estem tractant
     */
    @Override
    public String tipusUsuari() {
        return "Estudiant";
    }

    /**
     * @return
     *Mètode que retorna el màxim de prèstecs normals d'aquest tipus d'usuari
     */
    @Override
    public int getMaxPrestecsNormals() {
        return 2;
    }

    /**
     * @return
     *Mètode que retorna el màxim de prèstecs llargs d'aquest tipus d'usuari
     */
    @Override
    public int getMaxPrestecsLlargs() {
        return 1;
    }
}
