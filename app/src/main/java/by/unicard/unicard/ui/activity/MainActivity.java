package by.unicard.unicard.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import by.unicard.unicard.R;
import by.unicard.unicard.ui.fragment.CategoriesFragment;
import by.unicard.unicard.ui.fragment.DiscountsFragment;
import by.unicard.unicard.ui.fragment.MapFragment;
import by.unicard.unicard.ui.fragment.ProfileFragment;
import by.unicard.unicard.utils.PreferencesUtils;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!PreferencesUtils.isEventPassed(PreferencesUtils.PREF_IS_LOGGED_IN)) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment newFragment = null;
                switch (item.getItemId()) {
                    case R.id.navigation_discounts:
                        newFragment = new DiscountsFragment();
                        mTextMessage.setText(R.string.title_discounts);
                        return true;
                    case R.id.navigation_map:
                        newFragment = new MapFragment();
                        mTextMessage.setText(R.string.title_map);
                        return true;
                    case R.id.navigation_categories:
                        newFragment = new CategoriesFragment();
                        mTextMessage.setText(R.string.title_categories);
                        return true;
                    case R.id.navigation_profile:
                        newFragment = new ProfileFragment();
                        mTextMessage.setText(R.string.title_profile);
                        return true;
                }
                replaceFragment(newFragment);
                return true;
            }
        });
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment).commit();
    }

}
