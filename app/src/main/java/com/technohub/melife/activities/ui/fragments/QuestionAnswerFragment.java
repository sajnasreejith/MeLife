package com.technohub.melife.activities.ui.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.util.Size;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.skydoves.elasticviews.ElasticButton;
import com.technohub.melife.Authentication.ChooseLogin;
import com.technohub.melife.MainActivity;
import com.technohub.melife.R;
import com.technohub.melife.activities.classes.Constants;
import com.technohub.melife.activities.classes.MyBloomListener;
import com.technohub.melife.activities.ui.home.HomeFragment;

import java.util.Timer;
import java.util.TimerTask;
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
    private static int TIME_OUT = 3000;
    // TODO: Rename and change types of parameters
    private String title,strSelected_ans;
//    TextView pagetitle1,pagetitle2;
    TextView timer,Question,Qno;
    Button answera,answerb,answerc,answerd,answere;
    KonfettiView konfettiView;
//    ElasticButton btnnext;
    View v;
    static int flag=0;
    DialogFragment dialogFragment;
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
         v.setFocusableInTouchMode(true);
         v.requestFocus();
         v.setOnKeyListener(new View.OnKeyListener() {
           @Override
           public boolean onKey(View v, int keyCode, KeyEvent event) {
               if (event.getAction() == KeyEvent.ACTION_DOWN) {
                   if (keyCode == KeyEvent.KEYCODE_BACK)
                   {
                       return true;
                   }
               }
               return false;
           }
       });


//         callParentMethod();
         answera.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View vi) {
                 Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce_animation);
                 //I want to start animation here
                 answera.startAnimation(animation);
                 dialog();
                 new Handler().postDelayed(new Runnable() {

                     /*
                      * Showing splash screen with a timer. This will be useful when you
                      * want to show case your app logo / company
                      */

                     @Override
                     public void run() {
                         // This method will be executed once the timer is over
                         // Start your app main activity
                         dialogFragment.dismiss(); // when the task active then close the dialog
                         selectAnswer();
                     }
                 }, TIME_OUT);

//                 new Handler().postDelayed(new Runnable() {
//                     @Override
//                     public void run() {
//                         answera.clearAnimation();
//                         Fragment f=new SuccessFrag1();
//                         fun(f);
//                     }
//                 }, 2000);


//                 Bloom.with(getActivity())
//                         .setParticleRadius(10)
//                         .setShapeDistributor(new StarShapeDistributor())
//                         .setEffector(new BloomEffector.Builder()
//                                 .setDuration(2000)
//                                 .setRotationSpeedRange(0.01f, 0.05f)
//                                 .setSpeedRange(0.1f, 0.5f)
//                                 .setAcceleration(0.00025f, 90)
//                                 .setAnchor(vi.getWidth() / 2, vi.getHeight())
//                                 .build())
//                         .boom(vi);

//                 answera.setBackgroundResource(R.drawable.bluedrawable);

             }
         });
        answerb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {

                Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce_animation);
                //I want to start animation here
                answerb.startAnimation(animation);
                //Stop animation after 1 second

                dialog4();
                new Handler().postDelayed(new Runnable() {

                    /*
                     * Showing splash screen with a timer. This will be useful when you
                     * want to show case your app logo / company
                     */

                    @Override
                    public void run() {
                        // This method will be executed once the timer is over
                        // Start your app main activity
                        dialogFragment.dismiss(); // when the task active then close the dialog
                        selectAnswer();
                    }
                }, TIME_OUT);


//                Bloom.with(getActivity())
//                        .setParticleRadius(10)
//                        .setShapeDistributor(new RectShapeDistributor())
//                        .setEffector(new BloomEffector.Builder()
//                                .setDuration(2000)
//                                .setRotationSpeedRange(0.01f, 0.05f)
//                                .setSpeedRange(0.1f, 0.5f)
//                                .setAcceleration(0.00025f, 90)
//                                .setAnchor(vi.getWidth() / 2, vi.getHeight())
//                                .build())
//                        .boom(vi);
//                answerb.setBackgroundResource(R.drawable.bluedrawable);

            }
        });
        answerc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce_animation);
                //I want to start animation here
                answerc.startAnimation(animation);
                //Stop animation after 1 second

                dialog3();
                new Handler().postDelayed(new Runnable() {

                    /*
                     * Showing splash screen with a timer. This will be useful when you
                     * want to show case your app logo / company
                     */

                    @Override
                    public void run() {
                        // This method will be executed once the timer is over
                        // Start your app main activity
                        dialogFragment.dismiss(); // when the task active then close the dialog
                        selectAnswer();
                    }
                }, TIME_OUT);



