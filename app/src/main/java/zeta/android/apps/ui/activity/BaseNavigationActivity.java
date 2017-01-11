package zeta.android.apps.ui.activity;

import android.support.design.widget.NavigationView;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import zeta.android.apps.ui.activity.helpers.CustomTabActivityHelper;
import zeta.android.apps.ui.activity.navigation.INavigationFragmentManager;
import zeta.android.apps.ui.activity.navigation.NavigationFragmentManager;

@ParametersAreNonnullByDefault
public abstract class BaseNavigationActivity extends DaggerAwareActivity implements INavigationFragmentManager,
        NavigationView.OnNavigationItemSelectedListener {

    @Inject
    protected NavigationFragmentManager mNavigationFragmentManager;

    @Inject
    protected CustomTabActivityHelper mCustomTabActivityHelper;

    //region INavigationFragmentManager
    @Override
    public NavigationFragmentManager getNavigationFragmentManager() {
        return mNavigationFragmentManager;
    }
    //endregion

}
