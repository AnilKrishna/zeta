package zeta.android.apps.ui.fragment.module;

import dagger.Module;
import dagger.Provides;
import zeta.android.apps.di.scope.FragmentScope;
import zeta.android.apps.rx.providers.RxSchedulerProvider;
import zeta.android.apps.ui.activity.presenter.DebugPresenter;

@Module
@FragmentScope
public class DebugPresenterModule {

    @Provides
    DebugPresenter providesHomePresenter(RxSchedulerProvider schedulerProvider) {
        return new DebugPresenter(schedulerProvider);
    }

}
