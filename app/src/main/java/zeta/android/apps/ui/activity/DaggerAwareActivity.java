package zeta.android.apps.ui.activity;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import zeta.android.apps.ZetaApplication;
import zeta.android.apps.di.component.ZetaAppComponent;

public abstract class DaggerAwareActivity extends AppCompatActivity {

    protected abstract void configureDependencies(ZetaAppComponent component);

    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ZetaApplication application = (ZetaApplication) getApplication();
        configureDependencies(application.getZetaAppComponent());
    }
}
