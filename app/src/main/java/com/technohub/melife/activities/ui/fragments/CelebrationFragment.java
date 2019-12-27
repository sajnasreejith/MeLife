package com.technohub.melife.activities.ui.fragments;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.technohub.melife.Authentication.ChooseLogin;
import com.technohub.melife.MainActivity;
import com.technohub.melife.R;
import com.technohub.melife.activities.BaseActivity;
import com.technohub.melife.activities.classes.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CelebrationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CelebrationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CelebrationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static int TIME_OUT = 1500;
    private OnFragmentInteractionListener mListener;

    public CelebrationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CelebrationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CelebrationFragment newInstance(String param1, String param2) {
        CelebrationFragment fragment = new CelebrationFragment();
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
    public void callParentMethod(){
        getActivity().onBackPressed();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        callParentMethod();
        // Inflate the layout for this fragment
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent intent = new Intent(getActivity(), BaseActivity.class);
                startActivity(intent);
            }
        }, TIME_OUT);
        return inflater.inflate(R.layout.fragment_celebration, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
//    void fun()
////    {
////
////        // Create new fragment and transaction
////        Fragment newFragment = new Fragment();
////        FragmentTransaction transaction = getFragmentManager().beginTransaction();
////        // Replace whatever is in the fragment_container view with this fragment,
////        // and add the transaction to the back stack
////        transaction.replace(R.id.instruction_layout, newFragment);
////        transaction.addToBackStack(null);
////
////        transaction.commit();
////
////    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

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
