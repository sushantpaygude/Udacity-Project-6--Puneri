package com.example.sushant.udacityproject6_puneri;

import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sushant.udacityproject6_puneri.fragments.FifthFragment;
import com.example.sushant.udacityproject6_puneri.fragments.FirstFragment;
import com.example.sushant.udacityproject6_puneri.fragments.FourthFragment;
import com.example.sushant.udacityproject6_puneri.fragments.SecondFragment;
import com.example.sushant.udacityproject6_puneri.fragments.ThirdFragment;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationViewDrawer;
    Toolbar toolbar;
    DrawerLayout mDrawer;
    ActionBarDrawerToggle drawerToggle;
    View navigationHeader;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawer=(DrawerLayout)findViewById(R.id.drawer_layout);

        navigationViewDrawer=(NavigationView)findViewById(R.id.nvView);
        setupDrawerContent(navigationViewDrawer);

        drawerToggle=setupDrawerToggle();
        navigationHeader=navigationViewDrawer.inflateHeaderView(R.layout.navigation_header);
        setTitle("Puneri");

        TextView title_text=(TextView)findViewById(R.id.text_title);
        Typeface typeface=Typeface.createFromAsset(getAssets(),"fonts/samarkannormal.ttf");
        title_text.setTypeface(typeface);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    public void setupDrawerContent(NavigationView navigationViewDrawer)
    {
        navigationViewDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                selectDrawerItem(item);
                return true;
            }
        });
    }

    public void selectDrawerItem(MenuItem item)
    {
        mDrawer.closeDrawers();
        Fragment fragment=null;
        Class fragmentClass=null;

        switch (item.getItemId())
        {
                case R.id.nav_first_fragment:
                    fragmentClass= FirstFragment.class;
                    break;
                case R.id.nav_second_fragment:
                    fragmentClass= SecondFragment.class;
                    break;
                case R.id.nav_third_fragment:
                    fragmentClass= ThirdFragment.class;
                    break;
            case R.id.nav_fourth_fragment:
                fragmentClass= FourthFragment.class;
                break;
            case R.id.nav_fifth_fragment:
                fragmentClass= FifthFragment.class;
                break;
            default:
                fragmentClass = FirstFragment.class;
        }


        try {
                fragment=(Fragment)fragmentClass.newInstance();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        final Fragment finalFragment = fragment;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentManager fragmentManager=getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fLContent, finalFragment).commit();
            }
        },0);
        item.setChecked(true);
        setTitle(item.getTitle());
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

}
