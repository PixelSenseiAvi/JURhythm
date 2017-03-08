package Fragments;

import android.app.ActivityOptions;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.yoavi.rando.EventDetail1;
import com.yoavi.rando.R;


public class EventFragment2 extends Fragment{

    private final int[] imageIDs = {
            R.mipmap.bridgeomania,R.mipmap.cantelevo,R.mipmap.code,R.mipmap.coding,
            R.mipmap.code2,R.mipmap.exhibition,R.mipmap.gocart,R.mipmap.hackathon,R.mipmap.junkyardwars,
            R.mipmap.cs,R.mipmap.dota,R.mipmap.fifa,R.mipmap.nfs,R.mipmap.line,
            R.mipmap.rc_car,R.mipmap.robo1,R.mipmap.robo_soccer,R.mipmap.sumofighter,R.mipmap.robo2,
            R.mipmap.robo3,R.mipmap.azure_warrior,R.mipmap.plane

    };

    private final String[] textIDs={
            "BridgeOMania","Cantelevo","CodeBlast","CodeShuffle","CyberBytes","Exhibition","GoKart",
            "Hackathon","JunkYard Wars","CS 1.6","Dota-2","FIFA","NFS","Line Follower",
            "RC Car","Robo Race","Robo Soccer","Robo SumoWar","RoboWar Pro","RoboWar Rookie","Azure Warrior",
            "Ardhra The Airmate"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.technical,container,false);
        GridView gridView=(GridView)rootView.findViewById(R.id.technical_grid_view);
        gridView.setAdapter(new ImageAdapterTech(rootView.getContext()));
        return rootView;
    }

    private class ImageAdapterTech extends BaseAdapter {

        private final Context context;
        ImageAdapterTech(Context context) {
            this.context=context;
        }


        @Override
        public int getCount() {
            return textIDs.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, final ViewGroup parent) {
            View grid;
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (convertView == null) {

                grid = inflater.inflate(R.layout.technical_grid, null);

            } else {
                grid =convertView;
            }
            TextView textView = (TextView) grid.findViewById(R.id.t_grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.t_grid_image);
            textView.setText(textIDs[position]);

            imageView.setImageResource(imageIDs[position]);

            CardView cardView=(CardView)grid.findViewById(R.id.tech_card);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(context, EventDetail1.class);
                    Bundle b = new Bundle();
                    b.putInt("id", position);
                    b.putInt("event",1);
                    b.putInt("imageId",imageIDs[position]);
                    i.putExtras(b);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        startActivity(i, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
                    }
                    else {
                        startActivity(i);
                    }

                }
            });
            return grid;
        }
    }
}
