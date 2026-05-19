package prog2.model;

import java.io.Serializable;

public class Exemplar implements InExemplar, Serializable {

    private String id;
    private String titol;
    private String autor;
    private boolean prestecLlarg;
    private boolean disponibilitat;

    /**
     * @param _id
     * @param _titol
     * @param _autor
     * @param _prestecLlarg
     * Constructor de la classe
     */
    public Exemplar(String _id, String _titol, String _autor, boolean _prestecLlarg){
        this.id = _id;
        this.titol = _titol;
        this.autor = _autor;
        this.prestecLlarg = _prestecLlarg;
        this.disponibilitat = true;
    }

    /**
     * @param id
     * Setter del ID
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return id
     * Getter del ID
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * @param titol
     * Setter del Títol
     */
    @Override
    public void setTitol(String titol) {
        this.titol = titol;
    }

    /**
     * @return
     * Getter del Títol
     */
    @Override
    public String getTitol() {
        return this.titol;
    }

    /**
     * @param autor
     * Setter de l'Autor
     */
    @Override
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return
     * Getter de l'Autor
     */
    @Override
    public String getAutor() {
        return this.autor;
    }

    /**
     * @param admetPrestecLlarg
     * Setter prèstec llarg
     */
    @Override
    public void setAdmetPrestecLlarg(boolean admetPrestecLlarg) {
        this.prestecLlarg = admetPrestecLlarg;
    }

    /**
     * @return
     * Getter prèstec llarg
     */
    @Override
    public boolean getAdmetPrestecLlarg() {
        return this.prestecLlarg;
    }

    /**
     * @param disponibilitat
     * Setter de si està disponible
     */
    public void setDisponible(boolean disponibilitat){
        this.disponibilitat = disponibilitat;
    }

    /**
     * @return
     * Getter de si està disponible
     */
    public boolean isDisponible(){
        return this.disponibilitat;
    }

    /**
     * @return
     * Retorna informació de l'exemplar
     */
    @Override
    public String toString() {
        return "Id=" + id + ", Titol=" + titol + ", Autor=" + autor + ", Admet prestec llarg=" + prestecLlarg + ", Disponible=" + disponibilitat;
    }
}
