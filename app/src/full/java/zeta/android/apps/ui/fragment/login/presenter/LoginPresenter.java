package zeta.android.apps.ui.fragment.login.presenter;

import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import javax.annotation.ParametersAreNonnullByDefault;

import timber.log.Timber;
import zeta.android.apps.rx.providers.RxSchedulerProvider;
import zeta.android.apps.rx.subscriber.ZetaSubscriber;
import zeta.android.apps.ui.common.ZetaRxFragmentLifeCyclePresenter;
import zeta.android.apps.ui.fragment.login.presentation.LoginPresentation;
import zeta.android.myntra.managers.SessionManager;
import zeta.android.myntra.managers.params.LoginParams;
import zeta.android.myntra.models.session.LoginType;
import zeta.android.myntra.models.session.SessionModel;
import zeta.android.myntra.models.session.UserId;
import zeta.android.myntra.models.session.UserPassword;
import zeta.android.myntra.models.session.errors.SessionException;

@ParametersAreNonnullByDefault
public class LoginPresenter extends ZetaRxFragmentLifeCyclePresenter<LoginPresentation> {

    private LoginPresentation mLoginPresentation;
    private SessionManager mSessionManager;

    public LoginPresenter(RxSchedulerProvider schedulerProvider,
                          SessionManager sessionManager) {
        super(schedulerProvider);
        mSessionManager = sessionManager;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    @Override
    public void onCreateView(LoginPresentation loginPresentation) {
        mLoginPresentation = loginPresentation;
    }

    @Override
    public void onViewCreated() {
        requestLogin();
    }

    private void requestLogin() {
        LoginParams loginParams = LoginParams.create(LoginType.MYNTRA)
                .setUserId(UserId.create("manjunath.c1@myntra.com"))
                .setUserPassword(UserPassword.create("Teddybear1"))
                .build();
        subscribe(mSessionManager.getSessionLoginDetails(loginParams),
                new ZetaSubscriber<SessionModel, SessionException>() {
                    @Override
                    protected void onSuccess(SessionModel success) {
                        Timber.d("onSuccess");
                    }

                    @Override
                    protected void onFailure(@Nullable SessionException failure) {
                        Timber.d("onFailure");
                    }

                    @Override
                    protected void onNoNetworkFailure() {
                        Timber.d("onNoNetworkFailure");
                    }
                });
    }
}
