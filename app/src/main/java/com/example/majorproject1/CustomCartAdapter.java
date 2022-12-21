package com.example.majorproject1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class CustomCartAdapter extends BaseAdapter{
    public ArrayList<com.example.majorproject1.CustomListPOJO> arrayList;
    private List<com.example.majorproject1.CustomListPOJO> list;
    Context acontext;

    public CustomCartAdapter(List<com.example.majorproject1.CustomListPOJO> list, Context context) {
        acontext = context;
        this.list = list;
        this.arrayList=new ArrayList<com.example.majorproject1.CustomListPOJO>();
        this.arrayList.addAll(list);
    }
    public class ViewHolder{
        ImageView profpic,cartpic;
        TextView title,desc,price;
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
        final ViewHolder holder;
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
            holder.cartpic.setVisibility(View.GONE);

        }catch (Exception ex){

        }
        return view;
    }
}
