package prog2.model;

import java.util.Date;

public class PrestecLlarg extends Prestec{
    /**
     * Constructor de la classe, passa atributs a la classe superior
     * @param _llibre
     * @param _usuari
     * @param _dataCreacio
     */
    public PrestecLlarg(Exemplar _llibre, Usuari _usuari, Date _dataCreacio){
        super(_usuari, _llibre, _dataCreacio);
    }

    /**
     * Mètode que ens retorna el tipus de prèstec que estem fent servir
     * @return
     */
    @Override
    public String tipusPrestec() {
        return "Llarg";
    }

    /**
     * Mètode que retorna la durada del prèstec que estem fent servir
     * @return
     */
    @Override
    public long duradaPrestec() {
        return 140L * 1000;
    }
}
