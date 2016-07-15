package jc.com.gesschool;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import jc.com.gesschool.fragments.AgendaFragment;
import jc.com.gesschool.fragments.AsignaturaFragment;
import jc.com.gesschool.fragments.CalificacionesFragment;
import jc.com.gesschool.fragments.ProfesoresFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    ImageButton btnAsignatura,btnCalificaciones,btnAgenda,btnProfesores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(FRAGMENT_PROFESORES);
        btnAsignatura = (ImageButton) findViewById(R.id.btnAsignatura);
        btnAsignatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(FRAGMENT_ASIGNATURA);
            }
        });

        btnCalificaciones = (ImageButton) findViewById(R.id.btnCalificaciones);
        btnCalificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(FRAGMENT_CALIFICACIONES);
            }
        });

        btnAgenda = (ImageButton) findViewById(R.id.btnAgenda);
        btnAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(FRAGMENT_AGENDA);
            }
        });

        btnProfesores = (ImageButton) findViewById(R.id.btnProfesores);
        btnProfesores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(FRAGMENT_PROFESORES);
            }
        });
    }

    public static final int FRAGMENT_CALIFICACIONES = 1;
    public static final int FRAGMENT_AGENDA = 2;
    public static final int FRAGMENT_ASIGNATURA = 3;
    public static final int FRAGMENT_PROFESORES = 4;
    public void replaceFragment(int typeOfFragment) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fragment);
        frameLayout.setVisibility(View.VISIBLE);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (typeOfFragment) {
            case FRAGMENT_CALIFICACIONES:
                CalificacionesFragment calificacionesFragment = new CalificacionesFragment(MainActivity.this);
                fragmentTransaction.replace(R.id.fragment, calificacionesFragment);
//                PRINCIPAL = IUMAIN_HOME;
                break;
            case FRAGMENT_AGENDA:
                AgendaFragment agendaFragment= new AgendaFragment(MainActivity.this);
                fragmentTransaction.replace(R.id.fragment, agendaFragment);
                break;
            case FRAGMENT_ASIGNATURA:
                AsignaturaFragment asignaturaFragment = new AsignaturaFragment(MainActivity.this);
                fragmentTransaction.replace(R.id.fragment, asignaturaFragment);
                break;
            case FRAGMENT_PROFESORES:
                ProfesoresFragment profesoresFragment= new ProfesoresFragment(MainActivity.this);
                fragmentTransaction.replace(R.id.fragment, profesoresFragment);
                break;

        }
        fragmentTransaction.commit();
    }
}
