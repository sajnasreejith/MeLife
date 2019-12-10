package com.technohub.melife.activities.ui.fragments;

import android.app.FragmentBreadCrumbs;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.technohub.melife.R;
import com.technohub.melife.activities.classes.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InstructionsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InstructionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InstructionsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView titleinstruction,titleinstruction2;
    Button proceed;
    View v;
    private OnFragmentInteractionListener mListener;
    String title;
    public InstructionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InstructionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InstructionsFragment newInstance(String param1, String param2) {
        InstructionsFragment fragment = new InstructionsFragment();
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
            Log.e("title",title);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         v=inflater.inflate(R.layout.fragment_instructions, container, false);
         initViews();
         v.setBackgroundColor(Color.WHITE);
         proceed.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                fun();
             }
         });
         return v;
    }
    void fun()
    {
        // Create new fragment and transaction
        Fragment newFragment = new QuestionAnswerFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Bundle args = new Bundle();
        args.putString(Constants.PAGETITLE_KEY,titleinstruction.getText().toString());
        newFragment.setArguments(args);
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.instruction_layout, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public void onResume() {
        super.onResume();
        titleinstruction.setText(title);
        titleinstruction2.setText(Constants.PAGETITLE_INSTRUCTION);
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
    void initViews()
    {
        titleinstruction=v.findViewById(R.id.title_instruction);
        titleinstruction2=v.findViewById(R.id.title_instruction2);
        proceed=v.findViewById(R.id.btn_proceed);

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
