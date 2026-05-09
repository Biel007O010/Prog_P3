package prog2.model;

public abstract class Usuari implements InUsuari{

    /**
     * Atributs
     */
    private String email;
    private String nom;
    private String adreca;
    private int prestecsNormals;
    private int prestecsLlargs;

    /**
     * Constructor
     * @param email
     * @param nom
     * @param adreca
     */
    public Usuari(String email, String nom, String adreca){
        this.email = email;
        this.nom = nom;
        this.adreca = adreca;
        this.prestecsNormals = 0;
        this.prestecsLlargs = 0;
    }

    /**
     * Setter del email
     * @param email
     */
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter del email
     * @return
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     * Setter del nom
     * @param nom
     */
    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter del nom
     * @return
     */
    @Override
    public String getNom() {
        return this.nom;
    }

    /**
     * Setter de l'adreça
     * @param adreca
     */
    @Override
    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    /**
     * Getter de l'adreça
     * @return
     */
    @Override
    public String getAdreca() {
        return this.adreca;
    }

    /**
     * Metode String
     * @return
     */
    @Override
    public abstract String tipusUsuari();

    /**
     * Setter del núm de prestecs normals
     * @param numPrestecsNormals
     */
    @Override
    public void setNumPrestecsNormals(int numPrestecsNormals) {
        this.prestecsNormals = numPrestecsNormals;
    }

    /**
     * Getter del núm de prestecs normals
     * @return
     */
    @Override
    public int getNumPrestecsNormals() {
        return this.prestecsNormals;
    }

    /**
     * Setter del nombre de prestecs llargs
     * @param numPrestecstLlargs
     */
    @Override
    public void setNumPrestecsLlargs(int numPrestecstLlargs) {
        this.prestecsLlargs = numPrestecstLlargs;
    }

    /**
     * Getter del nombre de prestecs llargs
     * @return
     */
    @Override
    public int getNumPrestecsLlargs() {
        return prestecsLlargs;
    }

    /**
     * Mètode que retorna el màxim de prèstecs normals d'aquest tipus d'usuari
     * @return
     */
    @Override
    public abstract int getMaxPrestecsNormals();

    /**
     * Mètode que retorna el màxim de prèstecs llargs d'aquest tipus d'usuari
     * @return
     */
    @Override
    public abstract int getMaxPrestecsLlargs();

    /**
     * Metode toString
     * @return
     */
    @Override
    public String toString() {
        return "Tipus=" + tipusUsuari() +
                ", Email=" + getEmail() +
                ", Nom=" + getNom() +
                ", Adreca=" + getAdreca() +
                ", Num. prestecs normals=" + getNumPrestecsNormals() +
                ", Num. prestecs llargs=" + getNumPrestecsLlargs();
    }
}
