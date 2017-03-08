package Fragments;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
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
public class EventFragment3 extends Fragment {

    private final Integer[] imageIDs = {
            R.mipmap.auction,
            R.mipmap.cricket,
    };

    private final String[] textIDs={
            "IPL Auction 2.0","Startup Cricket League"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.esummit,container,false);
        GridView gridView=(GridView)rootView.findViewById(R.id.ESummit_grid_view);
        gridView.setAdapter(new ImageAdapterESummit(rootView.getContext()));
        return rootView;
    }

    private class ImageAdapterESummit extends BaseAdapter {

        private final Context context;

        public ImageAdapterESummit(Context context) {
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

                grid = inflater.inflate(R.layout.esummit_grid, null);
            } else {
                grid =convertView;
            }

            TextView textView = (TextView) grid.findViewById(R.id.e_grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.e_grid_image);
            textView.setText(textIDs[position]);

            imageView.setImageResource(imageIDs[position]);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(context, EventDetail1.class);
                    Bundle b = new Bundle();
                    b.putInt("id", position);
                   b.putInt("event",2);
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
