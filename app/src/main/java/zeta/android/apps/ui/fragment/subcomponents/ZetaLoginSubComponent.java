package zeta.android.apps.ui.fragment.subcomponents;

import dagger.Subcomponent;
import zeta.android.apps.di.scope.FragmentScope;
import zeta.android.apps.ui.fragment.login.LoginFragment;
import zeta.android.apps.ui.fragment.login.modules.LoginPresenterModule;
import zeta.android.myntra.modules.SessionModule;

@FragmentScope
@Subcomponent(modules = {
        LoginPresenterModule.class,
        SessionModule.class})
public interface ZetaLoginSubComponent {

    void inject(LoginFragment fragment);

}
