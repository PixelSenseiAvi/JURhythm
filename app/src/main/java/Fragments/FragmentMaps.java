package Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.yoavi.rando.HomeActivity;
import com.yoavi.rando.R;

/**
 * Created by Chikki on 1/22/2017.
 */

public class FragmentMaps extends Fragment implements OnMapReadyCallback{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.framelayout_maps,container,false);

        ((HomeActivity)getActivity()).setActionBarTitle("Maps");
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MapFragment mapFragment=(MapFragment)getChildFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng marker= new LatLng(26.7755336,75.87748590000001);

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(marker));

        googleMap.addMarker(new MarkerOptions().title("Welcome to JU!").position(marker));

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker, 16.0f));

    }
}
