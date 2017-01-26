package zeta.android.myntra.models.session;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.myntra.models.common.StringId;

@AutoValue
public abstract class UserId implements StringId, Parcelable {

    public static UserId create(String userId) {
        return new AutoValue_UserId(userId);
    }
}
