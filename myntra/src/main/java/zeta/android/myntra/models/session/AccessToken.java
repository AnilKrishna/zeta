package zeta.android.myntra.models.session;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.myntra.models.common.StringId;

@AutoValue
public abstract class AccessToken implements StringId, Parcelable {

    public static AccessToken create(String accessToken) {
        return new AutoValue_AccessToken(accessToken);
    }
}
