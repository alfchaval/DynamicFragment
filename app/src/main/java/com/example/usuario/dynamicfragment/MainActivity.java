package com.example.usuario.dynamicfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener {

    private Fragment fragmentA;
    private Fragment fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MAIN","onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();

        fragmentA = fragmentManager.findFragmentByTag(FragmentA.TAG);

        if(fragmentA == null) {
            fragmentA = new FragmentA();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(android.R.id.content, fragmentA, FragmentA.TAG);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onFragmentAEvent(String message, int size) {
        Log.d("MAIN","onFragmentAEvent");

        fragmentB = new FragmentB();
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        bundle.putInt("size", size);

        //Con el método setArguments se pasa la información que necesita el fragment
        //fragmentB.setArguments(bundle);

        //Se debe utilizar el patrón factoría, dónde la creación del objeto y el paso
        //de argumentos se ejecuten consecutivamente
        fragmentB = FragmentB.newInstance(bundle);

        //A continuación se empieza la transición de FragmentA a FragmentB
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(android.R.id.content, fragmentB);
        //Antes de realizar el commit se debe guardar la transición.
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
