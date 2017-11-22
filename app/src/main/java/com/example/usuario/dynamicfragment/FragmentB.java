package com.example.usuario.dynamicfragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by usuario on 11/16/17.
 */

public class FragmentB extends Fragment {

    private TextView txvMessage;

    @Override
    public void onAttach(Context context) {
        Log.d("FRAGMENT_B","onAttach");
        super.onAttach(context);
    }

    /**
     * ATENCIÓN: Para que el estado dinámico de un fragment sea permanente ante un cambio de
     * configuración usar setRetainInstance();
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("FRAGMENT_B","onCreate");
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("FRAGMENT_B","onCreateView");
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        txvMessage = view.findViewById(R.id.txvMessage);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.d("FRAGMENT_B","onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            changeTextAndSize(bundle.getString("message"), bundle.getInt("size"));
        }
    }

    @Override
    public void onStart() {
        Log.d("FRAGMENT_B","onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("FRAGMENT_B","onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("FRAGMENT_B","onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("FRAGMENT_B","onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("FRAGMENT_B","onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("FRAGMENT_B","onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("FRAGMENT_B","onDetach");
        super.onDetach();
    }

    public void changeTextAndSize(String message, int size) {
        txvMessage.setText(message);
        txvMessage.setTextSize(size);
    }

    /**

     Lourdes dice que lo comentemos :(

    //La activity peta con SaveInstanceState si se usa Support
    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("FRAGMENT_B","onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putString("message", txvMessage.getText().toString());
        outState.putFloat("size", txvMessage.getTextSize() / getResources().getDisplayMetrics().scaledDensity);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("FRAGMENT_B","onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            changeTextAndSize(savedInstanceState.getString("message"), savedInstanceState.getInt("size"));
        }
    }

    */

    public static Fragment newInstance(Bundle bundle) {
        FragmentB fragmentB = new FragmentB();
        if(bundle != null) {
            fragmentB.setArguments(bundle);
        }
        return fragmentB;
    }
}
