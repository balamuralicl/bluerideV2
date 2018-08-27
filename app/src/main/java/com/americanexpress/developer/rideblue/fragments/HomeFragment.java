package com.americanexpress.developer.rideblue.fragments;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.americanexpress.developer.rideblue.SignInActivityWithDrive;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.SignInButton;
import android.widget.TextView;
import android.widget.Toast;

import com.americanexpress.developer.rideblue.R;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.tasks.Task;

import static com.americanexpress.developer.rideblue.MapsActivity.REQUEST_CODE;


public class HomeFragment extends Fragment  {

    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9003;

    private GoogleSignInClient mGoogleSignInClient;

    private TextView mStatusTextView;
    private TextView mTextMessage;
    private FragmentManager fragmentManager;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("in HomeFragment", "created");

        final View view;
        view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }



}