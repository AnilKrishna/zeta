package zeta.android.apps.ui.fragment.search.presentation;

import android.support.annotation.MenuRes;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.List;

import zeta.android.apps.ui.fragment.common.presentation.BasePresentation;
import zeta.android.apps.ui.fragment.products.ProductsDetailsFragmentParam;
import zeta.android.myntra.models.products.ProductGist;

public interface SearchResultPresentation extends BasePresentation {

    void inflateMenu(Menu menu, MenuInflater inflater, @MenuRes int menuResId);

    void showActionBarText(String actionBarTitle);

    void showListView(boolean show);

    void showListViewFooter(boolean show);

    void showListViewFooterRetry(boolean show);

    void updateImageAdapters(List<ProductGist> productGists,
                             int previousSize);

    void navigateToCartPage();

    void navigateToSearchPage();

    void navigateToProductDetailsPage(ProductsDetailsFragmentParam param);

}
