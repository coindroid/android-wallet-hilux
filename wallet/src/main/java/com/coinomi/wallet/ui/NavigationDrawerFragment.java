package com.coinomi.wallet.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.coinomi.wallet.R;
import com.coinomi.wallet.ui.common.BaseFragment;

import java.util.List;

import static com.coinomi.wallet.Constants.ADD_COINS_LOCKED;
import static com.coinomi.wallet.Constants.USE_FULL_TOP;

/**
 * Fragment used for managing interactions for and presentation of a navigation drawer.
 * See the <a href="https://developer.android.com/design/patterns/navigation-drawer.html#Interaction">
 * design guidelines</a> for a complete explanation of the behaviors implemented here.
 */
public class NavigationDrawerFragment extends BaseFragment {
    /**
     * Remember the position of the selected item.
     */
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    /**
     * Per the design guidelines, you should show the drawer on launch until the user manually
     * expands it. This shared preference tracks this.
     */
    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

    /**
     * A pointer to the current callbacks instance (the Activity).
     */
    private Listener listener;

    /**
     * Helper component that ties the action bar to the navigation drawer.
     */
    private ActionBarDrawerToggle mDrawerToggle;

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerListView;
    private ListView mDrawerListViewUseful;
    private View mFragmentContainerView;

    private LinearLayout top;
    private LinearLayout bottom;

    private int mCurrentSelectedPosition = 0;
    private int mCurrentSelectedPositionUseful = 0;
    private boolean mFromSavedInstanceState;
    private boolean mUserLearnedDrawer;
    private NavDrawerListAdapter listAdapter;
    private NavDrawerListAdapter listAdapterUseful;

    private Button addCoins;

