package com.example.facebooksdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.ShareDialog;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class FacebookPage extends AppCompatActivity {

    EditText editTitle, editDescription, editUrl;
    Button btShareLink, btShareImage, btPickVideo, btShareVideo;
    ImageView imageView;
    VideoView videoView;
    ShareDialog shareDialog;
    ShareLinkContent shareLinkContent;
    public static int Select_Image = 1;
    public static int Pick_Video = 2;
    Bitmap bitmap;
    Uri selectVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_page);
        Mapping();
        shareDialog = new ShareDialog(FacebookPage.this);

        btShareLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ShareDialog.canShow(ShareLinkContent.class))
                {
                    shareLinkContent = new ShareLinkContent.Builder()
                            .setContentTitle(editTitle.getText().toString())
                            .setContentDescription(editDescription.getText().toString())
                            .setContentUrl(Uri.parse(editUrl.getText().toString()))
                            .build();
                }
                shareDialog.show(shareLinkContent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, Select_Image);
            }
        });

        btShareImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharePhoto photo = new SharePhoto.Builder()
                        .setBitmap(bitmap)
                        .build();
                SharePhotoContent content = new SharePhotoContent.Builder()
                        .addPhoto(photo)
                        .build();
                shareDialog.show(content);
            }
        });

        btPickVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("video/*");
                startActivityForResult(intent, Pick_Video);
            }
        });

        btShareVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareVideo shareVideo = null;
                shareVideo = new ShareVideo.Builder()
                        .setLocalUrl(selectVideo)
                        .build();
                ShareVideoContent content = new ShareVideoContent.Builder()
                        .setVideo(shareVideo)
                        .build();
                shareDialog.show(content);
                videoView.stopPlayback();
            }
        });

    }

    private void Mapping() {
        editTitle = (EditText) findViewById(R.id.edittexttitle);
        editDescription = (EditText) findViewById(R.id.edittextdescription);
        editUrl = (EditText) findViewById(R.id.edittexturl);
        btShareLink = (Button) findViewById(R.id.buttonsharelink);
        btShareImage = (Button) findViewById(R.id.buttonshareimage);
        btPickVideo = (Button) findViewById(R.id.buttonpickvideo);
        btShareVideo = (Button) findViewById(R.id.buttonsharevideo);
        imageView = (ImageView) findViewById(R.id.imageviewimage);
        videoView = (VideoView) findViewById(R.id.videoviewvideo);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == Select_Image && resultCode == RESULT_OK)
        {
            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());
                bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (requestCode == Pick_Video && resultCode == RESULT_OK)
        {
            selectVideo = data.getData();
            videoView.setVideoURI(selectVideo);
            videoView.start();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
