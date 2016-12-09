package com.usuario.staticfragment.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.usuario.staticfragment.R;


public class FragmentA extends Fragment {
    EditText mEdtEscribir;
    SeekBar mSkbDeslizador;
    Button mBtnCambiarTexto;
    private FragmentIterationListener mCallBack;

    public FragmentA() {

    }

    public interface FragmentIterationListener {
        void onFragmentIterationListener (String text, int size);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallBack = (FragmentIterationListener)activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement FragmentIterationListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_a, container, false);

        if (rootView != null) {
            mEdtEscribir = (EditText)rootView.findViewById(R.id.edt_escribir);
            mSkbDeslizador = (SeekBar)rootView.findViewById(R.id.skb_deslizador);
            mBtnCambiarTexto = (Button) rootView.findViewById(R.id.btn_cambiarTexto);
            mBtnCambiarTexto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallBack.onFragmentIterationListener(mEdtEscribir.getText().toString(), mSkbDeslizador.getProgress());
                }
            });
        }

        return rootView;
    }
}
