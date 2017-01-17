package zeta.android.apps.ui.fragment.subcomponents;

import dagger.Subcomponent;
import zeta.android.apps.di.scope.FragmentScope;
import zeta.android.apps.ui.fragment.accounts.AccountsFragment;
import zeta.android.apps.ui.fragment.accounts.modules.AccountsPresenterModule;

@FragmentScope
@Subcomponent(modules = {
        AccountsPresenterModule.class})
public interface ZetaAccountsSubComponent {

    void inject(AccountsFragment fragment);

}
