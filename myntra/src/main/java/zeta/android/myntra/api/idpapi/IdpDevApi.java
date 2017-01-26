package zeta.android.myntra.api.idpapi;

import javax.annotation.ParametersAreNonnullByDefault;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;
import zeta.android.myntra.api.idpapi.response.idp.IdpTokenResponse;
import zeta.android.myntra.api.idpapi.response.params.IdpMyntraLoginParams;
import zeta.android.myntra.api.idpapi.response.params.IdpSocialLoginParams;

@ParametersAreNonnullByDefault
public interface IdpDevApi {

    @POST("idp")
    Observable<Response<IdpTokenResponse>> getLoginInfo(@Body IdpSocialLoginParams params);


    @POST("idp")
    Observable<Response<IdpTokenResponse>> getLoginInfo(@Body IdpMyntraLoginParams params);
}