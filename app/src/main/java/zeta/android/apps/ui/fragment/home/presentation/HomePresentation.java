package zeta.android.apps.ui.fragment.home.presentation;

import android.support.annotation.MenuRes;
import android.view.Menu;
import android.view.MenuInflater;

import zeta.android.apps.ui.fragment.common.presentation.BasePresentation;

public interface HomePresentation extends BasePresentation {

    void inflateMenu(Menu menu, MenuInflater inflater, @MenuRes int menuResId);

    void showActionBarText(String actionBarTitle);

    void navigateToCartPage();

    void navigateToSearchPage();

}
