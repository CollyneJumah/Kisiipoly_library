package com.library.kisiipoly;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

//    member variable
  private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        referencing toolbar to be displayed
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

//        ===============================

        drawerLayout=findViewById(R.id.mainDrawerlayout);
//        adding menu button===============================


        NavigationView navigationView= findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState ==null) {
            Toast.makeText(this, "Welcome to Home page", Toast.LENGTH_LONG);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new homeFrag()).commit();

            navigationView.setCheckedItem(R.id.menu_home);
        }

    }


// on menu select


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_home:
                Toast.makeText(this,"Welcome to Home page", Toast.LENGTH_LONG);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new homeFrag()).commit();
                break;
            case R.id.menu_membership:
                Toast.makeText(this,"Membership", Toast.LENGTH_LONG);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new membershipFrag()).commit();
                break;
            case R.id.menu_secu_libraryMaterial:
                Toast.makeText(this,"Welcome to Online Course Application", Toast.LENGTH_LONG);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new securityLibM()).commit();
                break;
            case R.id.menu_eresource:
                Toast.makeText(this,"Welcome to e-Resources", Toast.LENGTH_LONG);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new eResourcesFrag()).commit();
                break;
            case R.id.menu_requirements:
                Toast.makeText(this,"Library Requirements", Toast.LENGTH_LONG);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new requirementsFrag()).commit();
                break;
            case R.id.menu_conduct:
                Toast.makeText(this,"Welcome to Academic Programs offered", Toast.LENGTH_LONG);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new conductFrag()).commit();
                break;
            case R.id.menu_operationhr:
                Toast.makeText(this,"Welcome to Download Resources", Toast.LENGTH_LONG);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new operationHrFrag()).commit();
                break;
            case R.id.menu_share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Welcome to Kisiipoly Library App.Access of all services.";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Kisiipoly Library");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;
            case R.id.menu_penalty:
                Toast.makeText(this,"Penalty", Toast.LENGTH_LONG);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new penaltyFrag()).commit();
                break;
            case R.id.menu_faq:
                Toast.makeText(this,"Welcome to Information page", Toast.LENGTH_LONG);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new faqFrag()).commit();
                break;
            case R.id.menu_site:
                Toast.makeText(this,"Welcome to Library Main Site", Toast.LENGTH_LONG);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new siteFrag()).commit();
                break;
            case R.id.menu_borrowing:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new borrowingFrag()).commit();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}
