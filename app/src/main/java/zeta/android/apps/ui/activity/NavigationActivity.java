package zeta.android.apps.ui.activity;

import android.app.ActivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import butterknife.BindView;
import zeta.android.apps.R;
import zeta.android.apps.ZetaApplication;
import zeta.android.apps.di.component.ZetaAppComponent;
import zeta.android.apps.ui.activity.presentation.NavigationPresentation;
import zeta.android.apps.ui.activity.presenter.NavigationPresenter;
import zeta.android.apps.ui.common.BaseViews;
import zeta.android.apps.ui.fragment.DebugFragment;
import zeta.android.apps.ui.fragment.accounts.AccountsFragment;
import zeta.android.apps.ui.fragment.home.HomeFragment;
import zeta.android.apps.ui.fragment.myorders.MyOrderFragment;
import zeta.android.apps.ui.fragment.settings.SettingsFragment;

@ParametersAreNonnullByDefault
public class NavigationActivity extends BaseNavigationActivity implements NavigationPresentation {

    private Views mViews;

    @Inject
    NavigationPresenter mPresenter;

    static class Views extends BaseViews {

        @BindView(R.id.zeta_drawer_layout)
        DrawerLayout drawerLayout;

        @BindView(R.id.zeta_app_bar_layout)
        AppBarLayout appBarLayout;

        @BindView(R.id.zeta_toolbar)
        Toolbar toolbar;

        @BindView(R.id.zeta_nav_view)
        NavigationView navigationView;

        @BindView(R.id.container)
        View fragmentContainer;

        ImageView headerImageView;

        TextView headerTitle;

        TextView headerEmail;

        @SuppressWarnings("ConstantConditions")
        Views(AppCompatActivity root) {
            super(root.findViewById(R.id.zeta_drawer_layout));
            final View headerView = navigationView.getHeaderView(0);
            headerImageView = (ImageView) headerView.findViewById(R.id.header_image_view);
            headerTitle = (TextView) headerView.findViewById(R.id.header_title);
            headerEmail = (TextView) headerView.findViewById(R.id.header_email);
        }
    }

    @Override
    protected void configureDependencies(ZetaAppComponent component) {
        component.navigationActivity().inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        configureTaskDescription();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mViews = new Views(this);
        setSupportActionBar(mViews.toolbar);

        final FragmentManager supportFragmentManager = getSupportFragmentManager();
        mNavigationFragmentManager.setFragmentManager(supportFragmentManager);
        mNavigationFragmentManager.setContainerId(R.id.container);
        mNavigationFragmentManager.setDrawerLayout(mViews.drawerLayout);
        mNavigationFragmentManager.setDrawer(mViews.navigationView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mViews.drawerLayout, mViews.toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        mViews.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mPresenter.onCreate(this);

        mViews.navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            mNavigationFragmentManager.addAsBaseFragment(HomeFragment.newInstance());
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mPresenter.onPostResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ZetaApplication.watchForMemoryLeaks(getApplicationContext(), this);
        mPresenter.onDestroy();
        mPresenter = null;
        mViews.clear();
        mViews = null;
    }

    @Override
    public void onBackPressed() {
        if (mViews != null && mViews.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mViews.drawerLayout.closeDrawer(GravityCompat.START);
            return;
        }
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle click events from option menus
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                mPresenter.onMenuItemHomeSelected();
                break;
            case R.id.nav_accounts:
                mPresenter.onMenuItemAccountsSelected();
                break;
            case R.id.nav_refer_and_earn:
                mPresenter.onMenuItemReferAndEarnSelected();
                break;
            case R.id.nav_my_orders:
                mPresenter.onMenuItemMyOrdersSelected();
                break;
            case R.id.nav_settings:
                mPresenter.onMenuItemSettingsSelected();
                break;
            case R.id.nav_debug:
                mPresenter.onMenuItemDebugSelected();
                break;
        }
        mViews.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    //region NavigationPresentation
    @Override
    public void showDebugMenuItem(boolean show) {
        final Menu menu = mViews.navigationView.getMenu();
        menu.findItem(R.id.nav_debug).setVisible(show);
    }

    @Override
    public void showBaseScreen() {
        mNavigationFragmentManager.clearToBaseFragment();
    }

    @Override
    public void showDebugScreen() {
        mNavigationFragmentManager.addFragmentToBackStack(DebugFragment.newInstance());
    }

    @Override
    public void showAccountsScreen() {
        mNavigationFragmentManager.addFragmentToBackStack(AccountsFragment.newInstance());
    }

    @Override
    public void showMyOrdersScreen() {
        mNavigationFragmentManager.addFragmentToBackStack(MyOrderFragment.newInstance());
    }

    @Override
    public void showReferAndEarnScreen() {

    }

    @Override
    public void showSettingsScreen() {
        mNavigationFragmentManager.addFragmentToBackStack(SettingsFragment.newInstance());
    }

    //endregion

    /**
     * Since the primary color is indigo_700 and
     * we want the overview TopBar color to be different and we override it to be white
     * Note: This can be removed if the app icon contrasts with primaryColor or we change
     * primaryColor to be different
     */
    private void configureTaskDescription() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            int topBarColor = ContextCompat.getColor(this, R.color.zeta_white);
            ActivityManager.TaskDescription taskDescription =
                    new ActivityManager.TaskDescription(null, null, topBarColor);
            setTaskDescription(taskDescription);
        }
    }

}
