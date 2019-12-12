package com.technohub.melife.activities.ui.fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.technohub.melife.R;
import com.technohub.melife.activities.classes.Constants;
import com.technohub.melife.activities.ui.viewmodels.SharedViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StartSkillTestFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StartSkillTestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StartSkillTestFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
     TextView titletext,skilltitle;
    // TODO: Rename and change types of parameters
    private String str_title;
    private OnFragmentInteractionListener mListener;

    View v;
    public StartSkillTestFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StartSkillTestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StartSkillTestFragment newInstance(String param1, String param2) {
        StartSkillTestFragment fragment = new StartSkillTestFragment();
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

        }
    }
    void fun()
    {
        // Create new fragment and transaction
        Fragment newFragment = new InstructionsFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        Bundle args = new Bundle();
        args.putString(Constants.PAGETITLE_KEY,skilltitle.getText().toString());
        newFragment.setArguments(args);
        transaction.replace(R.id.starttestlayout, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_start_test, container, false);
        v.setBackgroundColor(Color.WHITE);
        initViews();
        v.findViewById(R.id.btn_starttest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                fun();
            }
        });
        return v;

    }

    @Override
    public void onResume() {
        super.onResume();


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    void initViews()
    {
        titletext=v.findViewById(R.id.title);
        skilltitle=v.findViewById(R.id.skill_title);
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
