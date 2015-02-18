package com.frictionapp.friction;

import android.app.Activity;
import android.app.LauncherActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    //Fragment managing the behaviors, interactions and presentation of the navigation drawer.
    private NavigationDrawerFragment mNavigationDrawerFragment;
            
    //Used to store the last screen title. For use in {@link #restoreActionBar()}.


    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */

    public static boolean isSignedIn=false;
    public static Bundle sIS;
    private CharSequence mTitle;

    //ActionBar hamburger toggle
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (isSignedIn) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);

           mNavigationDrawerFragment = (NavigationDrawerFragment)
                   getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
           mTitle = getTitle();


           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);

           mNavigationDrawerFragment = (NavigationDrawerFragment)
                   getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
           mTitle = getTitle();

           // Set up the drawer.
           mNavigationDrawerFragment.setUp(
                   R.id.navigation_drawer,
                   (DrawerLayout) findViewById(R.id.drawer_layout));
       }

        else {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.initial_screen);
       }
    }


    public void loginButton(View e){
        isSignedIn = true;
        if (isSignedIn) {

            //super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mNavigationDrawerFragment = (NavigationDrawerFragment)
                    getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
            mTitle = getTitle();

            // Set up the drawer.
            mNavigationDrawerFragment.setUp(
                    R.id.navigation_drawer,
                    (DrawerLayout) findViewById(R.id.drawer_layout));
        }
      }


    public void signUpButton(View view) {
        setContentView(R.layout.general_information);
    }

    public void genInfoCont(View view) {

    }


    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, FeedFragment.newInstance(position+1))
                .commit();

    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                Log.d("NavDrawer", getString(R.string.title_section1) + " Selected");
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                Log.d("NavDrawer", getString(R.string.title_section2) + " Selected");
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                Log.d("NavDrawer", getString(R.string.title_section3) + " Selected");
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
                Log.d("NavDrawer", getString(R.string.title_section4) + " Selected");
                break;
            case 5:
                mTitle = getString(R.string.title_section5);
                Log.d("NavDrawer", getString(R.string.title_section5) + " Selected");
                break;
            case 6:
                mTitle = getString(R.string.title_section6);
                Log.d("NavDrawer", getString(R.string.title_section6) + " Selected");
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (isSignedIn && !mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class FeedFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        //init for viewing the feed
        private ListView feedView;
        private TextView Heading;
        private String[] myList = {"Put", "API", "Code", "Here"};

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static FeedFragment newInstance(int sectionNumber) {
            FeedFragment fragment = new FeedFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            Log.d("Init Fragments", "Fragment " + sectionNumber + " initialized");
            return fragment;
        }

        public FeedFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }

    }

}
