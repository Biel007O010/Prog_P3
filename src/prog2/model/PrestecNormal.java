package prog2.model;

import java.util.Date;

public class PrestecNormal extends Prestec{
    public PrestecNormal(Exemplar _llibre, Usuari _usuari, Date _dataCreacio){
        super(_usuari, _llibre, _dataCreacio);
    }

    @Override
    public String tipusPrestec() {
        return "Normal";
    }

    @Override
    public long duradaPrestec() {
        return 70L * 1000;
    }
}
