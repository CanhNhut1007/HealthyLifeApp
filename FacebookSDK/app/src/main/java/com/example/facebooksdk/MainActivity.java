package com.example.facebooksdk;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    ProfilePictureView profilePictureView;
    LoginButton loginButton;
    Button btLogout, btShare;
    TextView txtName, txtMail, txtBirthDay;
    CallbackManager callbackManager;
    String Name, Mail, BirthDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main);
        Mapping();

        btLogout.setVisibility(View.INVISIBLE);
        btShare.setVisibility(View.INVISIBLE);
        txtName.setVisibility(View.INVISIBLE);
        txtMail.setVisibility(View.INVISIBLE);
        txtBirthDay.setVisibility(View.INVISIBLE);
        loginButton.setReadPermissions(Arrays.asList("public_profile", "email", "user_birthday"));
        setLogin_Button();
        setLogout_Button();
        NextPage();

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.facebooksdk",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }

    private void setLogin_Button()
    {
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                loginButton.setVisibility(View.INVISIBLE);
                btLogout.setVisibility(View.VISIBLE);
                btShare.setVisibility(View.VISIBLE);
                txtName.setVisibility(View.VISIBLE);
                txtMail.setVisibility(View.VISIBLE);
                txtBirthDay.setVisibility(View.VISIBLE);
                result();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    private void setLogout_Button() {
        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                btLogout.setVisibility(View.INVISIBLE);
                btShare.setVisibility(View.INVISIBLE);
                txtName.setVisibility(View.INVISIBLE);
                txtMail.setVisibility(View.INVISIBLE);
                txtBirthDay.setVisibility(View.INVISIBLE);
                txtName.setText("");
                txtMail.setText("");
                txtBirthDay.setText("");
                profilePictureView.setProfileId(null);
                loginButton.setVisibility(View.VISIBLE);
            }
        });
    }

    private void NextPage() {
        btShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FacebookPage.class);
                startActivity(intent);
            }
        });
    }

    private void result() {
        GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                Log.d("JSON", response.getJSONObject().toString());
                try {
                    Name = object.getString("name");
                    Mail = object.getString("email");
                    BirthDay = object.getString("birthday");

                    profilePictureView.setProfileId(Profile.getCurrentProfile().getId());
                    txtName.setText(Name);
                    txtMail.setText(Mail);
                    txtBirthDay.setText(BirthDay);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "name,email,birthday");
        graphRequest.setParameters(parameters);
        graphRequest.executeAsync();
    }

    public void Mapping()
    {
        profilePictureView = (ProfilePictureView) findViewById(R.id.imageProfilePictureView);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        btLogout = (Button) findViewById(R.id.buttonlogout);
        btShare = (Button) findViewById(R.id.buttonshare);
        txtName = (TextView) findViewById(R.id.textviewname);
        txtMail = (TextView) findViewById(R.id.textviewmail);
        txtBirthDay = (TextView) findViewById(R.id.textviewbirthday);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        LoginManager.getInstance().logOut();
        super.onStart();
    }
}
