package com.technohub.melife.activities.ui.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.CountDownTimer;
import android.util.Log;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.skydoves.elasticviews.ElasticButton;
import com.technohub.melife.R;
import com.technohub.melife.activities.classes.Constants;
import com.technohub.melife.activities.classes.MyBloomListener;
import com.technohub.melife.activities.ui.home.HomeFragment;

import java.util.concurrent.TimeUnit;

import me.samlss.bloom.Bloom;
import me.samlss.bloom.effector.BloomEffector;
import me.samlss.bloom.listener.BloomListener;
import me.samlss.bloom.particle.BloomParticle;
import me.samlss.bloom.shape.ParticleShape;
import me.samlss.bloom.shape.distributor.ParticleShapeDistributor;
import me.samlss.bloom.shape.distributor.RectShapeDistributor;
import me.samlss.bloom.shape.distributor.StarShapeDistributor;
import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;

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
//    TextView pagetitle1,pagetitle2;
    TextView timer,Question,Qno;
    Button answera,answerb,answerc,answerd,answere;
    KonfettiView konfettiView;
//    ElasticButton btnnext;
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
//            title = getArguments().getString(Constants.PAGETITLE_KEY);
            Log.e("qa title",title);
        }
    }
    public void callParentMethod(){
        getActivity().onBackPressed();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         v= inflater.inflate(R.layout.fragment_question_answer, container, false);
         v.setBackgroundColor(Color.WHITE);
         initViews();
         callParentMethod();
         answera.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Bloom.with(getActivity())
                         .setParticleRadius(10)
                         .setShapeDistributor(new StarShapeDistributor())
                         .setEffector(new BloomEffector.Builder()
                                 .setDuration(2000)
                                 .setRotationSpeedRange(0.01f, 0.05f)
                                 .setSpeedRange(0.1f, 0.5f)
                                 .setAcceleration(0.00025f, 90)
                                 .setAnchor(v.getWidth() / 2, v.getHeight())
                                 .build())
                         .boom(v);
                 answera.setBackgroundResource(R.drawable.bluedrawable);
                 selectAnswer();
             }
         });
        answerb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bloom.with(getActivity())
                        .setParticleRadius(10)
                        .setShapeDistributor(new RectShapeDistributor())
                        .setEffector(new BloomEffector.Builder()
                                .setDuration(2000)
                                .setRotationSpeedRange(0.01f, 0.05f)
                                .setSpeedRange(0.1f, 0.5f)
                                .setAcceleration(0.00025f, 90)
                                .setAnchor(v.getWidth() / 2, v.getHeight())
                                .build())
                        .boom(v);
                answerb.setBackgroundResource(R.drawable.bluedrawable);
                selectAnswer();
            }
        });
        answerc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bloom.with(getActivity())
                        .setParticleRadius(10)
                        .setShapeDistributor(new ParticleShapeDistributor() {
                            @Override
                            public ParticleShape getShape(BloomParticle particle) {
                                return null;
                            }
                        })
                        .setEffector(new BloomEffector.Builder()
                                .setDuration(2000)
                                .setRotationSpeedRange(0.01f, 0.05f)
                                .setSpeedRange(0.1f, 0.5f)
                                .setAcceleration(0.00025f, 90)
                                .setAnchor(v.getWidth() / 2, v.getHeight())
                                .build())
                        .boom(v);


                selectAnswer();
            }
        });
        answerd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                konfettiView.build()
                        .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                        .setDirection(0.0, 359.0)
                        .setSpeed(5f, 5f)
                        .setFadeOutEnabled(true)
                        .setTimeToLive(2000L)
                        .addShapes(Shape.RECT, Shape.CIRCLE)
                        .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                        .streamFor(200, 1000L);
                         selectAnswer();
            }
        });
        answere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//

                konfettiView.build()
                        .addColors(Color.BLUE, Color.YELLOW)
                        .setDirection(0.0, 359.0)
                        .setSpeed(5f, 5f)
                        .setFadeOutEnabled(true)
                        .setTimeToLive(2000L)
                        .addShapes(Shape.RECT, Shape.CIRCLE)
                        .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                        .streamFor(200, 500L);
                selectAnswer();
            }
        });
         return v;
    }
void selectAnswer()
{
    setBackgroundColor_Button();
    flag++;
    Qno.setText(flag+"");
    if(flag==1) {

        Question.setText(Constants.questions[flag]);
    }
    if(flag==2) {

        Question.setText(Constants.questions[flag]);
    }
    if(flag==3) {
        Question.setText(Constants.questions[flag]);

    }
    if(flag==4) {
        Question.setText(Constants.questions[flag]);


    }
    if(flag==5) {
        Question.setText(Constants.questions[flag]);


    }
    if(flag<Constants.questions.length)
    {
        Question.setText(Constants.questions[flag]);
    }
    else
    {

    }
    if(flag==Constants.questions.length)
    {
            Fragment f=new CelebrationFragment();
            fun(f);
    }
}

    void fun(Fragment f)
    {
            // Create new fragment and transaction

            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack
            transaction.replace(R.id.qa_layout, f);
            transaction.addToBackStack(null);
            transaction.commit();

    }
    void setBackgroundColor_Button()
    {
        answere.setBackgroundResource(R.color.themecolor);
        answerb.setBackgroundResource(R.color.themecolor);
        answerc.setBackgroundResource(R.color.themecolor);
        answerd.setBackgroundResource(R.color.themecolor);
        answera.setBackgroundResource(R.color.themecolor);
    }
    void initViews()
    {
//        timer=v.findViewById(R.id.examtimer);
        answera=v.findViewById(R.id.answera);
        answerb=v.findViewById(R.id.answerb);
        answerc=v.findViewById(R.id.answerc);
        answerd=v.findViewById(R.id.answerd);
        answere=v.findViewById(R.id.answere);
//        pagetitle1=v.findViewById(R.id.titlequestion1);
//        pagetitle2=v.findViewById(R.id.titlequestion2);
//        btnnext=(ElasticButton) v.findViewById(R.id.btn_next);
        Question=v.findViewById(R.id.txtQuestion);
        Qno=v.findViewById(R.id.txtQno);
        konfettiView = (KonfettiView)v.findViewById(R.id.viewKonfetti);
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
//        pagetitle1.setText(title);
//        pagetitle2.setText(Constants.PAGETITLE_INTEREST);
        Question.setText(Constants.questions[flag]);
        Qno.setText(flag+1+" ");
//        new CountDownTimer(60000, 1000) {
//            public void onTick(long millisUntilFinished) {
//                timer.setText(""+ millisUntilFinished / 1000);
//                long millis = millisUntilFinished;
//                String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
//                timer.setText(hms);//set text
//            }
//            public void onFinish() {
//                timer.setText("done!");
//            }
//        }.start();

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
