package com.Jewelines.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.Jewelines.app.fragment.AbouttusFragment;
import com.Jewelines.app.fragment.ContactusFragment;
import com.Jewelines.app.fragment.QuoteFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private TextView toolbar_title;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mContext = this;
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");

        replessFragment(0);
        navigationView.setCheckedItem(R.id.nav_quote);

        initUI();

    }

    private void initUI() {


    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_quote) {
            replessFragment(0);
        } else if (id == R.id.nav_getinsured) {
            Intent mm = new Intent(HomeActivity.this, GetinsuredActivity.class);
            startActivity(mm);

        } else if (id == R.id.nav_contactus) {
            replessFragment(1);
        } else if (id == R.id.nav_aboutus) {
            replessFragment(2);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void replessFragment(int type) {
        if (type == 0) {
            fragment = new QuoteFragment();
            toolbar_title.setText("" + getResources().getString(R.string.menu_quote));
        } else if (type == 1) {
            fragment = new ContactusFragment();
            toolbar_title.setText("" + getResources().getString(R.string.menu_claim));
        } else if (type == 2) {
            fragment = new AbouttusFragment();
            toolbar_title.setText("" + getResources().getString(R.string.menu_aboutus));
        }
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, fragment).commit();


    }
}
