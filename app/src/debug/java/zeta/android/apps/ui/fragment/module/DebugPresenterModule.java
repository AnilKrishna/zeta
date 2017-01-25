package zeta.android.apps.ui.fragment.module;

import com.github.pedrovgs.lynx.LynxConfig;

import dagger.Module;
import dagger.Provides;
import zeta.android.apps.di.scope.FragmentScope;
import zeta.android.apps.rx.providers.RxSchedulerProvider;
import zeta.android.apps.sharedPref.DebugSharedPreferences;
import zeta.android.apps.ui.activity.presenter.DebugPresenter;

@Module
@FragmentScope
public class DebugPresenterModule {

    @Provides
    DebugPresenter providesHomePresenter(RxSchedulerProvider schedulerProvider,
                                         DebugSharedPreferences sharedPreferences,
                                         LynxConfig lynxConfig) {
        return new DebugPresenter(schedulerProvider, sharedPreferences, lynxConfig);
    }

}
