package com.hyz.hex;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class ThemeMap {
    private ThemeMap() {

    }

    public static final Map<Theme, Integer> DEFAULT = ImmutableMap.of(
            Theme.LIGHT, R.style.Theme_Hex_Light,
            Theme.DARK, R.style.Theme_Hex_Dark
    );
}
