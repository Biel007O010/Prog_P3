package prog2.model;

import java.util.Date;

public abstract class Prestec implements InPrestec{
    private Usuari usuari;
    private Exemplar llibre;
    private Date dataComanda;
    private Date dataLimit;
    private boolean retornat;

    /**
     * Constructor de la classe
     * @param _usuari
     * @param _llibre
     * @param _dataCreacio
     */
    public Prestec(Usuari _usuari, Exemplar _llibre, Date _dataCreacio){
        this.usuari = _usuari;
        this.llibre = _llibre;
        this.dataComanda = _dataCreacio;
        this.retornat = false;

        long durada = _dataCreacio.getTime() + this.duradaPrestec();
        this.dataLimit = new Date(durada);
    }

    /**
     * Setter d l'exemplar
     * @param exemplar
     */
    @Override
    public void setExemplar(Exemplar exemplar) {
        this.llibre = exemplar;
    }

    /**
     * Getter de l'exemplar
     * @return
     */
    @Override
    public Exemplar getExemplar() {
        return this.llibre;
    }

    /**
     * Setter de l'usuari
     * @param usuari
     */
    @Override
    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    /**
     * Getter de l'usuari
     * @return
     */
    @Override
    public Usuari getUsuari() {
        return this.usuari;
    }

    /**
     * Setter de la data de creació del prèstec
     * @param data
     */
    @Override
    public void setDataCreacio(Date data) {
        this.dataComanda = data;
    }

    /**
     * Getter de la data de creació
     * @return
     */
    @Override
    public Date getDataCreacio() {
        return this.dataComanda;
    }

    /**
     * Setter de la data límit de retorn
     * @param data
     */
    @Override
    public void setDataLimitRetorn(Date data) {
        this.dataLimit = data;
    }

    /**
     * Getter de la data límit de retorn
     * @return
     */
    @Override
    public Date getDataLimitRetorn() {
        return this.dataLimit;
    }

    /**
     * Mètode abstracte que ens diu el tipus de prèstec que estem fent servir
     * @return
     */
    @Override
    public abstract String tipusPrestec();

    /**
     * Setter de si el prèstec s'ha retornat
     * @param retornat
     */
    @Override
    public void setRetornat(boolean retornat) {
        this.retornat = retornat;
    }

    /**
     * Getter de si el prèstec ha estat retornat
     * @return
     */
    @Override
    public boolean getRetornat() {
        return this.retornat;
    }

    /**
     * Mètode que retorna el prèstec i canvia el paràmetre de retornat a true
     */
    @Override
    public void retorna() {
        this.retornat = true;
        this.llibre.setDisponible(true);

        if(this instanceof PrestecLlarg){
            this.usuari.setNumPrestecsLlargs(this.usuari.getNumPrestecsLlargs() - 1);
        }else{
            this.usuari.setNumPrestecsNormals(this.usuari.getNumPrestecsNormals() - 1);
        }
    }

    /**
     * Mètode abstracte que defineix la durada del prèstec segons el tipus
     * @return
     */
    @Override
    public abstract long duradaPrestec();

    /**
     * Mètode que ens diu si el prèstec està endarrerit
     * @return
     */
    @Override
    public boolean prestecEndarrerit() {
        Date dataActual = new Date();
        if (dataActual.after(this.dataLimit) && !getRetornat()){
            return true;
        }
        return false;
    }

    public String toString(){
        String tipus;
        if(this instanceof PrestecLlarg){
            tipus = "Llarg";
        }else{
            tipus = "Normal";
        }
        return "Nom: " + usuari.getNom() + "| Títol del llibre: " + llibre.getTitol() + "| Tipus: " + tipus;

    }
}
