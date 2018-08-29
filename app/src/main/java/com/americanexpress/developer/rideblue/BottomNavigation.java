
package com.americanexpress.developer.rideblue;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import com.americanexpress.developer.rideblue.fragments.BottomNVFragment;
import com.americanexpress.developer.rideblue.fragments.HomeFragment;
import com.americanexpress.developer.rideblue.fragments.*;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

public class BottomNavigation extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener,
        OnMapReadyCallback

{

    private TextView mTextMessage;
    private FragmentManager fragmentManager;
    Fragment fragment = null;
    GoogleSignInOptions gso;
    GoogleSignInAccount account;
    HomeFragment mapFragment;
    Bundle data ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("in bottom","inten2");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);


        mapFragment = new HomeFragment();


        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestScopes(new Scope(Scopes.DRIVE_APPFOLDER))
                .requestEmail()
                .build();
        account = GoogleSignIn.getLastSignedInAccount(this);
        data = new Bundle();

        //loading the default fragment
        //loadFragment(new HomeFragment());

        BottomNavigationView bnv = (BottomNavigationView) findViewById(R.id.navigation);

        bnv.setOnNavigationItemSelectedListener(this);



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navigation_home:
                methodForHomeFragment();

                break;

            case R.id.navigation_account:
                methodForAccountFragment();

                break;

            case R.id.navigation_trips:
                methodForTripsFragment();
                break;

            case R.id.navigation_notifications:
                methodForNotificationFragment();
                break;


        }

        return loadFragment(fragment);

    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
   /*     if (fragment != null && (!fragment.equals(new HomeFragment()))) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }else {
            Log.i("comming to methd", "home");
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mapframe, fragment)
                    .commit();
            return true;

        }*/

        if (fragment != null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;


    }

    public void methodForAccountFragment() {
        fragment = new AccountFragment();



        String  userName = String.valueOf(account.getDisplayName());
        data.putString("username", userName);
        fragment.setArguments(data);

        String  userGmail = String.valueOf(account.getEmail());
        data.putString("usergmail", userGmail);
        fragment.setArguments(data);

        String imageURL = String.valueOf(account.getPhotoUrl());
        data.putString("imageurl", imageURL);
        fragment.setArguments(data);

        String tokenID = String.valueOf(account.getIdToken());
        data.putString("tokenID", tokenID);
        fragment.setArguments(data);


    }


    public void methodForTripsFragment() {
        fragment = new TripsFragment();


        //     String  token = String.valueOf(account.getIdToken());

        // method to get trip details



    }

    public void methodForNotificationFragment() {
        fragment = new NotificationsFragment();
        //     String  token = String.valueOf(account.getIdToken());
        // method to show notifications like thanks messages to the user


    }

    public void methodForHomeFragment() {
        fragment = new HomeFragment();

        //      String  token = String.valueOf(account.getIdToken());
        // method to show notifications like thanks messages to the user


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

  /*  @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode == HomeFragment.MY_PERMISSIONS_REQUEST_LOCATION){
            mapFragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }*/
}


