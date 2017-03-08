package Adapters;

import android.app.Activity;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yoavi.rando.R;

/**
 * Created by Chikki on 1/31/2017.
 */

public class ourTeamListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] ourName;
    private final String[] roles;
    private final String[] imageUrl={"http://ju-rhythm.com/img/img/team/deepamam.JPG",
            "http://ju-rhythm.com/img/img/team/Bhanu_Bhushan_Parashar-IT.jpg","http://ju-rhythm.com/img/img/team/gauravsir.jpg",
            "http://ju-rhythm.com/img/img/team/keshav%20sir.jpg",
            "http://ju-rhythm.com/img/img/team/technical.jpg","http://ju-rhythm.com/img/img/team/cultural.JPG",
            "http://ju-rhythm.com/img/img/team/ecell.jpg","http://ju-rhythm.com/img/img/team/prekshit.jpg",
            "https://avatars0.githubusercontent.com/u/19928721?v=3&u=8c7406a174bb63fe7b228371b87e4e64cab8288f&s=400",
    "http://ju-rhythm.com/img/img/team/prashant-pandey.jpg","https://devshekhawat.github.io/dev-pic.jpg",
            "https://scontent.fjai1-1.fna.fbcdn.net/v/t31.0-8/s960x960/15994715_1522951907732843_3588246371133662371_o.jpg?oh=9b72a5d584d36db81939baabed2cd93f&oe=59368255",
    "https://scontent.fjai1-1.fna.fbcdn.net/v/t1.0-9/r90/14925497_1147749745305574_7102407599039456663_n.jpg?oh=e104078474ff51e770b28f4dc482a8a9&oe=5940E7EA"};

    public ourTeamListAdapter(Activity context, String[] ourName, String[] roles) {
        super(context, R.layout.ourteamrow,ourName);

        this.context=context;
        this.ourName=ourName;
        this.roles=roles;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.ourteamrow,null,true);

        String[] contact = rowView.getResources().getStringArray(R.array.contactUs);

        TextView name=(TextView)rowView.findViewById(R.id.name_text);
        ImageView imageView=(ImageView)rowView.findViewById(R.id.our_image);
        TextView role =(TextView)rowView.findViewById(R.id.role);
        TextView email=(TextView)rowView.findViewById(R.id.email);

        name.setText(ourName[position]);
        name.setPaintFlags(name.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        Picasso.with(context)
                .load(imageUrl[position]).fit()
                .into(imageView);

        role.setText(roles[position]);

        email.setText(contact[position]);

        return rowView;
    }
}
