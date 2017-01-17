package zeta.android.apps.ui.fragment.accounts.modules;

import dagger.Module;
import dagger.Provides;
import zeta.android.apps.di.scope.FragmentScope;
import zeta.android.apps.rx.providers.RxSchedulerProvider;
import zeta.android.apps.ui.fragment.accounts.presenter.AccountsPresenter;

@Module
@FragmentScope
public class AccountsPresenterModule {

    @Provides
    AccountsPresenter providesAccountsPresenter(RxSchedulerProvider schedulerProvider) {
        return new AccountsPresenter(schedulerProvider);
    }

}
