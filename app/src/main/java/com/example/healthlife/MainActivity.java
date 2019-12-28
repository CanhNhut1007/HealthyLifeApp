package com.example.healthlife;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthlife.signin.SignInPage;
import com.example.healthlife.signup.SignUpPage;

public class MainActivity extends AppCompatActivity {

    private VideoView videoViewBackground;
    MediaPlayer mediaPlayer;
    int currentVideoPosition;
    Button btSignIn, btSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mapping();

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.welcome_video);
        videoViewBackground.setVideoURI(uri);
        videoViewBackground.start();
        videoViewBackground.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer = mp;
                mediaPlayer.setLooping(true);
                if (currentVideoPosition != 0)
                {
                    mediaPlayer.seekTo(currentVideoPosition);
                    mediaPlayer.start();
                }
            }
        });

        SignInPage();
        SignUpPage();
    }

    private void Mapping() {
        videoViewBackground = (VideoView) findViewById(R.id.videoView);
        btSignIn = (Button) findViewById(R.id.buttonSignIn);
        btSignUp = (Button) findViewById(R.id.buttonSignUp);
    }

    @Override
    protected  void onPause() {
        super.onPause();
        currentVideoPosition = videoViewBackground.getCurrentPosition();
        videoViewBackground.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoViewBackground.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    private void SignInPage() {
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignInPage.class);
                startActivity(intent);
            }
        });
    }

    private void SignUpPage() {
        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpPage.class);
                startActivity(intent);
            }
        });
    }
}
