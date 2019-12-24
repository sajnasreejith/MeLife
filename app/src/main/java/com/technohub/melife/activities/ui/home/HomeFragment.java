package com.technohub.melife.activities.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.technohub.melife.R;
import com.technohub.melife.activities.ui.fragments.AboutUsFragment;
import com.technohub.melife.activities.ui.fragments.ProfileFragment;
import com.technohub.melife.activities.ui.fragments.ReportFragment;
import com.technohub.melife.activities.ui.fragments.StartSkillTestFragment;
import com.technohub.melife.activities.ui.fragments.ViewTestReportFragment;
/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
        View v;
    Animation animBounce;
//    ImageView ptest,faq,setting,contactus,aboutus,testreport;
    CardView txtptest,txtfaq,txtcontact,txtabout,txtset,txttestreport;
    TextView tviewptest;
    CircularImageView test,report;
    ImageView profile;
    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     *
     *
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      
        v=inflater.inflate(R.layout.fragment_home_updated, container, false);
        CardView cardView = v.findViewById(R.id.txtpsychotest);

        v.setBackgroundColor(Color.WHITE);
                                initView();
                                callParentMethod();
        animBounce = AnimationUtils.loadAnimation(getContext(),
                R.anim.bounce_animation);

        txtptest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtptest.startAnimation(animBounce);
                fun();

            }
        });

        txtfaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtfaq.startAnimation(animBounce);
//                txtfaq.setCardBackgroundColor(Color.CYAN);

            }
        });


        txtcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtcontact.startAnimation(animBounce);
//                txtcontact.setCardBackgroundColor(Color.CYAN);
//                txtcontact.setCardBackgroundColor(R.drawable.button_drawable);
            }
        });

        txtset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtset.startAnimation(animBounce);
//                txtsetting.setCardBackgroundColor(Color.CYAN);
//                txtsetting.setCardBackgroundColor(R.drawable.button_drawable);
            }
        });

        txttestreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txttestreport.startAnimation(animBounce);
                fun2();

//                txttestreport.setCardBackgroundColor(R.drawable.button_drawable);
            }
        });
        txtabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtabout.startAnimation(animBounce);
                Fragment f=new AboutUsFragment();
                fun(f);
//                txtabout.setCardBackgroundColor(Color.CYAN);
//                txtabout.setCardBackgroundColor(R.drawable.button_drawable);
            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         Fragment f=new HomeFragment();
         fun(f);
            }
        });
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f=new ViewTestReportFragment();
                fun(f);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f=new ProfileFragment();
                fun(f);
            }
        });
        return v;
    }
    void initView()
    {
//        buttond
//        ptest=v.findViewById(R.id.btn_psychotest);
//        faq=v.findViewById(R.id.btn_faq);
//        contactus=v.findViewById(R.id.btncontact);
//        aboutus=v.findViewById(R.id.btn_aboutus);
//        setting=v.findViewById(R.id.btn_setting);
//        testreport=v.findViewById(R.id.btn_testreport);

//cardviews
        txtptest=v.findViewById(R.id.txtpsychotest);
        txtabout=v.findViewById(R.id.txt_aboutus);
        txtfaq=v.findViewById(R.id.txt_faq);
        txttestreport=v.findViewById(R.id.txttestreport);
        txtcontact=v.findViewById(R.id.txt_contactus);
        txtset=v.findViewById(R.id.txtsetting);
//        textview

        tviewptest=v.findViewById(R.id.tviewptest);
        test=(CircularImageView)v.findViewById(R.id.testicon);
        report=(CircularImageView)v.findViewById(R.id.reporticon);
        profile=(ImageView)v.findViewById(R.id.profile);
    }
    void fun(Fragment f)
    {
        // Create new fragment and transaction

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.homelayout, f);
        transaction.addToBackStack(null);
        transaction.commit();

    }
    void fun()
    {
        // Create new fragment and transaction

        Fragment newFragment = new StartSkillTestFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
//        Bundle args = new Bundle();
//        args.putString(Constants.PAGETITLE_KEY,tviewptest.getText().toString() );
//        newFragment.setArguments(args);
        transaction.replace(R.id.homelayout, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void callParentMethod(){
        getActivity().onBackPressed();
    }
    void fun2()
    {
        // Create new fragment and transaction
        Fragment newFragment = new ViewTestReportFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack

        transaction.replace(R.id.homelayout, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
