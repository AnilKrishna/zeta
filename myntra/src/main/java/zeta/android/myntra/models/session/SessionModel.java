package zeta.android.myntra.models.session;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class SessionModel implements Parcelable {

    public static Builder create() {
        return new AutoValue_SessionModel.Builder();
    }

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract SessionModel build();
    }
}
