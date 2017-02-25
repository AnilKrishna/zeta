package zeta.android.apps.di.component;

import javax.inject.Singleton;

import dagger.Component;
import zeta.android.apps.ZetaApplication;
import zeta.android.apps.di.module.ConfigModule;
import zeta.android.apps.di.module.DebugModule;
import zeta.android.apps.di.module.EventBusModule;
import zeta.android.apps.di.module.EventBusNoSubscriberModule;
import zeta.android.apps.di.module.NetworkModule;
import zeta.android.apps.di.module.OkHttpInterceptorsModule;
import zeta.android.apps.di.module.SessionTokenModule;
import zeta.android.apps.di.module.ZetaAppModule;
import zeta.android.apps.ui.fragment.subcomponents.ZetaAccountsSubComponent;
import zeta.android.apps.ui.fragment.subcomponents.ZetaHomeSubComponent;
import zeta.android.apps.ui.fragment.subcomponents.ZetaLoginSubComponent;
import zeta.android.apps.ui.fragment.subcomponents.ZetaMyOrdersSubComponent;
import zeta.android.apps.ui.fragment.subcomponents.ZetaProductsSubComponent;
import zeta.android.apps.ui.fragment.subcomponents.ZetaSearchSubComponent;
import zeta.android.apps.ui.fragment.subcomponents.ZetaSettingsSubComponent;
import zeta.android.myntra.MyntraEngineModule;
import zeta.android.myntra.modules.ProductsModule;
import zeta.android.myntra.modules.SearchModule;
import zeta.android.myntra.modules.SessionModule;

@Singleton
@Component(modules = {
        DebugModule.class,
        NetworkModule.class,
        EventBusModule.class,
        ZetaAppModule.class,
        OkHttpInterceptorsModule.class,
        EventBusNoSubscriberModule.class,
        ConfigModule.class,
        SessionTokenModule.class,
        MyntraEngineModule.class})
public interface ZetaAppComponent {

    ZetaLoginSubComponent zetaLoginComponent(SessionModule sessionModule);

    ZetaHomeSubComponent zetaHomeComponent();

    ZetaAccountsSubComponent zetaAccountsComponent();

    ZetaMyOrdersSubComponent zetaMyOrdersComponent();

    ZetaSettingsSubComponent zetaSettingsComponent();

    ZetaSearchSubComponent zetaSearchComponent(SearchModule searchModule);

    ZetaProductsSubComponent zetaProductsComponent(ProductsModule productModule);

    NavigationActivityComponent navigationActivity();

    DebugComponent debugComponent();

    void inject(ZetaApplication targetApplication);

}
