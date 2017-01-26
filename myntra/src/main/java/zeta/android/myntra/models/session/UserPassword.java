package zeta.android.myntra.models.session;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.myntra.models.common.StringId;

@AutoValue
public abstract class UserPassword implements StringId, Parcelable {

    public static UserPassword create(String password) {
        return new AutoValue_UserPassword(password);
    }
}
