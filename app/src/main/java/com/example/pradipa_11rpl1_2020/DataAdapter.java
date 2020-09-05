package com.example.pradipa_11rpl1_2020;

import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MydataViewHolder> {
    private ArrayList<Model> dataList;
    private Callback callback;
    View myView;
    int myPost;

    interface Callback {
        void onClick(int position);
        void test();
    }


    public DataAdapter(ArrayList<Model> dataList, Callback callback) {
        this.callback = callback;
        this.dataList = dataList;
        Log.d("moviedb", "DataAdapter: "+dataList.size()+"");
    }
    
    @Override
    public MydataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapter, parent, false);
        return new MydataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MydataViewHolder holder, final int position) {
        holder.txtname.setText(dataList.get(position).getOriginal_title());
        holder.txtdesc.setText(dataList.get(position).getOverview());
        Log.d("movie", "onBindViewHolder: "+dataList.get(position).getPoster_path());
        Glide.with(holder.itemView)
                .load(dataList.get(position).getPoster_path())
                .override(Target.SIZE_ORIGINAL)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.ivprofile);

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class MydataViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        private TextView txtname, txtdesc;
        CardView card;
        ImageView ivprofile;

        public MydataViewHolder(View itemView) {
            super(itemView);
            myView =itemView;
            card = (CardView) itemView.findViewById(R.id.myCard);
            ivprofile = (ImageView) itemView.findViewById(R.id.ivprofile);
            txtname = (TextView) itemView.findViewById(R.id.tvname);
            txtdesc = (TextView) itemView.findViewById(R.id.tvdesc);
            itemView.setOnCreateContextMenuListener(this);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onClick(getAdapterPosition());
                }
            });
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem Edit = menu.add(Menu.NONE, 1, 1, "Edit");
            MenuItem Delete = menu.add(Menu.NONE, 2, 2, "Delete");
            myPost =getAdapterPosition();
            Edit.setOnMenuItemClickListener(onEditMenu);
            Delete.setOnMenuItemClickListener(onEditMenu);
        }

    }
    private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId()) {
                case 1:
                    //Do stuff
                    Toast.makeText(myView.getContext(), ""+ myPost, Toast.LENGTH_SHORT).show();
                    break;

                case 2:
                    //Do stuff

                    break;
            }
            return true;
        }
    };

}