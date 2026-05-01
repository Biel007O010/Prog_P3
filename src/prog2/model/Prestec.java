package prog2.model;

import java.util.Date;

public abstract class Prestec implements InPrestec{
    private Usuari usuari;
    private Exemplar llibre;
    private Date dataComanda;
    private Date dataLimit;
    private boolean retornat;

    public Prestec(Usuari _usuari, Exemplar _llibre, Date _dataCreacio){
        this.usuari = _usuari;
        this.llibre = _llibre;
        this.dataComanda = _dataCreacio;
        this.retornat = false;

        long durada = _dataCreacio.getTime() + this.duradaPrestec();
        this.dataLimit = new Date(durada);
    }

    @Override
    public void setExemplar(Exemplar exemplar) {
        this.llibre = exemplar;
    }

    @Override
    public Exemplar getExemplar() {
        return this.llibre;
    }

    @Override
    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    @Override
    public Usuari getUsuari() {
        return this.usuari;
    }

    @Override
    public void setDataCreacio(Date data) {
        this.dataComanda = data;
    }

    @Override
    public Date getDataCreacio() {
        return this.dataComanda;
    }

    @Override
    public void setDataLimitRetorn(Date data) {
        this.dataLimit = data;
    }

    @Override
    public Date getDataLimitRetorn() {
        return this.dataLimit;
    }

    @Override
    public abstract String tipusPrestec();

    @Override
    public void setRetornat(boolean retornat) {
        this.retornat = retornat;
    }

    @Override
    public boolean getRetornat() {
        return this.retornat;
    }

    @Override
    public void retorna() {
        this.retornat = true;
    }

    @Override
    public abstract long duradaPrestec();

    @Override
    public boolean prestecEndarrerit() {
        Date dataActual = new Date();
        if (dataActual.after(this.dataLimit)){
            return true;
        }
        return false;
    }
}
