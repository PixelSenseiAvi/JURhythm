package Fragments;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.yoavi.rando.HomeActivity;
import com.yoavi.rando.R;

/**
 * Created by Chikki on 1/22/2017.
 */

public class FragmentContactUs extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.framelayout_contactus,container,false);
        ((HomeActivity)getActivity()).setActionBarTitle("Contact Us");

        ImageView ju =(ImageView)rootView.findViewById(R.id.juLogo);

        Picasso.with(getActivity()).load("http://jecrcuniversity.edu.in/img/core/JU-Logo.png").fit()
                .into(ju);



        final FloatingActionButton fabContact =(FloatingActionButton)rootView.findViewById(R.id.fabIcon);
        fabContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int cx = fabContact.getWidth() / 2;
                int cy = fabContact.getHeight() / 2;

                float finalRadius = (float) Math.hypot(cx, cy);

                Animator anim =
                        null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    anim = ViewAnimationUtils.createCircularReveal(fabContact, cx, cy, 0, finalRadius);
                    anim.start();
                }
                fabContact.setVisibility(View.VISIBLE);


                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 1800 102 5616"));
                startActivity(intent);

            }
        });

        return rootView;
    }




}
