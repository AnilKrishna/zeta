package zeta.android.myntra.models.session;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.myntra.models.common.StringId;

@AutoValue
public abstract class Referer implements StringId, Parcelable {

    public static Referer create(String referer) {
        return new AutoValue_Referer(referer);
    }
}
