package no.woact.kveola13.application;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import no.woact.kveola13.R;


public class SinglePlayerGameFragment extends Fragment {

    public boolean player1Turn = true;
    public boolean player1ClickedButton1 = false;
    public boolean player1ClickedButton2 = false;
    public boolean player1ClickedButton3 = false;
    public boolean player1ClickedButton4 = false;
    public boolean player1ClickedButton5 = false;
    public boolean player1ClickedButton6 = false;
    public boolean player1ClickedButton7 = false;
    public boolean player1ClickedButton8 = false;
    public boolean player1ClickedButton9 = false;
    public boolean player2ClickedButton1 = false;
    public boolean player2ClickedButton2 = false;
    public boolean player2ClickedButton3 = false;
    public boolean player2ClickedButton4 = false;
    public boolean player2ClickedButton5 = false;
    public boolean player2ClickedButton6 = false;
    public boolean player2ClickedButton7 = false;
    public boolean player2ClickedButton8 = false;
    public boolean player2ClickedButton9 = false;

    public SinglePlayerGameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView
            (LayoutInflater inflater,
             ViewGroup container,
             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_single_player_game, container, false);
        //Passing this outside of this scope causes null object reference
        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                initAllGameButtons();
            }
        });
        thread.start();
    }

    public void initAllGameButtons() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                initGameButtonOne();
                initGameButtonTwo();
                initGameButtonThree();
                initGameButtonFour();
                initGameButtonFive();
                initGameButtonSix();
                initGameButtonSeven();
                initGameButtonEight();
                initGameButtonNine();
            }
        });
        thread.start();
    }

    private void checkPlayer1WinCondition() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (player1ClickedButton1 && player1ClickedButton2 && player1ClickedButton3) {
                    goToPlayer1WinScreen(getView());
                } else if (player1ClickedButton4 && player1ClickedButton5 && player1ClickedButton6) {
                    goToPlayer1WinScreen(getView());
                } else if (player1ClickedButton7 && player1ClickedButton8 && player1ClickedButton9) {
                    goToPlayer1WinScreen(getView());
                } else if (player1ClickedButton1 && player1ClickedButton4 && player1ClickedButton7) {
                    goToPlayer1WinScreen(getView());
                } else if (player1ClickedButton2 && player1ClickedButton5 && player1ClickedButton8) {
                    goToPlayer1WinScreen(getView());
                } else if (player1ClickedButton3 && player1ClickedButton6 && player1ClickedButton9) {
                    goToPlayer1WinScreen(getView());
                } else if (player1ClickedButton1 && player1ClickedButton5 && player1ClickedButton9) {
                    goToPlayer1WinScreen(getView());
                } else if (player1ClickedButton3 && player1ClickedButton5 && player1ClickedButton7) {
                    goToPlayer1WinScreen(getView());
                }
            }
        });
        thread.start();
    }

    private void checkPlayer2WinCondition() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (player2ClickedButton1 && player2ClickedButton2 && player2ClickedButton3) {
                    goToPlayer2WinScreen(getView());
                } else if (player2ClickedButton4 && player2ClickedButton5 && player2ClickedButton6) {
                    goToPlayer2WinScreen(getView());
                } else if (player2ClickedButton7 && player2ClickedButton8 && player2ClickedButton9) {
                    goToPlayer2WinScreen(getView());
                } else if (player2ClickedButton1 && player2ClickedButton4 && player2ClickedButton7) {
                    goToPlayer2WinScreen(getView());
                } else if (player2ClickedButton2 && player2ClickedButton5 && player2ClickedButton8) {
                    goToPlayer2WinScreen(getView());
                } else if (player2ClickedButton3 && player2ClickedButton6 && player2ClickedButton9) {
                    goToPlayer2WinScreen(getView());
                } else if (player2ClickedButton1 && player2ClickedButton5 && player2ClickedButton9) {
                    goToPlayer2WinScreen(getView());
                } else if (player2ClickedButton3 && player2ClickedButton5 && player2ClickedButton7) {
                    goToPlayer2WinScreen(getView());
                }
            }
        });
        thread.start();
    }

    public void goToPlayer1WinScreen(View view) {
//        ScoreFragment scoreFragment = new ScoreFragment();
//        scoreFragment.initChrono();
//        scoreFragment.stopChrono();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String firstName = getActivity().getIntent().getStringExtra("player1Name");
                String secondName = getActivity().getIntent().getStringExtra("player2Name");

                Intent intent = new Intent(getActivity(), Player1WinScreen.class);
                intent.putExtra("player1Name", firstName);
                intent.putExtra("player2Name", secondName);
                startActivity(intent);
            }
        });
        thread.start();
    }

    public void goToPlayer2WinScreen(View view) {
//        ScoreFragment scoreFragment = new ScoreFragment();
//        scoreFragment.initChrono();
//        scoreFragment.stopChrono();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String firstName = getActivity().getIntent().getStringExtra("player1Name");
                String secondName = getActivity().getIntent().getStringExtra("player2Name");

                Intent intent = new Intent(getActivity(), Player2WinScreen.class);
                intent.putExtra("player1Name", firstName);
                intent.putExtra("player2Name", secondName);
                startActivity(intent);
            }
        });
        thread.start();
    }

    public void goToPlayerDrawScreen(View view) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String firstName = getActivity().getIntent().getStringExtra("player1Name");
                String secondName = getActivity().getIntent().getStringExtra("player2Name");
                Intent intent = new Intent(getActivity(), PlayerDrawScreen.class);
                intent.putExtra("player1Name", firstName);
                intent.putExtra("player2Name", secondName);
                startActivity(intent);
            }
        });
        thread.start();
    }

    public void initGameButtonOne() {
        final ImageButton gameButton1 = getView().findViewById(R.id.singlePlayerButton1);
        final ImageButton gameButton2 = getView().findViewById(R.id.singlePlayerButton2);
        final ImageButton gameButton3 = getView().findViewById(R.id.singlePlayerButton3);
        final ImageButton gameButton4 = getView().findViewById(R.id.singlePlayerButton4);
        final ImageButton gameButton5 = getView().findViewById(R.id.singlePlayerButton5);
        final ImageButton gameButton6 = getView().findViewById(R.id.singlePlayerButton6);
        final ImageButton gameButton7 = getView().findViewById(R.id.singlePlayerButton7);
        final ImageButton gameButton8 = getView().findViewById(R.id.singlePlayerButton8);
        final ImageButton gameButton9 = getView().findViewById(R.id.singlePlayerButton9);
        gameButton1.getBackground().setAlpha(0);
        gameButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn) {
                    gameButton1.setBackgroundResource(R.drawable.gameobutton);
                    gameButton1.getLayoutParams().height = 300;
                    gameButton1.getLayoutParams().width = 300;
                    gameButton1.getBackground().setAlpha(255);
                    gameButton1.setClickable(false);
                    player1Turn = !player1Turn;
                    player1ClickedButton1 = true;
                    if (!gameButton1.isClickable() &&
                            !gameButton2.isClickable() &&
                            !gameButton3.isClickable() &&
                            !gameButton4.isClickable() &&
                            !gameButton5.isClickable() &&
                            !gameButton6.isClickable() &&
                            !gameButton7.isClickable() &&
                            !gameButton8.isClickable() &&
                            !gameButton9.isClickable()) {
                        goToPlayerDrawScreen(getView());
                    }
                    checkPlayer1WinCondition();
                    if (player1ClickedButton1 && player1ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton1 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton2 && player1ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton1 && player1ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player1ClickedButton1 && player1ClickedButton4 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton4 && player1ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton2 && player1ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton2 && player1ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton3 && player1ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton3 && player1ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton6 && player1ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton4 && player1ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton4 && player1ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton7 && player1ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton8 && player1ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player1ClickedButton7 && player1ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton1 && player1ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton5 && player1ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton3 && player1ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton3 && player1ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton7 && player2ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton8 && player2ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton1 && player2ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton5 && player2ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton3 && player2ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (gameButton8.isClickable()) {
                        robotClickButtonEight();
                    }
                }
            }
        });
    }

    public void initGameButtonTwo() {
        final ImageButton gameButton1 = getView().findViewById(R.id.singlePlayerButton1);
        final ImageButton gameButton2 = getView().findViewById(R.id.singlePlayerButton2);
        final ImageButton gameButton3 = getView().findViewById(R.id.singlePlayerButton3);
        final ImageButton gameButton4 = getView().findViewById(R.id.singlePlayerButton4);
        final ImageButton gameButton5 = getView().findViewById(R.id.singlePlayerButton5);
        final ImageButton gameButton6 = getView().findViewById(R.id.singlePlayerButton6);
        final ImageButton gameButton7 = getView().findViewById(R.id.singlePlayerButton7);
        final ImageButton gameButton8 = getView().findViewById(R.id.singlePlayerButton8);
        final ImageButton gameButton9 = getView().findViewById(R.id.singlePlayerButton9);
        gameButton2.getBackground().setAlpha(0);
        gameButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn) {
                    gameButton2.setBackgroundResource(R.drawable.gameobutton);
                    gameButton2.getLayoutParams().height = 300;
                    gameButton2.getLayoutParams().width = 300;
                    gameButton2.getBackground().setAlpha(255);
                    gameButton2.setClickable(false);
                    player1Turn = !player1Turn;
                    player1ClickedButton2 = true;
                    if (!gameButton1.isClickable() &&
                            !gameButton2.isClickable() &&
                            !gameButton3.isClickable() &&
                            !gameButton4.isClickable() &&
                            !gameButton5.isClickable() &&
                            !gameButton6.isClickable() &&
                            !gameButton7.isClickable() &&
                            !gameButton8.isClickable() &&
                            !gameButton9.isClickable()) {
                        goToPlayerDrawScreen(getView());
                    }
                    checkPlayer1WinCondition();
                    if (player1ClickedButton1 && player1ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton1 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton2 && player1ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton1 && player1ClickedButton4 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton1 && player1ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player1ClickedButton4 && player1ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton2 && player1ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton2 && player1ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton3 && player1ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton3 && player1ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton6 && player1ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton4 && player1ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton4 && player1ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton7 && player1ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton8 && player1ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player1ClickedButton7 && player1ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton1 && player1ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton5 && player1ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton3 && player1ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton3 && player1ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton7 && player2ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton8 && player2ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton1 && player2ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton5 && player2ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton3 && player2ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (gameButton8.isClickable()) {
                        robotClickButtonEight();
                    }
                }
            }
        });
    }

    public void initGameButtonThree() {
        final ImageButton gameButton1 = getView().findViewById(R.id.singlePlayerButton1);
        final ImageButton gameButton2 = getView().findViewById(R.id.singlePlayerButton2);
        final ImageButton gameButton3 = getView().findViewById(R.id.singlePlayerButton3);
        final ImageButton gameButton4 = getView().findViewById(R.id.singlePlayerButton4);
        final ImageButton gameButton5 = getView().findViewById(R.id.singlePlayerButton5);
        final ImageButton gameButton6 = getView().findViewById(R.id.singlePlayerButton6);
        final ImageButton gameButton7 = getView().findViewById(R.id.singlePlayerButton7);
        final ImageButton gameButton8 = getView().findViewById(R.id.singlePlayerButton8);
        final ImageButton gameButton9 = getView().findViewById(R.id.singlePlayerButton9);
        gameButton3.getBackground().setAlpha(0);
        gameButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn) {
                    gameButton3.setBackgroundResource(R.drawable.gameobutton);
                    gameButton3.getLayoutParams().height = 300;
                    gameButton3.getLayoutParams().width = 300;
                    gameButton3.getBackground().setAlpha(255);
                    gameButton3.setClickable(false);
                    player1Turn = !player1Turn;
                    player1ClickedButton3 = true;
                    if (!gameButton1.isClickable() &&
                            !gameButton2.isClickable() &&
                            !gameButton3.isClickable() &&
                            !gameButton4.isClickable() &&
                            !gameButton5.isClickable() &&
                            !gameButton6.isClickable() &&
                            !gameButton7.isClickable() &&
                            !gameButton8.isClickable() &&
                            !gameButton9.isClickable()) {
                        goToPlayerDrawScreen(getView());
                    }
                    checkPlayer1WinCondition();
                    if (player1ClickedButton1 && player1ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton1 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton2 && player1ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton1 && player1ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player1ClickedButton1 && player1ClickedButton4 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton4 && player1ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton2 && player1ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton2 && player1ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton3 && player1ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton3 && player1ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton6 && player1ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton4 && player1ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton4 && player1ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton7 && player1ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton8 && player1ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player1ClickedButton7 && player1ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton1 && player1ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton5 && player1ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton3 && player1ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton3 && player1ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton7 && player2ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton8 && player2ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton1 && player2ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton5 && player2ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton3 && player2ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (gameButton8.isClickable()) {
                        robotClickButtonEight();
                    }
                }
            }
        });
    }

    public void initGameButtonFour() {
        final ImageButton gameButton1 = getView().findViewById(R.id.singlePlayerButton1);
        final ImageButton gameButton2 = getView().findViewById(R.id.singlePlayerButton2);
        final ImageButton gameButton3 = getView().findViewById(R.id.singlePlayerButton3);
        final ImageButton gameButton4 = getView().findViewById(R.id.singlePlayerButton4);
        final ImageButton gameButton5 = getView().findViewById(R.id.singlePlayerButton5);
        final ImageButton gameButton6 = getView().findViewById(R.id.singlePlayerButton6);
        final ImageButton gameButton7 = getView().findViewById(R.id.singlePlayerButton7);
        final ImageButton gameButton8 = getView().findViewById(R.id.singlePlayerButton8);
        final ImageButton gameButton9 = getView().findViewById(R.id.singlePlayerButton9);
        gameButton4.getBackground().setAlpha(0);
        gameButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn) {
                    gameButton4.setBackgroundResource(R.drawable.gameobutton);
                    gameButton4.getLayoutParams().height = 300;
                    gameButton4.getLayoutParams().width = 300;
                    gameButton4.getBackground().setAlpha(255);
                    gameButton4.setClickable(false);
                    player1Turn = !player1Turn;
                    player1ClickedButton4 = true;
                    if (!gameButton1.isClickable() &&
                            !gameButton2.isClickable() &&
                            !gameButton3.isClickable() &&
                            !gameButton4.isClickable() &&
                            !gameButton5.isClickable() &&
                            !gameButton6.isClickable() &&
                            !gameButton7.isClickable() &&
                            !gameButton8.isClickable() &&
                            !gameButton9.isClickable()) {
                        goToPlayerDrawScreen(getView());
                    }
                    checkPlayer1WinCondition();
                    if (player1ClickedButton1 && player1ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton1 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton2 && player1ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton1 && player1ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player1ClickedButton1 && player1ClickedButton4 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton4 && player1ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton2 && player1ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton2 && player1ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton3 && player1ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton3 && player1ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton6 && player1ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton4 && player1ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton4 && player1ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton7 && player1ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton8 && player1ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player1ClickedButton7 && player1ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton1 && player1ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton5 && player1ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton3 && player1ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton3 && player1ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton7 && player2ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton8 && player2ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton1 && player2ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton5 && player2ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton3 && player2ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (gameButton8.isClickable()) {
                        robotClickButtonEight();
                    }
                }
            }
        });
    }

    public void initGameButtonFive() {
        final ImageButton gameButton1 = getView().findViewById(R.id.singlePlayerButton1);
        final ImageButton gameButton2 = getView().findViewById(R.id.singlePlayerButton2);
        final ImageButton gameButton3 = getView().findViewById(R.id.singlePlayerButton3);
        final ImageButton gameButton4 = getView().findViewById(R.id.singlePlayerButton4);
        final ImageButton gameButton5 = getView().findViewById(R.id.singlePlayerButton5);
        final ImageButton gameButton6 = getView().findViewById(R.id.singlePlayerButton6);
        final ImageButton gameButton7 = getView().findViewById(R.id.singlePlayerButton7);
        final ImageButton gameButton8 = getView().findViewById(R.id.singlePlayerButton8);
        final ImageButton gameButton9 = getView().findViewById(R.id.singlePlayerButton9);
        gameButton5.getBackground().setAlpha(0);
        gameButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn) {
                    gameButton5.setBackgroundResource(R.drawable.gameobutton);
                    gameButton5.getLayoutParams().height = 300;
                    gameButton5.getLayoutParams().width = 300;
                    gameButton5.getBackground().setAlpha(255);
                    gameButton5.setClickable(false);
                    player1Turn = !player1Turn;
                    player1ClickedButton5 = true;
                    if (!gameButton1.isClickable() &&
                            !gameButton2.isClickable() &&
                            !gameButton3.isClickable() &&
                            !gameButton4.isClickable() &&
                            !gameButton5.isClickable() &&
                            !gameButton6.isClickable() &&
                            !gameButton7.isClickable() &&
                            !gameButton8.isClickable() &&
                            !gameButton9.isClickable()) {
                        goToPlayerDrawScreen(getView());
                    }
                    checkPlayer1WinCondition();
                    if (player1ClickedButton1 && player1ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton1 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton2 && player1ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton1 && player1ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();

                    } else if (player1ClickedButton1 && player1ClickedButton4 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton4 && player1ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton2 && player1ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton2 && player1ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton3 && player1ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton3 && player1ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton6 && player1ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton4 && player1ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton4 && player1ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton7 && player1ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton8 && player1ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player1ClickedButton7 && player1ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton1 && player1ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton5 && player1ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton3 && player1ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton3 && player1ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton7 && player2ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton8 && player2ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton1 && player2ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton5 && player2ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton3 && player2ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (gameButton8.isClickable()) {
                        robotClickButtonEight();
                    }
                }
            }
        });
    }

    public void initGameButtonSix() {
        final ImageButton gameButton1 = getView().findViewById(R.id.singlePlayerButton1);
        final ImageButton gameButton2 = getView().findViewById(R.id.singlePlayerButton2);
        final ImageButton gameButton3 = getView().findViewById(R.id.singlePlayerButton3);
        final ImageButton gameButton4 = getView().findViewById(R.id.singlePlayerButton4);
        final ImageButton gameButton5 = getView().findViewById(R.id.singlePlayerButton5);
        final ImageButton gameButton6 = getView().findViewById(R.id.singlePlayerButton6);
        final ImageButton gameButton7 = getView().findViewById(R.id.singlePlayerButton7);
        final ImageButton gameButton8 = getView().findViewById(R.id.singlePlayerButton8);
        final ImageButton gameButton9 = getView().findViewById(R.id.singlePlayerButton9);
        gameButton6.getBackground().setAlpha(0);
        gameButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn) {
                    gameButton6.setBackgroundResource(R.drawable.gameobutton);
                    gameButton6.getLayoutParams().height = 300;
                    gameButton6.getLayoutParams().width = 300;
                    gameButton6.getBackground().setAlpha(255);
                    gameButton6.setClickable(false);
                    player1Turn = !player1Turn;
                    player1ClickedButton6 = true;
                    if (!gameButton1.isClickable() &&
                            !gameButton2.isClickable() &&
                            !gameButton3.isClickable() &&
                            !gameButton4.isClickable() &&
                            !gameButton5.isClickable() &&
                            !gameButton6.isClickable() &&
                            !gameButton7.isClickable() &&
                            !gameButton8.isClickable() &&
                            !gameButton9.isClickable()) {
                        goToPlayerDrawScreen(getView());
                    }
                    checkPlayer1WinCondition();
                    if (player1ClickedButton1 && player1ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton1 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton2 && player1ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton1 && player1ClickedButton4 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton1 && player1ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player1ClickedButton4 && player1ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton2 && player1ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton2 && player1ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton3 && player1ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton3 && player1ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton6 && player1ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton4 && player1ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton4 && player1ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton7 && player1ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton8 && player1ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player1ClickedButton7 && player1ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton1 && player1ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton5 && player1ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton3 && player1ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton3 && player1ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton7 && player2ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton8 && player2ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton1 && player2ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton5 && player2ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton3 && player2ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (gameButton8.isClickable()) {
                        robotClickButtonEight();
                    }
                }
            }
        });
    }

    public void initGameButtonSeven() {
        final ImageButton gameButton1 = getView().findViewById(R.id.singlePlayerButton1);
        final ImageButton gameButton2 = getView().findViewById(R.id.singlePlayerButton2);
        final ImageButton gameButton3 = getView().findViewById(R.id.singlePlayerButton3);
        final ImageButton gameButton4 = getView().findViewById(R.id.singlePlayerButton4);
        final ImageButton gameButton5 = getView().findViewById(R.id.singlePlayerButton5);
        final ImageButton gameButton6 = getView().findViewById(R.id.singlePlayerButton6);
        final ImageButton gameButton7 = getView().findViewById(R.id.singlePlayerButton7);
        final ImageButton gameButton8 = getView().findViewById(R.id.singlePlayerButton8);
        final ImageButton gameButton9 = getView().findViewById(R.id.singlePlayerButton9);
        gameButton7.getBackground().setAlpha(0);
        gameButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn) {
                    gameButton7.setBackgroundResource(R.drawable.gameobutton);
                    gameButton7.getLayoutParams().height = 300;
                    gameButton7.getLayoutParams().width = 300;
                    gameButton7.getBackground().setAlpha(255);
                    gameButton7.setClickable(false);
                    player1Turn = !player1Turn;
                    player1ClickedButton7 = true;
                    if (!gameButton1.isClickable() &&
                            !gameButton2.isClickable() &&
                            !gameButton3.isClickable() &&
                            !gameButton4.isClickable() &&
                            !gameButton5.isClickable() &&
                            !gameButton6.isClickable() &&
                            !gameButton7.isClickable() &&
                            !gameButton8.isClickable() &&
                            !gameButton9.isClickable()) {
                        goToPlayerDrawScreen(getView());
                    }
                    checkPlayer1WinCondition();
                    if (player1ClickedButton1 && player1ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton1 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton2 && player1ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton1 && player1ClickedButton4 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton1 && player1ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player1ClickedButton4 && player1ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton2 && player1ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton2 && player1ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton3 && player1ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton3 && player1ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton6 && player1ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton4 && player1ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton4 && player1ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton7 && player1ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton8 && player1ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player1ClickedButton7 && player1ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton1 && player1ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton5 && player1ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton3 && player1ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton3 && player1ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton7 && player2ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton8 && player2ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton1 && player2ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton5 && player2ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton3 && player2ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (gameButton8.isClickable()) {
                        robotClickButtonEight();
                    }
                }
            }
        });
    }

    public void initGameButtonEight() {
        final ImageButton gameButton1 = getView().findViewById(R.id.singlePlayerButton1);
        final ImageButton gameButton2 = getView().findViewById(R.id.singlePlayerButton2);
        final ImageButton gameButton3 = getView().findViewById(R.id.singlePlayerButton3);
        final ImageButton gameButton4 = getView().findViewById(R.id.singlePlayerButton4);
        final ImageButton gameButton5 = getView().findViewById(R.id.singlePlayerButton5);
        final ImageButton gameButton6 = getView().findViewById(R.id.singlePlayerButton6);
        final ImageButton gameButton7 = getView().findViewById(R.id.singlePlayerButton7);
        final ImageButton gameButton8 = getView().findViewById(R.id.singlePlayerButton8);
        final ImageButton gameButton9 = getView().findViewById(R.id.singlePlayerButton9);
        gameButton8.getBackground().setAlpha(0);
        gameButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn) {
                    gameButton8.setBackgroundResource(R.drawable.gameobutton);
                    gameButton8.getLayoutParams().height = 300;
                    gameButton8.getLayoutParams().width = 300;
                    gameButton8.getBackground().setAlpha(255);
                    gameButton8.setClickable(false);
                    player1Turn = !player1Turn;
                    player1ClickedButton8 = true;
                    if (!gameButton1.isClickable() &&
                            !gameButton2.isClickable() &&
                            !gameButton3.isClickable() &&
                            !gameButton4.isClickable() &&
                            !gameButton5.isClickable() &&
                            !gameButton6.isClickable() &&
                            !gameButton7.isClickable() &&
                            !gameButton8.isClickable() &&
                            !gameButton9.isClickable()) {
                        goToPlayerDrawScreen(getView());
                    }
                    checkPlayer1WinCondition();
                    if (player1ClickedButton1 && player1ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton1 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton2 && player1ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton1 && player1ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player1ClickedButton1 && player1ClickedButton4 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton4 && player1ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton2 && player1ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton2 && player1ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton3 && player1ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton3 && player1ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton6 && player1ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton4 && player1ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton4 && player1ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton7 && player1ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton8 && player1ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player1ClickedButton7 && player1ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton1 && player1ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton5 && player1ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton3 && player1ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton3 && player1ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton7 && player2ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton8 && player2ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton1 && player2ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton5 && player2ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton3 && player2ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (gameButton1.isClickable()) {
                        robotClickButtonOne();
                    }
                }
            }
        });
    }

    public void initGameButtonNine() {
        final ImageButton gameButton1 = getView().findViewById(R.id.singlePlayerButton1);
        final ImageButton gameButton2 = getView().findViewById(R.id.singlePlayerButton2);
        final ImageButton gameButton3 = getView().findViewById(R.id.singlePlayerButton3);
        final ImageButton gameButton4 = getView().findViewById(R.id.singlePlayerButton4);
        final ImageButton gameButton5 = getView().findViewById(R.id.singlePlayerButton5);
        final ImageButton gameButton6 = getView().findViewById(R.id.singlePlayerButton6);
        final ImageButton gameButton7 = getView().findViewById(R.id.singlePlayerButton7);
        final ImageButton gameButton8 = getView().findViewById(R.id.singlePlayerButton8);
        final ImageButton gameButton9 = getView().findViewById(R.id.singlePlayerButton9);
        gameButton9.getBackground().setAlpha(0);
        gameButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn) {
                    gameButton9.setBackgroundResource(R.drawable.gameobutton);
                    gameButton9.getLayoutParams().height = 300;
                    gameButton9.getLayoutParams().width = 300;
                    gameButton9.getBackground().setAlpha(255);
                    gameButton9.setClickable(false);
                    player1Turn = !player1Turn;
                    player1ClickedButton9 = true;
                    if (!gameButton1.isClickable() &&
                            !gameButton2.isClickable() &&
                            !gameButton3.isClickable() &&
                            !gameButton4.isClickable() &&
                            !gameButton5.isClickable() &&
                            !gameButton6.isClickable() &&
                            !gameButton7.isClickable() &&
                            !gameButton8.isClickable() &&
                            !gameButton9.isClickable()) {
                        goToPlayerDrawScreen(getView());
                    }
                    checkPlayer1WinCondition();
                    if (player1ClickedButton1 && player1ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton1 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton2 && player1ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton1 && player1ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player1ClickedButton1 && player1ClickedButton4 && player1ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton4 && player1ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton2 && player1ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton2 && player1ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player1ClickedButton3 && player1ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton3 && player1ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton6 && player1ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton4 && player1ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player1ClickedButton4 && player1ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player1ClickedButton7 && player1ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton8 && player1ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player1ClickedButton7 && player1ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player1ClickedButton1 && player1ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player1ClickedButton5 && player1ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player1ClickedButton1 && player1ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton3 && player1ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player1ClickedButton5 && player1ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player1ClickedButton3 && player1ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton1 && player2ClickedButton2 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton2 && player2ClickedButton3 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton3 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton1 && player2ClickedButton4 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton4 && player2ClickedButton7 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton7 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton2 && player2ClickedButton5 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton2 && player2ClickedButton8 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton8 && gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (player2ClickedButton3 && player2ClickedButton6 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton3 && player2ClickedButton9 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton6 && player2ClickedButton9 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton4 && player2ClickedButton5 && gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (player2ClickedButton4 && player2ClickedButton6 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton6 && gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (player2ClickedButton7 && player2ClickedButton8 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton8 && player2ClickedButton9 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (player2ClickedButton7 && player2ClickedButton9 && gameButton8.isClickable()) {
                        robotClickButtonEight();
                    } else if (player2ClickedButton1 && player2ClickedButton5 && gameButton9.isClickable()) {
                        robotClickButtonNine();
                    } else if (player2ClickedButton5 && player2ClickedButton9 && gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (player2ClickedButton1 && player2ClickedButton9 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton3 && player2ClickedButton7 && gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (player2ClickedButton5 && player2ClickedButton7 && gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (player2ClickedButton3 && player2ClickedButton5 && gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (gameButton5.isClickable()) {
                        robotClickButtonFive();
                    } else if (gameButton1.isClickable()) {
                        robotClickButtonOne();
                    } else if (gameButton7.isClickable()) {
                        robotClickButtonSeven();
                    } else if (gameButton3.isClickable()) {
                        robotClickButtonThree();
                    } else if (gameButton4.isClickable()) {
                        robotClickButtonFour();
                    } else if (gameButton6.isClickable()) {
                        robotClickButtonSix();
                    } else if (gameButton2.isClickable()) {
                        robotClickButtonTwo();
                    } else if (gameButton8.isClickable()) {
                        robotClickButtonEight();
                    }
                }
            }
        });
    }

    public void robotClickButtonOne() {
        final ImageButton gameButton1 = getView().findViewById(R.id.singlePlayerButton1);

        if (gameButton1.isClickable()) {
            gameButton1.setBackgroundResource(R.drawable.gamexbutton);
            gameButton1.getLayoutParams().height = 300;
            gameButton1.getLayoutParams().width = 300;
            gameButton1.getBackground().setAlpha(255);
            gameButton1.setClickable(false);
            player1Turn = !player1Turn;
            player2ClickedButton1 = true;
            checkPlayer2WinCondition();
        }
    }

    public void robotClickButtonTwo() {
        final ImageButton gameButton2 = getView().findViewById(R.id.singlePlayerButton2);

        if (gameButton2.isClickable()) {
            gameButton2.setBackgroundResource(R.drawable.gamexbutton);
            gameButton2.getLayoutParams().height = 300;
            gameButton2.getLayoutParams().width = 300;
            gameButton2.getBackground().setAlpha(255);
            gameButton2.setClickable(false);
            player1Turn = !player1Turn;
            player2ClickedButton2 = true;
            checkPlayer2WinCondition();
        }
    }

    public void robotClickButtonThree() {
        final ImageButton gameButton3 = getView().findViewById(R.id.singlePlayerButton3);

        if (gameButton3.isClickable()) {
            gameButton3.setBackgroundResource(R.drawable.gamexbutton);
            gameButton3.getLayoutParams().height = 300;
            gameButton3.getLayoutParams().width = 300;
            gameButton3.getBackground().setAlpha(255);
            gameButton3.setClickable(false);
            player1Turn = !player1Turn;
            player2ClickedButton3 = true;
            checkPlayer2WinCondition();
        }
    }

    public void robotClickButtonFour() {
        final ImageButton gameButton4 = getView().findViewById(R.id.singlePlayerButton4);

        if (gameButton4.isClickable()) {
            gameButton4.setBackgroundResource(R.drawable.gamexbutton);
            gameButton4.getLayoutParams().height = 300;
            gameButton4.getLayoutParams().width = 300;
            gameButton4.getBackground().setAlpha(255);
            gameButton4.setClickable(false);
            player1Turn = !player1Turn;
            player2ClickedButton4 = true;
            checkPlayer2WinCondition();
        }
    }

    public void robotClickButtonFive() {
        final ImageButton gameButton5 = getView().findViewById(R.id.singlePlayerButton5);

        if (gameButton5.isClickable()) {
            gameButton5.setBackgroundResource(R.drawable.gamexbutton);
            gameButton5.getLayoutParams().height = 300;
            gameButton5.getLayoutParams().width = 300;
            gameButton5.getBackground().setAlpha(255);
            gameButton5.setClickable(false);
            player1Turn = !player1Turn;
            player2ClickedButton5 = true;
            checkPlayer2WinCondition();
        }
    }

    public void robotClickButtonSix() {
        final ImageButton gameButton6 = getView().findViewById(R.id.singlePlayerButton6);

        if (gameButton6.isClickable()) {
            gameButton6.setBackgroundResource(R.drawable.gamexbutton);
            gameButton6.getLayoutParams().height = 300;
            gameButton6.getLayoutParams().width = 300;
            gameButton6.getBackground().setAlpha(255);
            gameButton6.setClickable(false);
            player1Turn = !player1Turn;
            player2ClickedButton6 = true;
            checkPlayer2WinCondition();
        }
    }

    public void robotClickButtonSeven() {
        final ImageButton gameButton7 = getView().findViewById(R.id.singlePlayerButton7);

        if (gameButton7.isClickable()) {
            gameButton7.setBackgroundResource(R.drawable.gamexbutton);
            gameButton7.getLayoutParams().height = 300;
            gameButton7.getLayoutParams().width = 300;
            gameButton7.getBackground().setAlpha(255);
            gameButton7.setClickable(false);
            player1Turn = !player1Turn;
            player2ClickedButton7 = true;
            checkPlayer2WinCondition();
        }
    }

    public void robotClickButtonEight() {
        final ImageButton gameButton8 = getView().findViewById(R.id.singlePlayerButton8);

        if (gameButton8.isClickable()) {
            gameButton8.setBackgroundResource(R.drawable.gamexbutton);
            gameButton8.getLayoutParams().height = 300;
            gameButton8.getLayoutParams().width = 300;
            gameButton8.getBackground().setAlpha(255);
            gameButton8.setClickable(false);
            player1Turn = !player1Turn;
            player2ClickedButton8 = true;
            checkPlayer2WinCondition();
        }
    }

    public void robotClickButtonNine() {
        final ImageButton gameButton9 = getView().findViewById(R.id.singlePlayerButton9);

        if (gameButton9.isClickable()) {
            gameButton9.setBackgroundResource(R.drawable.gamexbutton);
            gameButton9.getLayoutParams().height = 300;
            gameButton9.getLayoutParams().width = 300;
            gameButton9.getBackground().setAlpha(255);
            gameButton9.setClickable(false);
            player1Turn = !player1Turn;
            player2ClickedButton9 = true;
            checkPlayer2WinCondition();
        }
    }
}

