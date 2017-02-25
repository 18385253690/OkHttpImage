package com.example.john.okhttp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    Button downloadBtn;
    ImageView mImage;
    private final String URL = "http://serviceapi.skholingua.com/images/skholingua_image.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadBtn = (Button) findViewById(R.id.button1);
        mImage = (ImageView) findViewById(R.id.imageView1);

        downloadBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                downloadBtn.setVisibility(View.INVISIBLE);
                OkHttpHandler handler = new OkHttpHandler();
                byte[] image = new byte[0];

                try {
                    image = (byte[]) handler.execute(URL).get();

                    if (image != null && image.length > 0) {

                        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0,
                                image.length);
                        mImage.setImageBitmap(bitmap);
                        mImage.setVisibility(View.VISIBLE);
                    }

                } catch (Exception e) {
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}