    public NavigationDrawerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Read in the flag indicating whether or not the user has demonstrated awareness of the
        // drawer. See PREF_USER_LEARNED_DRAWER for details.
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);

        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
            mFromSavedInstanceState = true;
        }

        // Select either the default item (0) or the last selected item.
        selectItem(mCurrentSelectedPosition);
        selectItemUseful(mCurrentSelectedPositionUseful);
    }


    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Indicate that this fragment would like to influence the set of actions in the action bar.
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

        top = view.findViewById(R.id.llTop);
        bottom = view.findViewById(R.id.llBottom);

        useFullLocation(USE_FULL_TOP, view);

        mDrawerListView.setOnItemClickListener((parent, view1, position, id) -> selectItem(position));
        mDrawerListViewUseful.setOnItemClickListener((parent, view1, position, id) -> selectItemUseful(position));

        addCoins = view.findViewById(R.id.add_coins);
        addCoins.setOnClickListener(v -> addCoins());
        if(ADD_COINS_LOCKED) addCoins.setVisibility(View.GONE);

        return view;
    }

    public void useFullLocation(boolean topLocation, View view) {
        if(topLocation) {
            mDrawerListView = view.findViewById(R.id.coins_list_top);
            mDrawerListViewUseful = view.findViewById(R.id.useful_top);
            bottom.setVisibility(View.GONE);
        } else {
            mDrawerListView = view.findViewById(R.id.coins_list_bottom);
            mDrawerListViewUseful = view.findViewById(R.id.useful_bottom);
            top.setVisibility(View.GONE);
        }
    }

    public boolean isDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
    }

    public void closeDrawer() {
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(mFragmentContainerView);
        }
    }

    /**
     * Users of this fragment must call this method to set up the navigation drawer interactions.
     * @param fragmentId   The android:id of this fragment in its activity's layout.
     * @param drawerLayout The DrawerLayout containing this fragment's UI.
     * @param navDrawerItems The items contained in the drawer
     */
    public void setUp(int fragmentId, DrawerLayout drawerLayout,
                      List<NavDrawerItem> navDrawerItems, List<NavDrawerItem> navDrawerItemsUseful) {
        mFragmentContainerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        // set up the drawer's list view with items and click listener

        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the navigation drawer and the action bar app icon.
        mDrawerToggle = new ActionBarDrawerToggle(
                getActivity(),                    /* host Activity */
                mDrawerLayout,                    /* DrawerLayout object */
                R.string.navigation_drawer_open,  /* "open drawer" description for accessibility */
                R.string.navigation_drawer_close  /* "close drawer" description for accessibility */
        ) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (!isAdded()) {
                    return;
                }

                getActivity().supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!isAdded()) {
                    return;
                }

                if (!mUserLearnedDrawer) {
                    // The user manually opened the drawer; store this flag to prevent auto-showing
                    // the navigation drawer automatically in the future.
                    mUserLearnedDrawer = true;
                    SharedPreferences sp = PreferenceManager
                            .getDefaultSharedPreferences(getActivity());
                    sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true).apply();
                }

                getActivity().supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }
        };

        // If the user hasn't 'learned' about the drawer, open it to introduce them to the drawer,
        // per the navigation drawer design guidelines.
        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            mDrawerLayout.openDrawer(mFragmentContainerView);
        }

        // Defer code dependent on restoration of previous instance state.
        mDrawerLayout.post(() -> mDrawerToggle.syncState());

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        listAdapter = new NavDrawerListAdapter(getActivity(), navDrawerItems);
        mDrawerListView.setAdapter(listAdapter);
        mDrawerListView.setItemChecked(mCurrentSelectedPosition, true);

        listAdapterUseful = new NavDrawerListAdapter(getActivity(), navDrawerItemsUseful);
        mDrawerListViewUseful.setAdapter(listAdapterUseful);
        mDrawerListViewUseful.setItemChecked(mCurrentSelectedPositionUseful, true);
    }

    public void setItems(List<NavDrawerItem> items, List<NavDrawerItem> itemsSecond) {
        if (listAdapter != null) {
            listAdapter.setItems(items);
        }
        if (listAdapterUseful != null) {
            listAdapterUseful.setItems(itemsSecond);
        }
    }

    private void selectItem(int position) {
        selectItem(position, true, true);
    }

    private void selectItem(int position, boolean closeDrawer, boolean enableCallbacks) {
        setSelectedItem(position, closeDrawer);
        if (enableCallbacks && listener != null && listAdapter != null) {
            NavDrawerItem item = listAdapter.getItem(position);

            switch (item.itemType) {
                case ITEM_COIN:
                    listener.onAccountSelected((String) item.itemData);
                    break;
                case ITEM_OVERVIEW:
                    listener.onOverviewSelected();
                    break;
            }

        }
    }

    private void selectItemUseful(int position) {
        selectItemUseful(position, true, true);
    }

    private void selectItemUseful(int position, boolean closeDrawer, boolean enableCallbacks) {
        //setSelectedItemUseful(position, closeDrawer);
        if (enableCallbacks && listener != null && listAdapterUseful != null) {
            NavDrawerItem item = listAdapterUseful.getItem(position);

            switch (item.itemType) {
                case ITEM_COIN:
                    listener.onAccountSelected((String) item.itemData);
                    break;
                case ITEM_OVERVIEW:
                    listener.onOverviewSelected();
                    break;
                case ITEM_LINK:
                    listener.onLinkSelected((String) item.itemData);
                    break;
            }

        }
    }
    private void addCoins() {
        closeDrawer();
        if (listener != null) {
            listener.onAddCoinsSelected();
        }
    }
    public void setSelectedItem(int position, boolean closeDrawer) {
        mCurrentSelectedPosition = position;
        if (mDrawerListView != null) {
            mDrawerListView.setItemChecked(position, true);
        }
        if (closeDrawer) {
            closeDrawer();
        }
    }

//    public void setSelectedItemUseful(int position, boolean closeDrawer) {
//        mCurrentSelectedPositionUseful = position;
//
//        if (mDrawerListViewUseful != null) {
//            mDrawerListViewUseful.setItemChecked(position, true);
//        }
//        if (closeDrawer) {
//            closeDrawer();
//        }
//    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        try {
            listener = (Listener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Forward the new configuration the drawer toggle component.
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // If the drawer is open, show the global app actions in the action bar. See also
        // showGlobalContextActionBar, which controls the top-left area of the action bar.
        if (mDrawerLayout != null && isDrawerOpen()) {
            inflater.inflate(R.menu.global, menu);
            showGlobalContextActionBar();
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Per the navigation drawer design guidelines, updates the action bar to show the global app
     * 'context', rather than just what's in the current screen.
     */
    private void showGlobalContextActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(R.string.app_name);
    }

    private ActionBar getActionBar() {
        return ((AppCompatActivity) getActivity()).getSupportActionBar();
    }

    /**
     * Callbacks interface that all activities using this fragment must implement.
     */
    public interface Listener {
        void onAccountSelected(String accountId);
        void onOverviewSelected();
        void onLinkSelected(String link);
        void onAddCoinsSelected();
    }
}
