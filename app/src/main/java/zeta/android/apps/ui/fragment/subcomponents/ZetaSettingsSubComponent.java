package zeta.android.apps.ui.fragment.subcomponents;

import dagger.Subcomponent;
import zeta.android.apps.di.scope.FragmentScope;
import zeta.android.apps.ui.fragment.settings.SettingsFragment;
import zeta.android.apps.ui.fragment.settings.modules.SettingsPresenterModule;

@FragmentScope
@Subcomponent(modules = {
        SettingsPresenterModule.class})
public interface ZetaSettingsSubComponent {

    void inject(SettingsFragment fragment);

}
