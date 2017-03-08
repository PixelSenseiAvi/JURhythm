package Fragments;

import android.animation.Animator;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;

import com.yoavi.rando.HomeActivity;
import com.yoavi.rando.R;

import Adapters.CustomHomeAdapter;

/**
 * Created by Chikki on 1/22/2017.
 */


public class FragmentHome extends Fragment {

    private FloatingActionButton fb;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootVIew= inflater.inflate(R.layout.framelayout_home,container,false);

        ((HomeActivity)getActivity()).setActionBarTitle("JU Rhythm 2017");

        fb = (FloatingActionButton)rootVIew.findViewById(R.id.fab);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int cx = fb.getWidth() / 2;
                int cy = fb.getHeight() / 2;

                float finalRadius = (float) Math.hypot(cx, cy);

                Animator anim =
                        null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    anim = ViewAnimationUtils.createCircularReveal(fb, cx, cy, 0, finalRadius);
                    anim.start();
                }
                fb.setVisibility(View.VISIBLE);


                String url = "https://www.thecollegefever.com/events/ju-rhythm-2017";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        RecyclerView recyclerView = (RecyclerView) rootVIew.findViewById(R.id.recyclerViewHome);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter hadapter = new CustomHomeAdapter(getActivity());
        recyclerView.setAdapter(hadapter);

        return rootVIew;
    }
}
