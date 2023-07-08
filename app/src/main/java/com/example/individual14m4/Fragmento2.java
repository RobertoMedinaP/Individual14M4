package com.example.individual14m4;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.individual14m4.databinding.FragmentFragmento2Binding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragmento2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmento2 extends Fragment {

    private FragmentFragmento2Binding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String nombre1;
    private String nombre2;

    public Fragmento2() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Fragmento2 newInstance(String nombre1, String nombre2) {
        Fragmento2 fragment = new Fragmento2();
        Bundle args = new Bundle();
        //Importante mantener los mismos nombres
        args.putString("Clave1", nombre1);
        args.putString("clave2", nombre2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //ojo Clave1 y clave 2
            nombre1 = getArguments().getString("Clave1");
            nombre2 = getArguments().getString("clave2");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding=FragmentFragmento2Binding.inflate(inflater,container,false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.tv1.setText(nombre1);
        binding.tv2.setText(nombre2);
    }
}