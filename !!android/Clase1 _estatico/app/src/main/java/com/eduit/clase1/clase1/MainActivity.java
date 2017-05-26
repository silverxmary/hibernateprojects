package com.eduit.clase1.clase1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eduit.clase1.clase1.fragment.FragmentDos;
import com.eduit.clase1.clase1.fragment.FragmentListener;

public class MainActivity extends AppCompatActivity implements FragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void count(int number) {
        FragmentDos fd = (FragmentDos)getFragmentManager().findFragmentById(R.id.fragment_dos);
        if(fd != null){
            fd.setText(String.valueOf(number));
        }
    }
}
