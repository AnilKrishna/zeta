package zeta.android.apps.ui.fragment.subcomponents;

import dagger.Subcomponent;
import zeta.android.apps.di.scope.FragmentScope;
import zeta.android.apps.ui.fragment.myorders.MyOrderFragment;
import zeta.android.apps.ui.fragment.myorders.modules.MyOrderPresenterModule;

@FragmentScope
@Subcomponent(modules = {
        MyOrderPresenterModule.class})
public interface ZetaMyOrdersSubComponent {

    void inject(MyOrderFragment fragment);

}
