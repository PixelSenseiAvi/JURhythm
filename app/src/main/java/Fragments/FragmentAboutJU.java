package Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.yoavi.rando.HomeActivity;
import com.yoavi.rando.R;

import java.util.HashMap;

/**
 * Created by Chikki on 2/9/2017.
 */

public class FragmentAboutJU extends Fragment {

    HashMap<String,String> Hash_file ;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.framelayout_about,container,false);

       // ImageView imageView=(ImageView)rootView.findViewById(R.id.JUimage);
        //Picasso.with(getActivity())
          //      .load("https://i.ytimg.com/vi/ao2lPnhIb18/maxresdefault.jpg").fit()
            //    .into(imageView);

        ((HomeActivity)getActivity()).setActionBarTitle("About JU");
        SliderLayout sliderShow = (SliderLayout) rootView.findViewById(R.id.sliderJU);
        HashMap<String,String> url_maps = new HashMap<>();
        url_maps.put("Campus @JU", "https://i.ytimg.com/vi/ao2lPnhIb18/maxresdefault.jpg");
        url_maps.put("Attractions", "http://getmyuni.azureedge.net/college-image/big/jecrc-university-jecrcu-jaipur.jpg");

        for (String name : url_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            textSliderView
                    .description(name)
                    .image(url_maps.get(name));

            sliderShow.addSlider(textSliderView);
        }

        TextView jutext=(TextView)rootView.findViewById(R.id.aboutjuText);
        jutext.setText(R.string.aboutJU2);

        return rootView;
    }
}
