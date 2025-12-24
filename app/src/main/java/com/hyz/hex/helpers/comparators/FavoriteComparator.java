package com.hyz.hex.helpers.comparators;

import com.hyz.hex.vault.VaultEntry;

import java.util.Comparator;

public class FavoriteComparator implements Comparator<VaultEntry> {
    @Override
    public int compare(VaultEntry a, VaultEntry b) {
        return -1 * Boolean.compare(a.isFavorite(), b.isFavorite());
    }
}