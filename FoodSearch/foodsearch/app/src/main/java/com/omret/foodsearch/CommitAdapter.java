package com.omret.foodsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;



/**
 * Created by terry on 12/20/15.
 */
public class CommitAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Commit> commits;

    private TextView commitcontent;
    private TextView username;

    public CommitAdapter(Context context,ArrayList<Commit> commits){
        this.context = context;
        this.commits = commits;
    }

    @Override
    public int getCount() {
        return commits.size();
    }

    @Override
    public Object getItem(int position) {
        return commits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.commititem,null);
        commitcontent = (TextView ) view.findViewById(R.id.commitcontent);
        commitcontent.setText(commits.get(position).getContent());

   /*     username = (TextView) view.findViewById(R.id.commituser);
        username.setText("用户名："+commits.get(position).getUser());*/

        return view;
    }
}
