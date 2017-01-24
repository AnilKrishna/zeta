package zeta.android.myntra.managers.params;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LoginParams implements Parcelable {

    public static Builder create() {
        return new AutoValue_LoginParams.Builder();
    }

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract LoginParams build();
    }

}
