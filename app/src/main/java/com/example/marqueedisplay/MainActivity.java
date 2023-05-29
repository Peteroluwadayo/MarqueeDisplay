package com.example.marqueedisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.ImageReader;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TextView textView;


    public int currentimageindex=0;
    Timer timer;
    TimerTask task;
    ImageView image1;

    int[] IMAGE_IDS = {R.drawable.imagesmiiii, R.drawable.imageoooo, R.drawable.imagesssssss,R.drawable.imageswwww,R.drawable.imagekiii};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // casting of textview
        TextView textView= findViewById(R.id.text_view);

        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSelected(true);

        final Handler mHandler = new Handler();

        // Create runnable for posting
        final Runnable mUpdateResults = new Runnable() {
            public void run() {

                AnimateandSlideShow();

            }
        };

        int delay = 1000; // delay for 1 sec.

        int period = 8000; // repeat every 4 sec.

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                mHandler.post(mUpdateResults);

            }

        }, delay, period);

    }

    public void onClick(View v) {

        finish();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
    private void AnimateandSlideShow() {

        image1 = (ImageView)findViewById(R.id.image_1);
        image1.setImageResource(IMAGE_IDS[currentimageindex%IMAGE_IDS.length]);

        currentimageindex++;

    }

}





