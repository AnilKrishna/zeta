package zeta.android.myntra.managers;

import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.github.zetaapps.either.Either;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import rx.Observable;
import zeta.android.myntra.api.idpapi.IdpDevApi;
import zeta.android.myntra.api.idpapi.response.idp.IdpTokenResponse;
import zeta.android.myntra.api.idpapi.response.params.IdpTokenParams;
import zeta.android.myntra.managers.params.LoginParams;
import zeta.android.myntra.models.common.ITransformer;
import zeta.android.myntra.models.common.Managers;
import zeta.android.myntra.models.session.SessionModel;
import zeta.android.myntra.models.session.errors.SessionException;

@ParametersAreNonnullByDefault
public class SessionManager {

    private final IdpDevApi mIdpDevAPi;
    private final ITransformer<IdpTokenResponse, SessionModel> mSessionTransformer;

    @Inject
    public SessionManager(IdpDevApi idpDevAPi, ITransformer<IdpTokenResponse, SessionModel> transformer) {
        mIdpDevAPi = idpDevAPi;
        mSessionTransformer = transformer;
    }

    @RxLogObservable
    public Observable<Either<SessionModel, SessionException>> getSessionDetails(LoginParams loginParams) {
        //TODO::
        IdpTokenParams params = new IdpTokenParams(null, null, null, null,
                null, null, null, null, null, null, null, null);
        return mIdpDevAPi.getLoginInfo(params)
                .map(response -> Managers.buildOneOf(
                        response,
                        SessionException::new,
                        mSessionTransformer));
    }

}
