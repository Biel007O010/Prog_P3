package prog2.model;

public class Exemplar implements InExemplar{

    private String id;
    private String titol;
    private String autor;
    private boolean prestecLlarg;
    private boolean disponibilitat;

    public Exemplar(String _id, String _titol, String _autor, boolean _prestecLlarg){
        this.id = _id;
        this.titol = _titol;
        this.autor = _autor;
        this.prestecLlarg = _prestecLlarg;
        this.disponibilitat = true;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setTitol(String titol) {
        this.titol = titol;
    }

    @Override
    public String getTitol() {
        return this.titol;
    }

    @Override
    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String getAutor() {
        return this.autor;
    }

    @Override
    public void setAdmetPrestecLlarg(boolean admetPrestecLlarg) {
        this.prestecLlarg = admetPrestecLlarg;
    }

    @Override
    public boolean getAdmetPrestecLlarg() {
        return this.prestecLlarg;
    }

    public void setDisponible(boolean disponibilitat){
        this.disponibilitat = disponibilitat;
    }

    public boolean isDisponible(){
        return this.disponibilitat;
    }

    @Override
    public String toString() {
        return "Id=" + id + ", Titol=" + titol + ", Autor=" + autor + ", Admet prestec llarg=" + prestecLlarg + ", Disponible=" + disponibilitat;
    }
}
