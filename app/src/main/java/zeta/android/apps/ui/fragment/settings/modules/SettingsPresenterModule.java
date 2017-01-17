package zeta.android.apps.ui.fragment.settings.modules;

import dagger.Module;
import dagger.Provides;
import zeta.android.apps.di.scope.FragmentScope;
import zeta.android.apps.rx.providers.RxSchedulerProvider;
import zeta.android.apps.ui.fragment.settings.presenter.SettingsPresenter;

@Module
@FragmentScope
public class SettingsPresenterModule {

    @Provides
    SettingsPresenter providesHomePresenter(RxSchedulerProvider schedulerProvider) {
        return new SettingsPresenter(schedulerProvider);
    }

}
