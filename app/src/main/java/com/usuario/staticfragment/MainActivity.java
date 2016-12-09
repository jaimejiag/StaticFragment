package com.usuario.staticfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.usuario.staticfragment.fragments.BFragment;
import com.usuario.staticfragment.fragments.FragmentA;

public class MainActivity extends FragmentActivity implements FragmentA.FragmentIterationListener{
    private BFragment fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentB = (BFragment) getFragmentManager().findFragmentById(R.id.fragment_b);
    }

    @Override
    public void onFragmentIterationListener(String text, int size) {
        fragmentB.changedTextProperties(text, size);
    }
}
