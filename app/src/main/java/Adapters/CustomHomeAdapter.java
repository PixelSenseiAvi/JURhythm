package Adapters;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.yoavi.rando.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import Fragments.FragmentEvents;

/**
 * Created by Chikki on 1/22/2017.
 */

public class CustomHomeAdapter extends RecyclerView.Adapter<CustomHomeAdapter.ViewHolder> implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener{

    private final Context context;

    ImageView prizelayout;
    ImageView youtubeImage;
    private ImageView culturalImage;
    private ImageView technicalImage;
    private ImageView eSummitImage;
    private HashMap<String,String> Hash_file_maps ;

    final String API_KEY="AIzaSyAiH8vnqws4yWOzgIdpcK_tVKTv2ekQDpk";
    String VideoId="uhOoTXwxqco";

    private static final int RECOVERY_REQUEST = 1;

    public CustomHomeAdapter(Context context){
        this.context=context;
    }

    private final static int image_slider=0;
    private final static int quote=1;
    private final static int event=2;
    private final static int aboutJU=3;
    private final static int prize=4;
    private final static int video=5;
    private final static int sponsors=6;


    YouTubePlayerView youTubeView;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v1;
        RecyclerView.ViewHolder viewHolder = null;
        int loader = R.drawable.place_holder_icons;


