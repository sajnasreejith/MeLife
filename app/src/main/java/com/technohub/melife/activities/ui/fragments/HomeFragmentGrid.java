package com.technohub.melife.activities.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technohub.melife.R;
import com.technohub.melife.activities.adapters.RecyclerViewAdapter;
import com.technohub.melife.activities.classes.AutoFitGridLayoutManager;
import com.technohub.melife.activities.classes.DataModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragmentGrid.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragmentGrid#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragmentGrid extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView;
    ArrayList<DataModel> arrayList;
    View v;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragmentGrid() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragmentGrid.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragmentGrid newInstance(String param1, String param2) {
        HomeFragmentGrid fragment = new HomeFragmentGrid();
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
         v=inflater.inflate(R.layout.fragment_home_fragment_grid, container, false);
        recyclerView = (RecyclerView)v. findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();
        arrayList.add(new DataModel("Item 1", R.drawable.thinking, "#09A9FF"));
        arrayList.add(new DataModel("Item 2", R.drawable.skill2, "#3E51B1"));
//        arrayList.add(new DataModel("Item 3", R.drawable.ferrari, "#673BB7"));
//        arrayList.add(new DataModel("Item 4", R.drawable.jetpack_joyride, "#4BAA50"));
//        arrayList.add(new DataModel("Item 5", R.drawable.three_d, "#F94336"));
//        arrayList.add(new DataModel("Item 6", R.drawable.terraria, "#0A9B88"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), arrayList, (RecyclerViewAdapter.ItemListener) getContext());
        recyclerView.setAdapter(adapter);


        /**
         AutoFitGridLayoutManager that auto fits the cells by the column width defined.
         **/

        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(getActivity(), 500);
        recyclerView.setLayoutManager(layoutManager);


        /**
         Simple GridLayoutManager that spans two columns
         **/
        /*GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);*/
        return inflater.inflate(R.layout.fragment_home_fragment_grid, container, false);
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
