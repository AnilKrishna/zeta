package zeta.android.myntra.modules;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import zeta.android.myntra.api.idpapi.IdpDevApi;
import zeta.android.myntra.api.idpapi.response.idp.IdpTokenResponse;
import zeta.android.myntra.managers.SessionManager;
import zeta.android.myntra.models.common.ITransformer;
import zeta.android.myntra.models.session.SessionModel;
import zeta.android.myntra.models.transformers.SessionModelTransformer;
import zeta.android.myntra.providers.SessionTokenProvider;
import zeta.android.myntra.qualifiers.retrofit.RetrofitIdpApi;

@Module
public class SessionModule {

    @Provides
    IdpDevApi providesIdpDevApi(@RetrofitIdpApi Retrofit retrofit) {
        return retrofit.create(IdpDevApi.class);
    }

    @Provides
    ITransformer<IdpTokenResponse, SessionModel> providesProductsTransformer() {
        return new SessionModelTransformer();
    }

    @Provides
    SessionManager providesSessionManager(IdpDevApi idpDevApi,
                                          SessionTokenProvider sessionTokenProvider,
                                          ITransformer<IdpTokenResponse, SessionModel> transformer) {
        return new SessionManager(idpDevApi, sessionTokenProvider, transformer);
    }

}
