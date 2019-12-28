package prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class UserInfo {
    private static final String TAG = UserSession.class.getSimpleName();
    private static final String PREF_NAME = "userinfo";
    private static final String KEY_TYPEACCOUNT = "typeaccount";
    private static final String KEY_EMAIL = "email";
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public UserInfo(Context ctx) {
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences(PREF_NAME, ctx.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setUsername(String typeaccount){
        editor.putString(KEY_TYPEACCOUNT, typeaccount);
        editor.apply();
    }

    public void setEmail(String email){
        editor.putString(KEY_EMAIL, email);
        editor.apply();
    }

    public void clearUserInfo(){
        editor.clear();
        editor.commit();
    }

    public String getKeyUsername(){return prefs.getString(KEY_TYPEACCOUNT, "");}

    public String getKeyEmail(){return prefs.getString(KEY_EMAIL, "");}
}
