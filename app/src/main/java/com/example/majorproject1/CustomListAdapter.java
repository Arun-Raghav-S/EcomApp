package com.example.majorproject1;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
public class CustomListAdapter extends BaseAdapter {
    public ArrayList<com.example.majorproject1.CustomListPOJO>arrayList;
    private List<com.example.majorproject1.CustomListPOJO>list;
    Context acontext;


    public CustomListAdapter(List<com.example.majorproject1.CustomListPOJO> list, Context context) {
        acontext = context;
        this.list = list;
        this.arrayList=new ArrayList<com.example.majorproject1.CustomListPOJO>();
        this.arrayList.addAll(list);
    }
    public class ViewHolder{
        ImageView profpic,cartpic;
        TextView  title,desc,price;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final  ViewHolder holder;

        if (view==null)
        {
         view= LayoutInflater.from(acontext).inflate(R.layout.listv,null);
         holder=new ViewHolder();
         holder.profpic=(ImageView) view.findViewById(R.id.itempic);
         holder.cartpic=(ImageView) view.findViewById(R.id.carticon);
         holder.title=(TextView) view.findViewById(R.id.title);
         holder.desc=(TextView) view.findViewById(R.id.Desc);
         holder.price=(TextView) view.findViewById(R.id.price);
         view.setTag(holder);
        }else{
            holder=(ViewHolder) view.getTag();
        }
        try {
            int ppic=list.get(i).getProf();
            holder.profpic.setImageResource(ppic);
            holder.title.setText(list.get(i).getTitle());
            holder.desc.setText(list.get(i).getDesc());
            holder.price.setText(list.get(i).getPrice());
            SharedPreferences cartlist= acontext.getSharedPreferences("CartList",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor;
            editor=cartlist.edit();
            SharedPreferences cartColor= acontext.getSharedPreferences("CartColor",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor1;
            editor1= cartColor.edit();

            SharedPreferences cc=acontext.getSharedPreferences("CartColor",Context.MODE_PRIVATE);
            SharedPreferences sp= acontext.getSharedPreferences("CartList", Context.MODE_PRIVATE);
            if (list.get(i).getTitle().equals("SkyBag"))
            {
                if (sp.getInt("bag",5)==1){
                    holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.teal_700));}
                else {
                    holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.orange));}

            }
            if (list.get(i).getTitle().equals("Predator PC"))
            {
                if (sp.getInt("pc",5)==1){
                    holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.teal_700));
                    }
                else {
                    holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.orange));
                  }
            }

            if (list.get(i).getTitle().equals("Iphone 12"))
            {
                if (sp.getInt("phone",5)==1){
                    holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.teal_700));
                  }
                else {
                    holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.orange));
                    }
            }
            if (list.get(i).getTitle().equals("Hero Cycle"))
            {
                if (sp.getInt("cycle",5)==1){
                    holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.teal_700));
                   }
                else {
                    holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.orange));
                  }
            }
            if (list.get(i).getTitle().equals("Cello Bottle"))
            {
                if (sp.getInt("bottle",5)==1){
                    holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.teal_700));
                  }
                else {
                    holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.orange));
                  }
            }
            holder.cartpic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences cc=acontext.getSharedPreferences("CartColor",Context.MODE_PRIVATE);
                    if (list.get(i).getTitle().equals("SkyBag"))
                    {
                        if (sp.getInt("bag",5)==3){
                            holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.teal_700));
                        editor.putInt("bag",1);}
                        else {
                            holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.orange));
                            editor.putInt("bag",3);}
                    }
                    if (list.get(i).getTitle().equals("Predator PC"))
                    {
                        if (sp.getInt("pc",5)==3){
                            holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.teal_700));
                        editor.putInt("pc",1);}
                    else {
                            holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.orange));
                        editor.putInt("pc",3);}
                    }

                    if (list.get(i).getTitle().equals("Iphone 12"))
                    {
                        if (sp.getInt("phone",5)==3){
                            holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.teal_700));
                            editor.putInt("phone",1);}
                       else {
                            holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.orange));
                            editor.putInt("phone",3);}
                    }
                    if (list.get(i).getTitle().equals("Hero Cycle"))
                    {
                        if (sp.getInt("cycle",5)==3){
                            holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.teal_700));
                        editor.putInt("cycle",1);}
                    else {
                            holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.orange));
                        editor.putInt("cycle",3);}
                    }
                    if (list.get(i).getTitle().equals("Cello Bottle"))
                    {
                        if (sp.getInt("bottle",5)==3){
                            holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.teal_700));
                        editor.putInt("bottle",1);}
                    else {
                        holder.cartpic.setColorFilter(holder.cartpic.getContext().getResources().getColor(R.color.orange));
                        editor.putInt("bottle",3);}
                    }
                    editor.apply();
                }
            });

        }catch (Exception ex){

        }
        return view;
    }

}
