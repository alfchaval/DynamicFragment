package com.example.usuario.dynamicfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener {

    private Fragment fragmentA;
    private Fragment fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentA = fragmentManager.findFragmentById(android.R.id.content);
        fragmentA = new FragmentA();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(android.R.id.content, fragmentA);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentAEvent(String message, int size) {
        fragmentB = new FragmentB();
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        bundle.putInt("size", size);
        //Con el método setArguments se pasa la información que necesita el fragment
        fragmentB.setArguments(bundle);
        // A continuación se empieza la transición de FragmentA a FragmentB
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(android.R.id.content, fragmentB);
        fragmentTransaction.commit();
    }
}
