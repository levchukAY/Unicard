package by.unicard.unicard;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;


public class UnicardApplication extends Application {

    private final static String APP_PREFERENCES = "APP_PREFERENCES";

    private static SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();

        sharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public static SharedPreferences getApplicationPreferences() {
        return sharedPreferences;
    }
}
