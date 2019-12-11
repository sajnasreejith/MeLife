package com.technohub.melife.activities.ui.home;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.technohub.melife.R;
import com.technohub.melife.activities.adapters.HomeScreenAdapter;
import com.technohub.melife.activities.classes.Constants;
import com.technohub.melife.activities.ui.fragments.HomeFragmentGrid;
import com.technohub.melife.activities.ui.fragments.InstructionsFragment;
import com.technohub.melife.activities.ui.fragments.StartSkillTestFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ExpandableListView expandableListView;

    private HomeScreenAdapter expandableListViewAdapter;

    private List<String> listDataGroup;
    View root;
    FrameLayout fm;
    private HashMap<String, List<String>> listDataChild;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);


        // initializing the views
        initViews();

        // initializing the listeners
        initListeners();

        // initializing the objects
        initObjects();

        // preparing list data
        initListData();


        return root;
    }


    /**
     * method to initialize the views
     */
    private void initViews() {
//        DisplayMetrics metrics = new DisplayMetrics();
//        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
//        int width = metrics.widthPixels;
        expandableListView = root.findViewById(R.id.list_menu);
        fm=root.findViewById(R.id.skillfragment);
//        expandableListView.setIndicatorBounds(width - GetPixelFromDips(50), width - GetPixelFromDips(10));

    }
void fun(String value)
{
    // Create new fragment and transaction
    Fragment newFragment = new HomeFragmentGrid();
    Bundle args = new Bundle();
    args.putString(Constants.PAGETITLE_KEY,value);
    newFragment.setArguments(args);
    FragmentTransaction transaction = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack
    transaction.replace(R.id.nav_host_fragment, newFragment);
    transaction.addToBackStack(null);
    transaction.commit();
}
    public int GetPixelFromDips(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }
    /**
     * method to initialize the listeners
     */
    private void initListeners() {


        // ExpandableListView on child click listener
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {



                fun(listDataGroup.get(groupPosition).toString());
                Toast.makeText(
                        getContext(),
                        listDataGroup.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataGroup.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();

                return false;
            }
        });
        // ExpandableListView Group expanded listener
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getContext(),
                        listDataGroup.get(groupPosition) + " " + getString(R.string.text_psy_test),
                        Toast.LENGTH_SHORT).show();
            }
        });

        // ExpandableListView Group collapsed listener
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getContext(),
                        listDataGroup.get(groupPosition) + " " + getString(R.string.text_psy_test),
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
    /**
     * method to initialize the objects
     */
    private void initObjects() {

        // initializing the list of groups
        listDataGroup = new ArrayList<>();

        // initializing the list of child
        listDataChild = new HashMap<>();

        // initializing the adapter object
        expandableListViewAdapter = new HomeScreenAdapter(getContext(), listDataGroup, listDataChild);

        // setting list adapter
        expandableListView.setAdapter(expandableListViewAdapter);

    }
    /*
     * Preparing the list data
     *
     * Dummy Items
     */
    private void initListData() {

        // Adding group data
        listDataGroup.add(getString(R.string.text_psy_test));
        listDataGroup.add(getString(R.string.text_testreports));
        listDataGroup.add(getString(R.string.text_faq));
        listDataGroup.add(getString(R.string.text_contactus));
        listDataGroup.add(getString(R.string.text_aboutus));
        listDataGroup.add(getString(R.string.text_setting));

        // array of strings
        String[] array;

        // list of alcohol
        List<String> psychometric_List = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_psytests);
        for (String item : array) {
            psychometric_List.add(item);
        }

//        // list of coffee
        List<String> testReportList = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_testreport);
        for (String item : array) {
            testReportList.add(item);
        }

//        // list of pasta
        List<String> faqList = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_faq);
        for (String item : array) {
            faqList.add(item);
        }

        // list of cold drinks
        List<String> contactUsList = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_contactus);
        for (String item : array) {
            contactUsList.add(item);
        }

        List<String> aboutus_list = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_aboutus);
        for (String item : array) {
            aboutus_list.add(item);
        }

        List<String> setting_List = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_setting);
        for (String item : array) {
            setting_List.add(item);
        }
        // Adding child data
        listDataChild.put(listDataGroup.get(0), psychometric_List);
        listDataChild.put(listDataGroup.get(1), testReportList);
        listDataChild.put(listDataGroup.get(2), faqList);
        listDataChild.put(listDataGroup.get(3), contactUsList);
        listDataChild.put(listDataGroup.get(4), aboutus_list);
        listDataChild.put(listDataGroup.get(5), setting_List);
        // notify the adapter
        expandableListViewAdapter.notifyDataSetChanged();
    }
}