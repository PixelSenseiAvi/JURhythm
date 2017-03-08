package Fragments;

import android.app.ActivityOptions;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
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

/**
 * Created by Chikki on 1/22/2017.
 */
public class EventFragment1 extends Fragment {

    private final Integer[] imageIDs = {
            R.mipmap.rangoli, R.mipmap.roadies, R.mipmap.cartooning, R.mipmap.collage,
            R.drawable.slow_biking, R.mipmap.antakshri, R.mipmap.theater, R.mipmap.instrumental,
            R.mipmap.solo_song, R.drawable.band_war, R.drawable.face_painting, R.mipmap.mehendi,
            R.drawable.treasure, R.drawable.copy_cat, R.mipmap.debate, R.mipmap.quiz,
            R.drawable.solo_dance, R.drawable.miss_ju, R.mipmap.fashion_show, R.mipmap.master_chef,
            R.mipmap.kite, R.mipmap.thumb_painting, R.mipmap.standup_comedy, R.mipmap.poetry_reading,
            R.mipmap.rap, R.mipmap.jam, R.mipmap.classical,R.mipmap.hogathon,R.mipmap.g,
            R.mipmap.pot,R.mipmap.dj,R.mipmap.breakdancer,R.mipmap.paint
    };

    private final String[] textIDsC={"Rangoli","Roadies","Cartooning","Collage making","Slow Biking","Antakshri",
            "Skit/ Street Play","Instrumental","Solo Song","Band War","Face Painting","Mehendi",
    "Treasure-Hunt","Copy Cat","Debate","Quiz","Solo Dance","Mr/s Rhythm", "Fashion Show",
            "Rhythm Master Chef","Kite Fighting","Thumb Painting","StandUp Comedy","Photography","Rap War",
    "JAM","INDIAN Classical","Hogathon","Group Dance","Pot Designing","DJ War","Street Dance", "On Spot Painting"};




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.cultural,container,false);
        GridView gridView=(GridView)rootView.findViewById(R.id.cultural_grid_view);
        gridView.setAdapter(new ImageAdapter(rootView.getContext()));

        return rootView;
    }

    private class ImageAdapter extends BaseAdapter {
        private final Context context;

        ImageAdapter(Context context) {
            this.context=context;
        }

        @Override
        public int getCount() {
            return textIDsC.length;
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
                grid = inflater.inflate(R.layout.cultural_grid, null);
            } else {
                grid =convertView;
            }


            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(textIDsC[position]);

            imageView.setImageResource(imageIDs[position]);

            CardView cardView = (CardView)grid.findViewById(R.id.cultural_card);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, EventDetail1.class);
                   Bundle b = new Bundle();
                    b.putInt("id", position);
                    b.putInt("event", 0);
                    b.putInt("imageId",imageIDs[position]);
                    i.putExtras(b);
                    ActivityOptions options = ActivityOptions.makeScaleUpAnimation(parent, 0,
                            0, parent.getWidth(), parent.getHeight());
                    startActivity(i,options.toBundle());

                }
            });
            return grid;
        }
    }

}
