package prog2.model;

import java.util.Date;

public class PrestecLlarg extends Prestec{
    public PrestecLlarg(Exemplar _llibre, Usuari _usuari, Date _dataCreacio){
        super(_usuari, _llibre, _dataCreacio);
    }

    @Override
    public String tipusPrestec() {
        return "Llarg";
    }

    @Override
    public long duradaPrestec() {
        return 140L * 1000;
    }
}
