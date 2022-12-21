package com.example.majorproject1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.majorproject1.CustomListAdapter;
import com.example.majorproject1.CustomListPOJO;
import com.example.majorproject1.R;


import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ListView lv;
    CustomListAdapter adapter;
    public ArrayList<CustomListPOJO> array;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home,container,false);
        lv=(ListView) root.findViewById(R.id.listview);
        array=new ArrayList<CustomListPOJO>();
        array.add(new CustomListPOJO(R.drawable.bag1,"SkyBag","25L 3 compartment","750"));
        array.add(new CustomListPOJO(R.drawable.pc,"Predator PC","gaming pc","7500"));
        array.add(new CustomListPOJO(R.drawable.phone,"Iphone 12","A15 Bionic","59999"));
        array.add(new CustomListPOJO(R.drawable.cycle,"Hero Cycle","6 gear","8500"));
        array.add(new CustomListPOJO(R.drawable.bootle,"Cello Bottle","2Litre Steel","320"));
        adapter=new CustomListAdapter(array,getActivity());
        lv.setAdapter(adapter);


        return root;
    }

}