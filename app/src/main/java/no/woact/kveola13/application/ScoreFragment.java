package no.woact.kveola13.application;


import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.TextView;

import no.woact.kveola13.R;


public class ScoreFragment extends Fragment {


    public ScoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_score, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initChrono();

        TextView player1Name = view.findViewById(R.id.player1Name);
        String firstName = (getActivity().getIntent().getStringExtra("player1Name"));


        if (firstName.length() <= 5){
            player1Name.setTextSize(25);
        }
        if (firstName.length() > 8){
            player1Name.setTextSize(15);
        }
        if (firstName.length() >= 12){
            player1Name.setTextSize(12);
        }
        player1Name.setText(firstName);

        TextView player2Name = view.findViewById(R.id.player2Name);
        String secondName = (getActivity().getIntent().getStringExtra("player2Name"));
        if (secondName.length() <= 5){
            player2Name.setTextSize(25);
        }
        if (secondName.length() > 8){
            player2Name.setTextSize(15);
        }
        if (secondName.length() >= 12){
            player2Name.setTextSize(12);
        }
        player2Name.setText(secondName);
    }
    public void initChrono() {
        Chronometer chronometer = getView().findViewById(R.id.timer);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
    }
//    public void stopChrono(){
//        Chronometer chronometer = getView().findViewById(R.id.timer);
//        chronometer.stop();
//    }
}
