package com.technohub.melife.activities.ui.fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.skydoves.elasticviews.ElasticButton;
import com.technohub.melife.R;
import com.technohub.melife.activities.classes.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ViewTestReportFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ViewTestReportFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewTestReportFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
//    private String title;
//    private String mParam2;
    ElasticButton viewRep;
//    TextView txt_title,txt_skilltitle;
    View v;

    private OnFragmentInteractionListener mListener;

    public ViewTestReportFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewTestReportFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewTestReportFragment newInstance(String param1, String param2) {
        ViewTestReportFragment fragment = new ViewTestReportFragment();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_view_test_report, container, false);
        v.setBackgroundColor(Color.WHITE);
        viewRep=(ElasticButton)v.findViewById(R.id.btn_viewreport);

//        callParentMethod();
//        txt_skilltitle=v.findViewById(R.id.skill_title);
//        txt_title=v.findViewById(R.id.viewrep_title);
        viewRep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        fun();
            }
        });
        return v;
    }
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
//    // TODO: Rename method, update argument and hook method into UI event

//    public void callParentMethod(){
//        getActivity().onBackPressed();
//        getFragmentManager().popBackStack();
//    }
    @Override
    public void onResume() {
        super.onResume();
//        txt_title.setText(title);
    }
    void fun()
    {
        // Create new fragment and transaction
        Fragment newFragment = new ReportFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
//        Bundle args = new Bundle();
//        args.putString(Constants.PAGETITLE_KEY,txt_skilltitle.getText().toString());
//        newFragment.setArguments(args);
        transaction.replace(R.id.viewreportlayout, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
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
