package Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yoavi.rando.HomeActivity;
import com.yoavi.rando.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentEvents extends Fragment {

   private ViewPager viewPager;

    public static FragmentEvents newInstance(){
        return new FragmentEvents();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.framelayout_events,container,false);


        ((HomeActivity)getActivity()).setActionBarTitle("Events");

        viewPager=(ViewPager)rootView.findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(ColorStateList.valueOf(Color.WHITE));
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        Bundle bundle = getArguments();
        if(bundle!=null){
            int i = bundle.getInt("index");
            viewPager.setCurrentItem(i);
        }else {
            viewPager.setCurrentItem(1);
        }
        tabLayout.setSelectedTabIndicatorHeight(7);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return rootView;
    }

    private void setupViewPager(ViewPager viewPager) {
        MyAdapter adapter = new MyAdapter(getChildFragmentManager());
        adapter.addFragment(new EventFragment1(), "Cultural");
        adapter.addFragment(new EventFragment2(), "Technical");
        adapter.addFragment(new EventFragment3(),"E-Summit");
        viewPager.setAdapter(adapter);
    }


    private class MyAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        MyAdapter(FragmentManager childFragmentManager) {
            super(childFragmentManager);
        }

        void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }
        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }

    }
}
