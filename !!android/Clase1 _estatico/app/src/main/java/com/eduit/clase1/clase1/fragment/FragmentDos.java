package com.eduit.clase1.clase1.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eduit.clase1.clase1.R;

/**
 * Created by educacionit on 17/03/2017.
 */
public class FragmentDos extends Fragment {

    private TextView textViewFragmentDos;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragme_dos, container, false);

        textViewFragmentDos = (TextView)view.findViewById(R.id.txtFragmeDos);


        return view;
    }

    public void setText(String text){

        textViewFragmentDos.setText(text);

    }

}
