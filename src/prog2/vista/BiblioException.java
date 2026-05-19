package prog2.vista;

import java.io.Serializable;

public class BiblioException extends Exception implements Serializable {
    public BiblioException(String message) {
        super(message);
    }
}
