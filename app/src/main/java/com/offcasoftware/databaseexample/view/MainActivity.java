package com.offcasoftware.databaseexample.view;

import com.offcasoftware.databaseexample.R;
import com.offcasoftware.databaseexample.model.Person;
import com.offcasoftware.databaseexample.repository.PersonRepository;
import com.offcasoftware.databaseexample.repository.PersonRepositoryImpl;
import com.offcasoftware.databaseexample.view.adapter.PersonAdapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements PersonAdapter.PersonInterface {

    @BindView(R.id.persons_recycler_view)
    RecyclerView mRecyclerView;

    private PersonAdapter mPersonAdapter;
    private PersonRepository mPersonRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
        displayAllData();
    }

    @Override
    public void onPersonClick(final Person person) {
        Toast.makeText(this, "Person Click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPersonDeleteClick(final Person person) {
        Toast.makeText(this, "Person Delete", Toast.LENGTH_SHORT).show();
    }

    private void init() {
        mPersonAdapter = new PersonAdapter(this);
        mPersonAdapter.setPersonInterface(this);
        mPersonRepository = PersonRepositoryImpl.getInstance();
        mRecyclerView.setAdapter(mPersonAdapter);
    }

    private void displayAllData() {
        List<Person> persons = mPersonRepository.getPersons();
        mPersonAdapter.swapData(persons);
    }
}
