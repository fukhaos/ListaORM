package br.com.viniciusoliveira.listasugarorm;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import br.com.viniciusoliveira.listasugarorm.dados.Person;


public class MainActivity extends ActionBarActivity {

    EditText campo;
    ListView listView;
    private ArrayAdapter<String> itemsAdapter;
    ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo = (EditText) findViewById(R.id.campo);
        listView = (ListView) findViewById(R.id.lista);

        List<Person> pessoas = Person.listAll(Person.class);

        items = new ArrayList<String>();

        for (Person pessoa : pessoas) {
           items.add(pessoa.getName());
        }


        Log.i("Total", String.valueOf(pessoas.size()));

        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);
    }

    public void addTarefa(View view) {
        Person person = new Person(campo.getText().toString(), "email@exemplo.com.br");
        person.save();

        items.add(person.getName());
        itemsAdapter.notifyDataSetChanged();
    }
}
