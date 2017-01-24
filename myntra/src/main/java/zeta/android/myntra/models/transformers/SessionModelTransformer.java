package zeta.android.myntra.models.transformers;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.api.idpapi.response.idp.IdpTokenResponse;
import zeta.android.myntra.models.common.ITransformer;
import zeta.android.myntra.models.session.SessionModel;

@ParametersAreNonnullByDefault
public class SessionModelTransformer implements ITransformer<IdpTokenResponse, SessionModel> {

    @Override
    public SessionModel transform(IdpTokenResponse idpTokenResponse) {
        return SessionModel.create()
                .build();
    }
}