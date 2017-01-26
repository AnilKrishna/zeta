package zeta.android.myntra.models.session;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.myntra.models.common.StringId;

@AutoValue
public abstract class UserFirstName implements StringId, Parcelable {

    public static UserFirstName create(String firstName) {
        return new AutoValue_UserFirstName(firstName);
    }
}
