package Fragments;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.yoavi.rando.HomeActivity;
import com.yoavi.rando.R;

import Adapters.ourTeamListAdapter;

public class FragmentDev extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.framelayout_developers,container,false);

        ((HomeActivity)getActivity()).setActionBarTitle("Our Team");
        Resources res = getResources();
        String[] names = res.getStringArray(R.array.Mentors);
        String[] roles= rootView.getResources().getStringArray(R.array.roles);

        GridView MgridView =(GridView)rootView.findViewById(R.id.mentors_grid_view);

        ourTeamListAdapter adapter1= new ourTeamListAdapter(getActivity(), names,roles);
        MgridView.setAdapter(adapter1);

        return rootView;
    }

}
