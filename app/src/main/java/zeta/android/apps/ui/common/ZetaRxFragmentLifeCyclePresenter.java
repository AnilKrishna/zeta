package zeta.android.apps.ui.common;

import android.support.annotation.CallSuper;

import zeta.android.apps.rx.managers.RxSubscriptionManager;
import zeta.android.apps.rx.providers.RxSchedulerProvider;

public abstract class ZetaRxFragmentLifeCyclePresenter<Presentation> extends RxSubscriptionManager
        implements ZetaFragmentLifeCyclePresenter<Presentation> {

    public ZetaRxFragmentLifeCyclePresenter(RxSchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        cancelSubscriptions();
    }

    @Override
    public void onDestroy() {
        // no-op
    }
}
