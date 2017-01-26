package zeta.android.myntra.models.session;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.myntra.models.common.StringId;

@AutoValue
public abstract class UserMobileNumber implements StringId, Parcelable {

    public static UserMobileNumber create(String mobileNumber) {
        return new AutoValue_UserMobileNumber(mobileNumber);
    }
}
