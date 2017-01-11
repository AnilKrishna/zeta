package zeta.android.apps.ui.fragment.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.apps.ui.activity.navigation.INavigationFragmentManager;
import zeta.android.apps.ui.activity.navigation.NavigationFragmentManager;

@ParametersAreNonnullByDefault
public abstract class BaseNavigationFragment extends DaggerAwareFragment implements INavigationFragmentManager {

    private boolean mOnSaveInstanceStateCalled;
    private INavigationFragmentManager mNavigationFragmentManager;

    @IntDef({
            HasOptionsMenuOverride.NO_OVERRIDE,
            HasOptionsMenuOverride.OVERRIDE_TO_FALSE,
            HasOptionsMenuOverride.OVERRIDE_TO_TRUE
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface HasOptionsMenuOverride {
        int NO_OVERRIDE = 1;
        int OVERRIDE_TO_FALSE = 2;
        int OVERRIDE_TO_TRUE = 3;
    }

    /**
     * A settable value that allows a parent Fragment to override a child Fragment's default
     * behavior for showing the options menu. This is useful when a child that normally take control
     * of the action bar is nested inside a parent that would like to take control instead. The
     * parent can call {@link #setHasOptionsMenuOverride(int)} to set the new desired behavior.
     */
    @HasOptionsMenuOverride
    private int mHasOptionsMenuOverride = HasOptionsMenuOverride.NO_OVERRIDE;

    @Override
    public void setHasOptionsMenu(boolean hasMenu) {
        boolean finalHasMenu;
        switch (mHasOptionsMenuOverride) {
            case HasOptionsMenuOverride.OVERRIDE_TO_FALSE:
                finalHasMenu = false;
                break;
            case HasOptionsMenuOverride.OVERRIDE_TO_TRUE:
                finalHasMenu = true;
                break;
            case HasOptionsMenuOverride.NO_OVERRIDE:
            default:
                finalHasMenu = hasMenu;
                break;

        }
        super.setHasOptionsMenu(finalHasMenu);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstance) {
        super.onCreate(savedInstance);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mNavigationFragmentManager = (INavigationFragmentManager) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement NavigationFragmentManagerHolder");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mOnSaveInstanceStateCalled = false;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mOnSaveInstanceStateCalled = true;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * Can be used to externally override the value typically set by
     * {@link #setHasOptionsMenu(boolean)}.
     *
     * @param optionsMenuOverride the override value
     */
    public final void setHasOptionsMenuOverride(@HasOptionsMenuOverride int optionsMenuOverride) {
        mHasOptionsMenuOverride = optionsMenuOverride;
    }

    public final boolean onSavedInstanceStateCalled() {
        return mOnSaveInstanceStateCalled;
    }

    //region INavigationFragmentManager
    @Override
    public NavigationFragmentManager getNavigationFragmentManager() {
        if (mNavigationFragmentManager == null) {
            return null;
        }
        return mNavigationFragmentManager.getNavigationFragmentManager();
    }
    //endregion

}
