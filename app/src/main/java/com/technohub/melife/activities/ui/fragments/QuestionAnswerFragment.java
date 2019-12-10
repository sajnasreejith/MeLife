package com.technohub.melife.activities.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.technohub.melife.R;
import com.technohub.melife.activities.classes.Constants;

import java.util.concurrent.TimeUnit;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link QuestionAnswerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionAnswerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String title,strSelected_ans;
    TextView pagetitle1,pagetitle2;
    TextView timer,Question,Qno;
    Button answera,answerb,answerc,answerd,answere,btnnext;
    View v;
    int flag=0;

//    private OnFragmentInteractionListener mListener;

    public QuestionAnswerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionAnswerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionAnswerFragment newInstance(String param1, String param2) {
        QuestionAnswerFragment fragment = new QuestionAnswerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(Constants.PAGETITLE_KEY);
            Log.e("qa title",title);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         v= inflater.inflate(R.layout.fragment_question_answer, container, false);
         initViews();
         v.setBackgroundColor(Color.WHITE);
         answera.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 buttonPress(v);
                 answera.setBackgroundResource(R.drawable.bluedrawable);
                 answerb.setBackgroundResource(R.drawable.button_filleddrawable);
                 answerc.setBackgroundResource(R.drawable.button_filleddrawable);
                 answerd.setBackgroundResource(R.drawable.button_filleddrawable);
                 answere.setBackgroundResource(R.drawable.button_filleddrawable);

             }
         });
        answerb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(v);
                answerb.setBackgroundResource(R.drawable.bluedrawable);
                answera.setBackgroundResource(R.drawable.button_filleddrawable);
                answerc.setBackgroundResource(R.drawable.button_filleddrawable);
                answerd.setBackgroundResource(R.drawable.button_filleddrawable);
                answere.setBackgroundResource(R.drawable.button_filleddrawable);
            }
        });
        answerc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(v);
                answerc.setBackgroundResource(R.drawable.bluedrawable);
                answera.setBackgroundResource(R.drawable.button_filleddrawable);;
                answerb.setBackgroundResource(R.drawable.button_filleddrawable);
                answerd.setBackgroundResource(R.drawable.button_filleddrawable);
                answere.setBackgroundResource(R.drawable.button_filleddrawable);
            }
        });
        answerd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(v);
                answerd.setBackgroundResource(R.drawable.bluedrawable);
                answerb.setBackgroundResource(R.drawable.button_filleddrawable);
                answerc.setBackgroundResource(R.drawable.button_filleddrawable);
                answera.setBackgroundResource(R.drawable.button_filleddrawable);
                answere.setBackgroundResource(R.drawable.button_filleddrawable);
            }
        });
        answere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(v);
                answere.setBackgroundResource(R.drawable.bluedrawable);
                answerb.setBackgroundResource(R.drawable.button_filleddrawable);
                answerc.setBackgroundResource(R.drawable.button_filleddrawable);
                answerd.setBackgroundResource(R.drawable.button_filleddrawable);
                answera.setBackgroundResource(R.drawable.button_filleddrawable);
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag++;
                Qno.setText(flag+"");
                setBackgroundColor_Button();
                if(flag<Constants.questions.length)
                {
                    Question.setText(Constants.questions[flag]);
                }
                else
                {
                    fun();
                }
            }
        });
         return v;
    }


        public void buttonPress(View v) {
        switch (v.getId()) {
            case R.id.answera:
              strSelected_ans=answera.getText().toString();
              Log.e("Answer",strSelected_ans);
                break;
            case R.id.answerb:
                strSelected_ans=answera.getText().toString();
                break;
            case R.id.answerc:
                strSelected_ans=answerc.getText().toString();
                break;
            case R.id.answerd:
                strSelected_ans=answerd.getText().toString();
                break;
            case R.id.answere:
                 strSelected_ans=answere.getText().toString();
                break;

        }}


    void fun()
    {
            // Create new fragment and transaction
            Fragment newFragment = new CelebrationFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack
            transaction.replace(R.id.qa_layout, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();

    }
    void setBackgroundColor_Button()
    {
        answere.setBackgroundResource(R.drawable.button_filleddrawable);
        answerb.setBackgroundResource(R.drawable.button_filleddrawable);
        answerc.setBackgroundResource(R.drawable.button_filleddrawable);
        answerd.setBackgroundResource(R.drawable.button_filleddrawable);
        answera.setBackgroundResource(R.drawable.button_filleddrawable);
    }
    void initViews()
    {
        timer=v.findViewById(R.id.timer);
        answera=v.findViewById(R.id.answera);
        answerb=v.findViewById(R.id.answerb);
        answerc=v.findViewById(R.id.answerc);
        answerd=v.findViewById(R.id.answerd);
        answere=v.findViewById(R.id.answere);
        pagetitle1=v.findViewById(R.id.title_qa1);
        pagetitle2=v.findViewById(R.id.title_qa2);
        btnnext=v.findViewById(R.id.btn_next);
        Question=v.findViewById(R.id.txtQuestion);
        Qno=v.findViewById(R.id.txtQno);
    }
    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onResume() {
        super.onResume();
        pagetitle1.setText(title);
        pagetitle2.setText(Constants.PAGETITLE_INTEREST);
        Question.setText(Constants.questions[flag]);
        Qno.setText(flag+1+" ");
        new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                timer.setText(""+ millisUntilFinished / 1000);
                long millis = millisUntilFinished;
                String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                timer.setText(hms);//set text
            }
            public void onFinish() {
                timer.setText("done!");
            }
        }.start();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }

    }