//                Bloom.with(getActivity())
//                        .setParticleRadius(10)
//                        .setShapeDistributor(new ParticleShapeDistributor() {
//                            @Override
//                            public ParticleShape getShape(BloomParticle particle) {
//                                return null;
//                            }
//                        })
//                        .setEffector(new BloomEffector.Builder()
//                                .setDuration(2000)
//                                .setRotationSpeedRange(0.01f, 0.05f)
//                                .setSpeedRange(0.1f, 0.5f)
//                                .setAcceleration(0.00025f, 90)
//                                .setAnchor(vi.getWidth() / 2, vi.getHeight())
//                                .build())
//                        .boom(vi);



            }
        });
        answerd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce_animation);
                //I want to start animation here
                answerd.startAnimation(animation);
                //Stop animation after 1 second
                dialog2();
                new Handler().postDelayed(new Runnable() {

                    /*
                     * Showing splash screen with a timer. This will be useful when you
                     * want to show case your app logo / company
                     */

                    @Override
                    public void run() {
                        // This method will be executed once the timer is over
                        // Start your app main activity
                        dialogFragment.dismiss(); // when the task active then close the dialog
                        selectAnswer();
                    }
                }, TIME_OUT);







//                konfettiView.build()
//                        .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
//                        .setDirection(0.0, 359.0)
//                        .setSpeed(5f, 5f)
//                        .setFadeOutEnabled(true)
//                        .setTimeToLive(2000L)
//                        .addShapes(Shape.RECT, Shape.CIRCLE)
//                        .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
//                        .streamFor(200, 1000L);
//                ImageView suc2=(ImageView)v.findViewById(R.id.suc2);
//                suc2.setVisibility(View.VISIBLE);
//                YoYo.with(Techniques.RubberBand)
//                        .duration(200)
//                        .repeat(2)
//                        .playOn(v.findViewById(R.id.suc2));

            }
        });

        answere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                final Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce_animation);
                //I want to start animation here
                answere.startAnimation(animation);
//                        Fragment f=new SuccessFrag2();
//                        fun(f);
                dialog();
                new Handler().postDelayed(new Runnable() {

                    /*
                     * Showing splash screen with a timer. This will be useful when you
                     * want to show case your app logo / company
                     */

                    @Override
                    public void run() {
                        // This method will be executed once the timer is over
                        // Start your app main activity
                        dialogFragment.dismiss(); // when the task active then close the dialog
                         selectAnswer();
                    }
                }, TIME_OUT);
//                selectAnswer();
//                final Timer t = new Timer();
//                t.schedule(new TimerTask() {
//                    public void run() {
//
//
//                        // also just top the timer thread, otherwise, you may receive a crash report
//                    }
//                }, 2000);

                //Stop animation after 1 second
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        answere.clearAnimation();
//                        animation.cancel();
//                        Fragment f=new SuccessFrag2();
//                        fun(f);
//                    }
//                }, 2000);
//

//                konfettiView.build()
//                        .addColors(Color.BLUE, Color.YELLOW)
//                        .setDirection(0.0, 359.0)
//                        .setSpeed(5f, 5f)
//                        .setFadeOutEnabled(true)
//                        .setTimeToLive(2000L)
//                        .addShapes(Shape.RECT, Shape.CIRCLE)
//                        .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
//                        .streamFor(200, 500L);





            }
        });
         return v;
    }
void selectAnswer()
{
    flag++;
    if(flag<Constants.questions.length)
    {
         Qno.setText(flag+1+" ");
        Question.setText(Constants.questions[flag]);
        Toast.makeText(getContext(), "flag "+flag, Toast.LENGTH_SHORT).show();
    }
    if(flag==Constants.questions.length)
    {
            Fragment f=new CelebrationFragment();
            fun(f);
    }
}

void dialog()
{
    FragmentTransaction ft = getFragmentManager().beginTransaction();
    Fragment prev = getFragmentManager().findFragmentByTag("dialog");
    if (prev != null) {
        ft.remove(prev);
    }
    ft.addToBackStack(null);
     dialogFragment = new SuccessFrag3();
     dialogFragment.show(ft, "dialog");
}
    void dialog2()
    {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        dialogFragment = new SuccessFrag1();
        dialogFragment.show(ft, "dialog");
    }
    void dialog3()
    {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        dialogFragment = new SuccessFrag2();
        dialogFragment.show(ft, "dialog");
    }
    void dialog4()
    {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        dialogFragment = new SuccessFrag4();
        dialogFragment.show(ft, "dialog");
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

    void initViews()
    {

        answera=v.findViewById(R.id.answera);
        answerb=v.findViewById(R.id.answerb);
        answerc=v.findViewById(R.id.answerc);
        answerd=v.findViewById(R.id.answerd);
        answere=v.findViewById(R.id.answere);

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
        Question.setText(Constants.questions[flag]);
        Qno.setText(flag+1+" ");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    }
