package zeta.android.myntra.api.idpapi.response.params;

public class IdpSocialLoginParams {

    public final String action;

    public final String actionToken;

    public IdpSocialLoginParams(String action, String actionToken) {
        this.action = action;
        this.actionToken = actionToken;
    }
}
