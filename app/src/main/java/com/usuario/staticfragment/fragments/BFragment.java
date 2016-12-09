package com.usuario.staticfragment.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.usuario.staticfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment {
    private TextView txvResultado;

    public BFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_b, container, false);

        if (rootView != null) {
            txvResultado = (TextView)rootView.findViewById(R.id.txv_resultado);
        }

        return rootView;
    }


    public void changedTextProperties(String text, int fontSize) {
        txvResultado.setText(text);
        txvResultado.setTextSize(fontSize);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("text", txvResultado.getText().toString());
        outState.putInt("size", (int)txvResultado.getTextSize());
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if (savedInstanceState != null) {
            txvResultado.setText(savedInstanceState.getString("text"));
            DisplayMetrics metrics = getResources().getDisplayMetrics();    //Es necesario para que el tamaño se mantenga, porque va aumentando.
            txvResultado.setTextSize(savedInstanceState.getInt("size") / metrics.density);
        }
    }
}
