package zeta.android.apps.ui.fragment.home.modules;

import dagger.Module;
import dagger.Provides;
import zeta.android.apps.di.scope.FragmentScope;
import zeta.android.apps.rx.providers.RxSchedulerProvider;
import zeta.android.apps.ui.fragment.home.presenter.HomePresenter;

@Module
@FragmentScope
public class HomePresenterModule {

    @Provides
    HomePresenter providesHomePresenter(RxSchedulerProvider schedulerProvider) {
        return new HomePresenter(schedulerProvider);
    }

}
