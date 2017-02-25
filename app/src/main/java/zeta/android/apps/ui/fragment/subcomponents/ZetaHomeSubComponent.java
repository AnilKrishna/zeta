package zeta.android.apps.ui.fragment.subcomponents;

import dagger.Subcomponent;
import zeta.android.apps.di.scope.FragmentScope;
import zeta.android.apps.ui.fragment.home.HomeFragment;
import zeta.android.apps.ui.fragment.home.modules.HomePresenterModule;

@FragmentScope
@Subcomponent(modules = {
        HomePresenterModule.class})
public interface ZetaHomeSubComponent {

    void inject(HomeFragment fragment);

}
