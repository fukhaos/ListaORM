package br.com.viniciusoliveira.listasugarorm.dados;

import com.orm.SugarRecord;

/**
 * Created by user on 12/03/15.
 */
public class Person extends SugarRecord<Person> {
    String name;
    String email;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