        switch (viewType){
            case image_slider:
                v1=(CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_imageslider,parent,false);

                SliderLayout sliderLayout = (SliderLayout) v1.findViewById(R.id.slider);
                Hash_file_maps.put("Pre Rhythm", "https://i.ytimg.com/vi/_p_bYKDzItQ/maxresdefault.jpg");
                Hash_file_maps.put("Group Dance", "https://scontent.fjai1-1.fna.fbcdn.net/v/t1.0-9/1909771_722580251176878_1927527990392148075_n.jpg?oh=871a3a860785557c6d6ae6a7592d7823&oe=590442E2");
                Hash_file_maps.put("Skit", "https://scontent.fjai1-1.fna.fbcdn.net/v/t1.0-9/16473860_932589140175987_7256896487697934010_n.jpg?oh=ced2295d963ccbedfb9cfbf374a63cde&oe=59359FD2");
                Hash_file_maps.put("LPU-Participants","http://www.lpu.in/campus_life/images/art-and-culture/arts-achieve/full/ach23.jpg");
                Hash_file_maps.put("Face Painting", "https://scontent.fjai1-1.fna.fbcdn.net/v/t1.0-9/16649529_932587556842812_569766099220766461_n.jpg?oh=e90aa81c4adfa78ba222ce4285015cfa&oe=594570A0");
                Hash_file_maps.put("RC Car","https://scontent.fjai1-1.fna.fbcdn.net/v/t1.0-9/12795419_721612231273680_3356798788324615563_n.jpg?oh=65a777fd6c299a666205544966262171&oe=5939B9F1");
                Hash_file_maps.put("DJ War","https://scontent.fjai1-1.fna.fbcdn.net/v/t1.0-9/1898096_722582934509943_4289681328613586099_n.jpg?oh=0094abb690710c8759567005ffb0ecf6&oe=59360166");
                Hash_file_maps.put("Fashion Show","https://scontent.fjai1-1.fna.fbcdn.net/v/t1.0-9/10425875_722041477897422_2585943020105332658_n.jpg?oh=7049ad2012ade917ecb2d7ac57fd8b05&oe=594B0155");
                Hash_file_maps.put("Robo Soccer","https://scontent.fjai1-1.fna.fbcdn.net/v/t1.0-9/12799006_721610984607138_4479550200854527501_n.jpg?oh=9be35beda2ca1b9a831cde23123a5acc&oe=594664E5");


                for(String name : Hash_file_maps.keySet()){

                    TextSliderView textSliderView = new TextSliderView(context);
                    textSliderView
                            .description(name)
                            .image(Hash_file_maps.get(name))
                            .setScaleType(BaseSliderView.ScaleType.Fit)
                            .setOnSliderClickListener(this);
                    textSliderView.bundle(new Bundle());
                    textSliderView.getBundle()
                            .putString("extra",name);
                    sliderLayout.addSlider(textSliderView);
                }
                sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
                sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
                sliderLayout.setCustomAnimation(new DescriptionAnimation());
                sliderLayout.setDuration(3000);
                sliderLayout.addOnPageChangeListener(this);

                viewHolder = new ViewHolder(v1);
                break;
            case quote:
                v1=(CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_prize,parent,false);

                ImageView imgPrize = (ImageView) v1.findViewById(R.id.imgPrize);

                String imageUrl="http://oi68.tinypic.com/30mn584.jpg";

                Picasso.with(context)
                        .load(imageUrl).fit()
                        .into(imgPrize);

                viewHolder = new ViewHolder(v1);
                break;
            case event:
                v1=(CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_event,parent,false);

                culturalImage=(ImageView) v1.findViewById(R.id.imgCultural);

                Picasso.with(context)
                        .load("https://s27.postimg.org/rjpl8d7eb/MG_3070_min.jpg").fit()
                        .into(culturalImage);

                culturalImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final Animation animation = new AlphaAnimation(1, 0);
                        animation.setDuration(700);
                        animation.setInterpolator(new LinearInterpolator());
                        animation.setRepeatCount(2);
                        animation.setRepeatMode(Animation.REVERSE);
                        culturalImage.startAnimation(animation);

                        culturalImage.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                culturalImage.clearAnimation();
                                Fragment fragment = new FragmentEvents();
                                Bundle args= new Bundle();
                                int index = 0;
                                args.putInt("index",index);
                                fragment.setArguments(args);
                                FragmentManager fragmentManager = ((Activity) context).getFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.frame_home, fragment);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                        },1100);


                    }
                });

                culturalImage.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {

                        int cx = culturalImage.getWidth() / 2;
                        int cy = culturalImage.getHeight() / 2;

                        float finalRadius = (float) Math.hypot(cx, cy);

                        Animator anim =
                                null;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            anim = ViewAnimationUtils.createCircularReveal(culturalImage, cx, cy, 0, finalRadius);
                            anim.start();
                        }
                        culturalImage.setVisibility(View.VISIBLE);

                        return false;
                    }
                });

                technicalImage=(ImageView) v1.findViewById(R.id.imgTechnical);
                Picasso.with(context)
                        .load("http://ju-rhythm.com/img/img/fashion/DSC_0144-min.jpg").fit()
                        .into(technicalImage);
                technicalImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final Animation animation = new AlphaAnimation(1, 0);
                        animation.setDuration(700);
                        animation.setInterpolator(new LinearInterpolator());
                        animation.setRepeatCount(2);
                        animation.setRepeatMode(Animation.REVERSE);
                        technicalImage.startAnimation(animation);



                        technicalImage.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                technicalImage.clearAnimation();
                                Fragment fragment = new FragmentEvents();
                                Bundle args= new Bundle();
                                int index = 1;
                                args.putInt("index",index);
                                fragment.setArguments(args);
                                FragmentManager fragmentManager = ((Activity) context).getFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.frame_home, fragment);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                        },1100);


                    }
                });

                technicalImage.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int cx = technicalImage.getWidth() / 2;
                        int cy = technicalImage.getHeight() / 2;

                        float finalRadius = (float) Math.hypot(cx, cy);

                        Animator anim =
                                null;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            anim = ViewAnimationUtils.createCircularReveal(technicalImage, cx, cy, 0, finalRadius);
                            anim.start();
                        }

                        technicalImage.setVisibility(View.VISIBLE);

                        return false;
                    }
                });
                eSummitImage=(ImageView) v1.findViewById(R.id.imgESummit);

                Picasso.with(context)
                        .load("https://s28.postimg.org/9f8sj0l5p/esummit.jpg").fit()
                        .into(eSummitImage);

                eSummitImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final Animation animation = new AlphaAnimation(1, 0);
                        animation.setDuration(700);
                        animation.setInterpolator(new LinearInterpolator());
                        animation.setRepeatCount(2);
                        animation.setRepeatMode(Animation.REVERSE);
                        eSummitImage.startAnimation(animation);

                        eSummitImage.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                eSummitImage.clearAnimation();
                                Fragment fragment = new FragmentEvents();
                                Bundle args= new Bundle();
                                int index = 2;
                                args.putInt("index",index);
                                fragment.setArguments(args);
                                FragmentManager fragmentManager = ((Activity) context).getFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.frame_home, fragment);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                        },1100);


                    }
                });

                eSummitImage.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int cx = eSummitImage.getWidth() / 2;
                        int cy = eSummitImage.getHeight() / 2;

                        float finalRadius = (float) Math.hypot(cx, cy);

                        Animator anim =
                                null;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            anim = ViewAnimationUtils.createCircularReveal(eSummitImage, cx, cy, 0, finalRadius);
                            anim.start();
                        }

                        eSummitImage.setVisibility(View.VISIBLE);


                        return false;
                    }
                });
                viewHolder = new ViewHolder(v1);
                break;


            case aboutJU:
                v1=(CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_rhythm,parent,false);

                TextView aboutju = (TextView) v1.findViewById(R.id.aboutRhythm17);
                aboutju.setText(R.string.aboutJU);

                viewHolder = new ViewHolder(v1);
                break;

            case prize:
                v1=(CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_quote,parent,false);

                ImageView imgQuote = (ImageView)v1.findViewById(R.id.imgQuote);
                Picasso.with(context).
                        load("https://s29.postimg.org/7ymmia1hj/imp.jpg").placeholder(loader).
                        fit().into(imgQuote);

                viewHolder = new ViewHolder(v1);
                break;
            case video:
                v1=(CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_youtube,parent,false);

                ImageView youtube=(ImageView)v1.findViewById(R.id.callYoutube);
                youtube.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=uhOoTXwxqco")));
                    }
                });


                ImageView insta=(ImageView)v1.findViewById(R.id.callInsta);
                insta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Uri uri = Uri.parse("https://www.instagram.com/_u/ju.rhythm");
                        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                        likeIng.setPackage("com.instagram.android");

                        try {
                            context.startActivity(likeIng);
                        } catch (ActivityNotFoundException e) {
                            context.startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://www.instagram.com/ju_rhythm/")));
                        }
                    }
                });

                ImageView Whatsapp=(ImageView)v1.findViewById(R.id.callWhatsapp);
                Whatsapp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PackageManager pm=context.getPackageManager();
                        try {

                            Intent waIntent = new Intent(Intent.ACTION_SEND);
                            waIntent.setType("text/plain");

                            PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
                            waIntent.setPackage("com.whatsapp");

                            waIntent.putExtra(Intent.EXTRA_TEXT, "Beats of Imagination- fifth addition of JU Rhythm is back with more fun. I am going are you?" + "\n\n" + context.getResources().getText(R.string.shared_via));
                            context.startActivity(Intent.createChooser(waIntent, "Share with"));

                        } catch (PackageManager.NameNotFoundException e) {
                            Toast.makeText(context, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                });

                ImageView fb = (ImageView)v1.findViewById(R.id.callFacebook);
                fb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                        String facebookUrl = getFacebookPageURL(v.getContext());
                        facebookIntent.setData(Uri.parse(facebookUrl));
                        context.startActivity(facebookIntent);
                    }
                });


                viewHolder = new ViewHolder(v1);
                break;
            case sponsors:
                v1=(CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_sponsors,parent,false);
                ImageView logoImg= (ImageView) v1.findViewById(R.id.footer_image);
                Picasso.with(context).load("http://jecrcuniversity.edu.in/img/core/JU-Logo.png").fit()
                        .into(logoImg);
                TextView footer_text1=(TextView)v1.findViewById(R.id.footer_text1);
                footer_text1.setText(R.string.Address);
                TextView footerText2=(TextView)v1.findViewById(R.id.footer_text2);
                footerText2.setText(R.string.JUContact);
                footerText2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"Add intent",Toast.LENGTH_SHORT).show();
                    }
                });
                viewHolder = new ViewHolder(v1);
                break;
        }

        return (ViewHolder) viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == image_slider)
            return image_slider;
        else if (position== quote)
            return quote;
        else if(position==event)
            return event;
        else if(position==prize)
            return  prize;
        else if(position==video)
            return  video;
        else if(position==sponsors)
            return sponsors;
        else
            return aboutJU;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    class ViewHolder extends RecyclerView.ViewHolder {


        ViewHolder(View itemView) {
            super(itemView);


        }
    }



    private String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + "https://www.facebook.com/events/742211395933512/";
            } else { //older versions of fb app
                return "fb://page/" + "JURhythm/";
            }
        } catch (PackageManager.NameNotFoundException e) {
            return "https://www.facebook.com/events/742211395933512/"; //normal web url
        }
    }




    private Target picassoImageTarget(Context context, final String imageDir, final String imageName) {
        Log.d("picassoImageTarget", " picassoImageTarget");
        ContextWrapper cw = new ContextWrapper(context);
        final File directory = cw.getDir(imageDir, Context.MODE_PRIVATE); // path to /data/data/yourapp/app_imageDir
        return new Target() {
            @Override
            public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final File myImageFile = new File(directory, imageName); // Create image file
                        FileOutputStream fos = null;
                        try {
                            fos = new FileOutputStream(myImageFile);
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                assert fos != null;
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        Log.i("image", "image saved to >>>" + myImageFile.getAbsolutePath());

                    }
                }).start();
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
            }
            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
            }
        };
    }

}
