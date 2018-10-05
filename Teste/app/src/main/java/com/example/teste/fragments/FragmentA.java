package com.example.teste.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.teste.MapsFragmnet;
import com.example.teste.R;

public class FragmentA extends Fragment{

    private FragmentManager mFragmentManager;
    private Button mButtonClinicas;
    private Button mButtonPetshop;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        mFragmentManager = getFragmentManager();

        mButtonClinicas = (Button) view.findViewById(R.id.button_clinicas);
        mButtonClinicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(new MapsFragmnet(), "Clinicas Veterinarias");
                mButtonClinicas.setVisibility(View.INVISIBLE);
                mButtonPetshop.setVisibility(View.INVISIBLE);

            }
        });

        mButtonPetshop = (Button) view.findViewById(R.id.button_petshops);
        mButtonPetshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(new MapsFragmnet(), "Petshops");
                mButtonClinicas.setVisibility(View.INVISIBLE);
                mButtonPetshop.setVisibility(View.INVISIBLE);
            }
        });

        return view;
    }

    public void showFragment(Fragment fragment, String nome){
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.container, fragment, nome);
        transaction.commit();


    }
}
