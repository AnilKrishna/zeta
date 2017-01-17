package zeta.android.apps.ui.fragment.myorders.modules;

import dagger.Module;
import dagger.Provides;
import zeta.android.apps.di.scope.FragmentScope;
import zeta.android.apps.rx.providers.RxSchedulerProvider;
import zeta.android.apps.ui.fragment.myorders.presenter.MyOrderPresenter;

@Module
@FragmentScope
public class MyOrderPresenterModule {

    @Provides
    MyOrderPresenter providesHomePresenter(RxSchedulerProvider schedulerProvider) {
        return new MyOrderPresenter(schedulerProvider);
    }

}
