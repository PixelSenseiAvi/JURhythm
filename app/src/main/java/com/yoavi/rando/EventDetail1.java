package com.yoavi.rando;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class EventDetail1 extends ActionBarActivity {


    private String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("eventDetails.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);

        if(getSupportActionBar()!=null)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ImageView eventImage = (ImageView) findViewById(R.id.eventImage1);
        TextView e_prize = (TextView) findViewById(R.id.e_prize);
        TextView e_fees = (TextView) findViewById(R.id.e_fees);
        TextView e_rules = (TextView) findViewById(R.id.rules);
        Button register = (Button) findViewById(R.id.registerNow);
        TextView coordinator = (TextView) findViewById(R.id.coordinator);
        TextView contact = (TextView) findViewById(R.id.contact_detail);
        Button button = (Button) findViewById(R.id.more);

        Bundle b = getIntent().getExtras();
        int eventType = b.getInt("event");
        final int id = b.getInt("id");
        int image = b.getInt("imageId");
        eventImage.setImageResource(image);

        final int[] CulturalArray = {14, 31, 15, 11, 30, 25, 6, 26, 0, 23, 12, 8, 34, 10, 19, 21, 16, 3, 32, 4, 29, 9, 2, 28, 24, 20, 26, 5, 17, 7,33,18,13};
        final int[] TechnicalArray = {49, 50, 42, 27, 1, 53, 54, 41, 36, 46, 43, 45, 44, 39, 38, 52, 40, 51, 37, 35, 47,48};
        final int[] eSummitArray = {56, 55};
        String jsonString = loadJSONFromAsset();
        String name, fees, prize;
        String co_name,co_contact;
        String link;

        JSONArray rules;
        try {
            JSONArray jsonArray = new JSONArray(jsonString);

            if (eventType == 2) {

                JSONObject jsonobject = jsonArray.getJSONObject(eSummitArray[id]);
                name = jsonobject.getString("name");
                getSupportActionBar().setTitle(name);

                link=jsonobject.getString("link");

                co_name=jsonobject.getString("coordinator");
                coordinator.setText(co_name);
                co_contact=jsonobject.getString("contact");
                contact.setText(co_contact);

                fees = jsonobject.getString("fee");
                e_fees.setText(fees);
                prize = jsonobject.getString("price");
                e_prize.setText(prize);
                rules = jsonobject.getJSONArray("rules");
                int len = rules.length();
                ArrayList<String> rulesArray = new ArrayList<>();
                for (int j = 0; j < len; j++) {
                    String ruleno = rules.getString(j);
                    rulesArray.add(ruleno);
                }
                for (int k = 0; k < rulesArray.size(); k++) {
                    e_rules.append(rulesArray.get(k));
                    e_rules.append("\n");
                }

                final String finalLink = link;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(finalLink));
                            startActivity(i);
                        }catch (Exception e){
                            Toast.makeText(EventDetail1.this,"Sorry Something went wrong",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }

            if (eventType == 0) {

                JSONObject jsonobject = jsonArray.getJSONObject(CulturalArray[id]);
                name = jsonobject.getString("name");

                getSupportActionBar().setTitle(name);
                link=jsonobject.getString("link");

                fees = jsonobject.getString("fee");
                e_fees.setText(fees);
                prize = jsonobject.getString("price");
                e_prize.setText(prize);

                co_name=jsonobject.getString("coordinator");
                coordinator.setText(co_name);
                co_contact=jsonobject.getString("contact");
                contact.setText(co_contact);

                rules = jsonobject.getJSONArray("rules");
                int len = rules.length();
                ArrayList<String> rulesArray = new ArrayList<>();
                for (int j = 0; j < len; j++) {
                    String ruleno = rules.getString(j);
                    rulesArray.add(ruleno);
                }
                for (int k = 0; k < rulesArray.size(); k++) {
                    e_rules.append(rulesArray.get(k));
                    e_rules.append("\n");
                }

                final String finalLink1 = link;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(finalLink1));
                            startActivity(i);
                        }catch (Exception e){
                            Toast.makeText(EventDetail1.this,"Sorry Something went wrong",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            if (eventType == 1){

                JSONObject jsonobject = jsonArray.getJSONObject(TechnicalArray[id]);
                name = jsonobject.getString("name");

                getSupportActionBar().setTitle(name);
                link=jsonobject.getString("link");

                co_name=jsonobject.getString("coordinator");
                coordinator.setText(co_name);
                co_contact=jsonobject.getString("contact");
                contact.setText(co_contact);

                fees = jsonobject.getString("fee");
                e_fees.setText(fees);
                prize = jsonobject.getString("price");
                e_prize.setText(prize);
                rules = jsonobject.getJSONArray("rules");
                int len = rules.length();
                ArrayList<String> rulesArray = new ArrayList<>();
                for (int j = 0; j < len; j++) {
                    String ruleno = rules.getString(j);
                    rulesArray.add(ruleno);
                }
                for (int k = 0; k < rulesArray.size(); k++) {
                    e_rules.append(rulesArray.get(k));
                    e_rules.append("\n");
                }

                final String finalLink2 = link;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(finalLink2));
                            startActivity(i);
                        }catch (Exception e){
                            Toast.makeText(EventDetail1.this,"Sorry Something went wrong",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.thecollegefever.com/events/ju-rhythm-2017";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


    }
}