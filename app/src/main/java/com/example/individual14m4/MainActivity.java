package com.example.individual14m4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import com.example.individual14m4.Pregunta;
import com.example.individual14m4.Fragmento2;

import com.example.individual14m4.databinding.ActivityMainBinding;
//Fijarse que la implementacion para fragmento sea igual en todas las clases
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private boolean semuestra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (semuestra) {
                    closeFragment();
                } else {
                    openFragment();
                }
            }
        });

        binding.bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSecondfragment("Roberto", "Medina");
            }
        });
    }


// se crean los métodos para abrir y cerrar

    private void openFragment() {
        //se instancia el fragmento:
        Pregunta pregunta = new Pregunta();
        //instancia fragmentmanager
        FragmentManager manager = getSupportFragmentManager();
        //hacer la transaccion
        FragmentTransaction transaction= manager.beginTransaction().replace(binding.fragmentContainerView2.getId(),
                pregunta,Pregunta.class.getSimpleName());
        transaction.commit();

        binding.open.setText("Cerrar");
        semuestra=true;


    }

    private void closeFragment() {
        FragmentManager manager= getSupportFragmentManager();
        Pregunta pregunta=(Pregunta) manager.findFragmentById(binding.fragmentContainerView2.getId());
        if (pregunta !=null){
            FragmentTransaction transaction= manager.beginTransaction();
            transaction.remove(pregunta).commit();
            binding.open.setText("Abrir");
            semuestra=false;
        }
    }


    public void openSecondfragment(String nombre1, String nombre2){
        Fragmento2 fragmento2= Fragmento2.newInstance(nombre1,nombre2);
        FragmentManager manager= getSupportFragmentManager();
        if (fragmento2 !=null){
            FragmentTransaction transaction= manager.beginTransaction().replace(binding.fragmentContainerView.getId(),
                    fragmento2,Fragmento2.class.getSimpleName());
            binding.open.setText("Cerrar");
            semuestra=false;
            transaction.commit();

        }
    }
}