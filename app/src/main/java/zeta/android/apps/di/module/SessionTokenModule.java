package zeta.android.apps.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zeta.android.apps.providers.DefaultSessionTokenProvider;
import zeta.android.apps.providers.interfaces.SharedPrefProvider;
import zeta.android.myntra.providers.SessionTokenProvider;

@Module
@Singleton
public class SessionTokenModule {

    @Provides
    SessionTokenProvider providesSessionTokenProvider(SharedPrefProvider sharedPrefProvider) {
        return new DefaultSessionTokenProvider(sharedPrefProvider);
    }

}
