package zeta.android.apps.ui.fragment.home.presenter;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import zeta.android.apps.ui.fragment.accounts.presenter.AccountsPresenterParam;

@AutoValue
public abstract class HomePresenterParam implements Parcelable {

    public static Builder create() {
        return new AutoValue_HomePresenterParam.Builder();
    }

    public Builder newBuilder() {
        return new AutoValue_HomePresenterParam.Builder(this);
    }

    @Nullable
    public abstract Parcelable getSavedState();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setSavedState(@Nullable Parcelable savedState);

        public abstract HomePresenterParam build();

    }

}