package com.example.hollis.fragmentinterfacepractice;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnAnimalSelectedListener {
    List<Animal> animalList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAnimalList();

        // setup fragment manager and transaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // create animal list fragment
        AnimalListFragment animalListFragment = new AnimalListFragment();
        animalListFragment.setAnimalList(animalList);

        // TODO: add the daily forecast fragment to the container and commit the change
        fragmentTransaction.add(R.id.fragment_container, animalListFragment);
        fragmentTransaction.commit();

    }

    public void setAnimalList(){
        animalList = new ArrayList<>();
        Animal animal = new Animal("Lion", "big", 4);
        Animal animal1 = new Animal("Fish", "small", 0);
        Animal animal2 = new Animal("Koala", "medium", 2);
        animalList.add(animal);
        animalList.add(animal1);
        animalList.add(animal2);
    }

    @Override
    public void onAnimalSelected(Animal animal) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setAnimalText(animal);

        fragmentTransaction.replace(R.id.fragment_container, detailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
