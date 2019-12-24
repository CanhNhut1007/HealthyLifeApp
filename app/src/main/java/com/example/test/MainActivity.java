package com.example.test;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    String URL_GET = "http://192.168.1.107/android/getdata.php";
    String URL_POST = "http://192.168.1.107/android/post.php";
    String URL_LOGIN = "http://192.168.1.107/android/loginapp.php";

    EditText edtEmail, edtTypeAccount, edtPassword;
    Button btViewData;
    TextView txtEmail;
    RequestQueue requestQueue;
    String email, typeaccount, password;
    String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        requestQueue = Volley.newRequestQueue(this);
        Mapping();

        btViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GetData();
                //PostData();
                //email = edtEmail.getText().toString();
                //password = edtPassword.getText().toString();
                //Post(email, password);
                //DownloadJSON downloadJSON = new DownloadJSON();
                //downloadJSON.execute(URL_APPS);
                /*email = edtEmail.getText().toString();
                password = edtPassword.getText().toString();
                type="login";
                DownloadJSON downloadJSON = new DownloadJSON();
                downloadJSON.execute(type, email, password);*/
                //Login();
                LoginApp();
            }
        });



    }

    private void Mapping()
    {
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtTypeAccount = (EditText) findViewById(R.id.edtTypeAccount);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btViewData = (Button) findViewById(R.id.btViewData);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

    }

    private void LoginApp() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplication(), response, Toast.LENGTH_SHORT).show();
                JSONObject obj;

                try {
                    obj = new JSONObject(response);

                    edtTypeAccount.setText((obj.getString("AccountID")));


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error+"", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                String Email = edtEmail.getText().toString();
                String Pass = edtPassword.getText().toString();
                params.put("email", Email);
                params.put("pass", Pass);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void GetData() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL_GET, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    //JSONArray array = new JSONArray(response);
                    //JSONObject view = array.getJSONObject(0);
                    email = response.getString("AccountEmail");
                    typeaccount = response.getString("TypeOfAccountID");
                    password = response.getString("HashPassword");
                    edtEmail.setText(email);
                    edtTypeAccount.setText(typeaccount);
                    edtPassword.setText(password);
                    //alertDialog.setMessage("Success");
                    //alertDialog.show();


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    private void PostData()
    {
        Map<String, String> params = new HashMap();
        params.put("email", edtEmail.getText().toString());
        params.put("pass", edtPassword.getText().toString());

        JSONObject jsonObject = new JSONObject(params);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL_POST, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplication(), response+"", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }

    private void Post(String email, String password) {
        String loginURL="http://192.168.0.101/android/login1.php";

        try {
            URL url=new URL(loginURL);

            HttpURLConnection httpURLConnection= (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream= httpURLConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter= new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            String login_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") +
                    "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
            bufferedWriter.write(login_data);
            bufferedWriter.flush();
            bufferedWriter.close();



            InputStream inputStream=httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

            String line="";
            StringBuilder dulieu=new StringBuilder();
            while((line=bufferedReader.readLine()) !=null)
            {
                dulieu.append(line);
            }
            Log.d("Kiểm tra", dulieu.toString());

            JSONObject obj;

            try {
                obj = new JSONObject(dulieu.toString());

                edtTypeAccount.setText((obj.getString("AccountID")));

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        catch ( MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void Login() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_POST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplication(), response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error+"", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                String Email = edtEmail.getText().toString();
                String Pass = edtPassword.getText().toString();
                params.put("email", Email);
                params.put("pass", Pass);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public class DownloadJSON extends AsyncTask<String,String,String>
    {

        @Override
        protected String doInBackground(String... strings) {

            String loginURL="http://192.168.0.101/android/login1.php";

            try {
                URL url=new URL(loginURL);

                HttpURLConnection httpURLConnection= (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream= httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter= new OutputStreamWriter(outputStream, "UTF-8");
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                String login_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(strings[1], "UTF-8") +
                        "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(strings[2], "UTF-8");
                bufferedWriter.write(login_data);
                bufferedWriter.flush();
                bufferedWriter.close();



                InputStream inputStream=httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

                String line="";
                StringBuilder dulieu=new StringBuilder();
                while((line=bufferedReader.readLine()) !=null)
                {
                    dulieu.append(line);
                }
                Log.d("Kiểm tra", dulieu.toString());
                publishProgress(dulieu.toString());
            }
            catch ( MalformedURLException e)
            {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            String arr[];
            JSONObject obj;

            try {
                obj = new JSONObject(values[0]);

                edtTypeAccount.setText((obj.getString("AccountID")));



            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }

    public static class UpdateJSON extends AsyncTask<String, String, String>
    {
        Context context;
        UpdateJSON(Context ctx){
            context=ctx;
        }
        @Override
        protected String doInBackground(String... strings) {
            String type=strings[0];
            String loginURL="http://192.168.0.101/android/login1.php";
            String regURL="http://192.168.0.101/Example/andphpreg.php";
            if(type.equals("reg")){
                String name= strings[1];
                String address=strings[2];
                String email= strings[3];
                String username=strings[4];
                String password=strings[5];
                try{
                    URL url= new URL(regURL);
                    try{
                        HttpURLConnection httpURLConnection= (HttpURLConnection)url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream= httpURLConnection.getOutputStream();
                        OutputStreamWriter outputStreamWriter= new OutputStreamWriter(outputStream, "UTF-8");
                        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                        String insert_data = URLEncoder.encode("name", "UTF-8")+"="+URLEncoder.encode(name, "UTF-8")+
                                "&"+URLEncoder.encode("address", "UTF-8")+"="+URLEncoder.encode(address, "UTF-8")+
                                "&"+URLEncoder.encode("email", "UTF-8")+"="+URLEncoder.encode(email, "UTF-8")+
                                "&"+URLEncoder.encode("username", "UTF-8")+"="+URLEncoder.encode(username, "UTF-8")+
                                "&"+URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");
                        bufferedWriter.write(insert_data);
                        bufferedWriter.flush();
                        bufferedWriter.close();



                        InputStream inputStream= httpURLConnection.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        String result="";
                        String line="";
                        StringBuilder stringBuilder= new StringBuilder();
                        while ((line=bufferedReader.readLine())!=null){
                            stringBuilder.append(line).append("\n");

                        }
                        result=stringBuilder.toString();
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }else if(type.equals("login")) {
                String user_name = strings[1];
                String pass_word = strings[2];
                try {
                    URL url = new URL(loginURL);
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                        String login_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") +
                                "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(pass_word, "UTF-8");
                        bufferedWriter.write(login_data);
                        bufferedWriter.flush();
                        bufferedWriter.close();

                        InputStream inputStream= httpURLConnection.getInputStream();
                        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

                        String line="";
                        StringBuilder dulieu=new StringBuilder();
                        while((line=bufferedReader.readLine()) !=null)
                        {
                            dulieu.append(line);
                        }
                        Log.d("Kiểm tra", dulieu.toString());
                        publishProgress(dulieu.toString());

                        /*InputStream inputStream = httpURLConnection.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        String result = "";
                        String line = "";
                        StringBuilder stringBuilder = new StringBuilder();
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");

                        }
                        //publishProgress(stringBuilder.append(line).toString());
                        result = stringBuilder.toString();
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;*/
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return null;
            }

            return null;
        }

        /*@Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

        }*/

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected void onPostExecute(String s) {
            Toast.makeText(context, s, Toast.LENGTH_LONG).show();
            //super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            String arr[];
            JSONObject obj;

            try {
                obj = new JSONObject(values[0]);

                //edtEmail.setText(obj.getString("AccountEmail"));
                //edtTypeAccount.setText((obj.getString("TypeOfAccountID")));
                //edtPassword.setText(obj.getString("HashPassword"));


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
