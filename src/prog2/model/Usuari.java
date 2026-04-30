package prog2.model;

public abstract class Usuari implements InUsuari{

    private String email;
    private String nom;
    private String adreca;
    private int prestecsNormals;
    private int prestecsLlargs;

    public Usuari(String email, String nom, String adreca){
        this.email = email;
        this.nom = nom;
        this.adreca = adreca;
        this.prestecsNormals = 0;
        this.prestecsLlargs = 0;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    @Override
    public String getAdreca() {
        return this.adreca;
    }

    @Override
    public abstract String tipusUsuari();

    @Override
    public void setNumPrestecsNormals(int numPrestecsNormals) {
        this.prestecsNormals = numPrestecsNormals;
    }

    @Override
    public int getNumPrestecsNormals() {
        return this.prestecsNormals;
    }

    @Override
    public void setNumPrestecsLlargs(int numPrestecstLlargs) {
        this.prestecsLlargs = numPrestecstLlargs;
    }

    @Override
    public int getNumPrestecsLlargs() {
        return prestecsLlargs;
    }

    @Override
    public abstract int getMaxPrestecsNormals();

    @Override
    public abstract int getMaxPrestecsLlargs();

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
