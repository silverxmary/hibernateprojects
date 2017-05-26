package com.eduit.clase1.clase1.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.eduit.clase1.clase1.R;

/**
 * Created by educacionit on 17/03/2017.
 */
public class FragmentUno extends Fragment{

    private Button buttonFragment;
    private int counter = 0;
    private FragmentListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragme_uno, container, false);
        buttonFragment = (Button)view.findViewById(R.id.button_fragment_uno);


        buttonFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                listener.count(counter);
            }
        });

        return view;

    }

    @Override
    public void onAttach(Activity activity) { // Usamos deprecado por compatiblidad con Android inferior a 5
        super.onAttach(activity);
        listener = (FragmentListener)activity;
    }
}
