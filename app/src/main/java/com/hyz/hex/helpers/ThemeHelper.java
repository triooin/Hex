package com.hyz.hex.helpers;

import android.content.res.Configuration;

import androidx.appcompat.app.AppCompatActivity;

import com.hyz.hex.Preferences;
import com.hyz.hex.R;
import com.hyz.hex.Theme;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.color.DynamicColorsOptions;

import java.util.Map;

public class ThemeHelper {
    private final AppCompatActivity _activity;
    private final Preferences _prefs;

    public ThemeHelper(AppCompatActivity activity, Preferences prefs) {
        _activity = activity;
        _prefs = prefs;
    }

    /**
     * Sets the theme of the activity. The actual style that is set is picked from the
     * given map, based on the theme configured by the user.
     */
    public void setTheme(Map<Theme, Integer> themeMap) {
        int theme = themeMap.get(getConfiguredTheme());
        _activity.setTheme(theme);

        if (_prefs.isDynamicColorsEnabled()) {
    DynamicColorsOptions.Builder optsBuilder =
            new DynamicColorsOptions.Builder();

    if (getConfiguredTheme() == Theme.DARK) {
        optsBuilder.setThemeOverlay(
                R.style.ThemeOverlay_Hex_Dynamic_Dark);
    }

    DynamicColors.applyToActivityIfAvailable(
            _activity, optsBuilder.build());
}
    }

    public Theme getConfiguredTheme() {
    Theme theme = _prefs.getCurrentTheme();

    if (theme == Theme.SYSTEM) {
        int currentNightMode =
                _activity.getResources().getConfiguration().uiMode
                        & Configuration.UI_MODE_NIGHT_MASK;

        if (currentNightMode == Configuration.UI_MODE_NIGHT_YES) {
            theme = Theme.DARK;
        } else {
            theme = Theme.LIGHT;
        }
    }

    return theme;
    }
}
