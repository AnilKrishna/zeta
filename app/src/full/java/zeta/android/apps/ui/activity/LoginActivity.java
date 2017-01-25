package zeta.android.apps.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.apps.di.component.ZetaAppComponent;

@ParametersAreNonnullByDefault
public class LoginActivity extends DaggerAwareActivity {

    @Override
    protected void configureDependencies(ZetaAppComponent component) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
