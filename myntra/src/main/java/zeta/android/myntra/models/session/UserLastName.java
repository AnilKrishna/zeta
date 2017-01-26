package zeta.android.myntra.models.session;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.myntra.models.common.StringId;

@AutoValue
public abstract class UserLastName implements StringId, Parcelable {

    public static UserLastName create(String lastName) {
        return new AutoValue_UserLastName(lastName);
    }
}
