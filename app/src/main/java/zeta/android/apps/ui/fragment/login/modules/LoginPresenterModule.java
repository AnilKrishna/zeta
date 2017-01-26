package zeta.android.apps.ui.fragment.login.modules;

import dagger.Module;
import dagger.Provides;
import zeta.android.apps.di.scope.FragmentScope;
import zeta.android.apps.rx.providers.RxSchedulerProvider;
import zeta.android.apps.ui.fragment.login.presenter.LoginPresenter;
import zeta.android.myntra.managers.SessionManager;

@Module
@FragmentScope
public class LoginPresenterModule {

    @Provides
    LoginPresenter providesLoginPresenter(RxSchedulerProvider schedulerProvider,
                                         SessionManager sessionManager) {
        return new LoginPresenter(schedulerProvider, sessionManager);
    }

}
