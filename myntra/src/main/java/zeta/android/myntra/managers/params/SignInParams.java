package zeta.android.myntra.managers.params;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.myntra.models.session.GenderType;
import zeta.android.myntra.models.session.UserFirstName;
import zeta.android.myntra.models.session.UserLastName;
import zeta.android.myntra.models.session.UserType;

@AutoValue
public abstract class SignInParams implements Parcelable {

    public static Builder create() {
        return new AutoValue_SignInParams.Builder();
    }

    @GenderType
    public abstract String getGenderType();

    @UserType
    public abstract String getUserType();

    public abstract UserFirstName getUserFirstName();

    public abstract UserLastName getUserLastName();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setGenderType(@GenderType String genderType);

        public abstract Builder setUserType(@UserType String userType);

        public abstract Builder setUserFirstName(UserFirstName firstName);

        public abstract Builder setUserLastName(UserLastName lastName);

        public abstract SignInParams build();
    }

}