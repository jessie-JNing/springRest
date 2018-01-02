package spring.exception.model;

import java.io.Serializable;

public class PersonNotFoundException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    public PersonNotFoundException() {
        super();
    }

    public PersonNotFoundException(String msg) {
        super(msg);
    }

    public PersonNotFoundException(String msg, Exception e) {
        super(msg, e);
    }
}
