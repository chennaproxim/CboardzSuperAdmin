package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.Utils.AlertUtility;
import com.squareup.picasso.Picasso;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private ImageView mcmpnylogo;
    private TextView mcmpnyname, mcmpnymail;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle("");
        setSupportActionBar(toolbar);

        mcmpnylogo = (ImageView) findViewById(R.id.mcmpny_logo);
        mcmpnyname = (TextView) findViewById(R.id.mcmpny_name);
        mcmpnymail = (TextView) findViewById(R.id.mcmpny_mail);

        Bundle b = getIntent().getExtras();
        mcmpnyname.setText(b.getString("saname"));
        mcmpnymail.setText(b.getString("samail"));

        //Download .png or .jpeg
//        new GetImageFromUrl(mcmpnylogo).execute(b.getString("salogo"));

        Picasso.with(this).load(b.getString("salogo")).fit().into(mcmpnylogo);

        findViewById(R.id.comapnies_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CompaniesListActivity.class));
            }
        });
        findViewById(R.id.notice_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NoticeBoard.class));
            }
        });
        findViewById(R.id.wupport_main_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SupportActivity.class));
            }
        });
        findViewById(R.id.super_reports_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SuperReportsActivity.class));
            }
        });
    }


    //Class for download
    public class GetImageFromUrl extends AsyncTask<String, Void, Bitmap> {

        ImageView imageView;

        public GetImageFromUrl(ImageView imageview1) {
            this.imageView = imageview1;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String urldisplay = strings[0];
            mcmpnylogo = null;
            try {
                InputStream is = new java.net.URL(urldisplay).openStream();
                bitmap = BitmapFactory.decodeStream(is);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            AlertUtility.exit(MainActivity.this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        AlertUtility.exit(MainActivity.this);
    }
}
