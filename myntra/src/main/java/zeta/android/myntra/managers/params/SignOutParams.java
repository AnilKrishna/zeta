package zeta.android.myntra.managers.params;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.myntra.models.session.GenderType;
import zeta.android.myntra.models.session.UserFirstName;
import zeta.android.myntra.models.session.UserLastName;
import zeta.android.myntra.models.session.UserType;

@AutoValue
public abstract class SignOutParams implements Parcelable {

    public static Builder create() {
        return new AutoValue_SignOutParams.Builder();
    }


    @AutoValue.Builder
    public static abstract class Builder {

        public abstract SignOutParams build();
    }

}
