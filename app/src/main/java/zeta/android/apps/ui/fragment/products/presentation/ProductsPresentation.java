package zeta.android.apps.ui.fragment.products.presentation;

import android.support.annotation.MenuRes;
import android.support.annotation.StringRes;
import android.view.Menu;
import android.view.MenuInflater;

import java.net.URL;

public interface ProductsPresentation {

    void inflateMenu(Menu menu, MenuInflater inflater, @MenuRes int menuResId);

    void showActionBarText(String actionBarTitle);

    void showProgressBar(boolean show);

    void hideProgressBarAndShowContentContainer();

    void showProductImage(URL imageUrl);

    void showProductTitle(String title);

    void showProductPrice(int price);

    void showProductDescription(String description);

    void showSnackBarMessage(@StringRes int message);

    void navigateToCartPage();

    void navigateToSearchPage();

}
