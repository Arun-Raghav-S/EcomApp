package com.example.majorproject1.ui.cart;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.majorproject1.CustomCartAdapter;
import com.example.majorproject1.CustomListAdapter;
import com.example.majorproject1.CustomListPOJO;
import com.example.majorproject1.R;

import java.util.ArrayList;


public class CartFragment extends Fragment {
    ListView lv;
    CustomCartAdapter adapter;
    Toolbar toolbar;

    //CustomListAdapter adapter;
    Button order;
    public ArrayList<CustomListPOJO> arr;
    public int[] cartArray(int[] b){
        return b;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_cart,container,false);
        toolbar=(Toolbar)root.findViewById(R.id.toolbar) ;
        order=(Button)root.findViewById(R.id.order) ;
        arr=new ArrayList<CustomListPOJO>();
        lv=(ListView) root.findViewById(R.id.cartlist);

        TextView emptyView;
        emptyView = new TextView(root.getContext());
        emptyView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        emptyView.setTextColor(getResources().getColor(R.color.black));
        emptyView.setText("No item");
        emptyView.setTextSize(20);
        emptyView.setVisibility(View.GONE);
        emptyView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        ((ViewGroup)lv.getParent()).addView(emptyView);
        lv.setEmptyView(emptyView);

        SharedPreferences sh= root.getContext().getSharedPreferences("CartList", Context.MODE_PRIVATE);
            int b=sh.getInt("bag",2);
            int pc=sh.getInt("pc",2);
            int ph=sh.getInt("phone",2);
            int cy=sh.getInt("cycle",2);
            int bottle=sh.getInt("bottle",2);
            if(b==1){
                arr.add(new CustomListPOJO(R.drawable.bag1,"SkyBag","25L 3 compartment","750"));
            }
            if(pc==1){
                arr.add(new CustomListPOJO(R.drawable.pc,"Predator PC","gaming pc","7500"));
            }
            if(ph==1){
                arr.add(new CustomListPOJO(R.drawable.phone,"Iphone 12","A15 Bionic","59999"));
            }
            if(cy==1){
                arr.add(new CustomListPOJO(R.drawable.cycle,"Hero Cycle","6 gear","8500"));
            }
            if(bottle==1){
                arr.add(new CustomListPOJO(R.drawable.bootle,"Cello Bottle","2Litre Steel","320"));
            }
            adapter=new CustomCartAdapter(arr,getActivity());
            lv.setAdapter(adapter);



        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arr.clear();
                SharedPreferences Sh= view.getContext().getSharedPreferences("CartList",Context.MODE_PRIVATE);
                SharedPreferences.Editor sh;
                sh= Sh.edit();
                sh.putInt("pc",0);
                sh.putInt("bag",0);
                sh.putInt("phone",0);
                sh.putInt("cycle",0);
                sh.putInt("bottle",0);
                sh.apply();
                adapter.notifyDataSetChanged();
                Toast.makeText(view.getContext(),"Your order has successfully placed",Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }


}