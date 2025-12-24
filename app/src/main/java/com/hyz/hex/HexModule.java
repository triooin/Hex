package com.hyz.hex;

import android.content.Context;

import androidx.room.Room;

import com.hyz.hex.database.AppDatabase;
import com.hyz.hex.database.AuditLogDao;
import com.hyz.hex.database.AuditLogRepository;
import com.hyz.hex.icons.IconPackManager;
import com.hyz.hex.vault.VaultManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class HexModule {
    @Provides
    @Singleton
    public static IconPackManager provideIconPackManager(@ApplicationContext Context context) {
        return new IconPackManager(context);
    }

    @Provides
    @Singleton
    public static AuditLogRepository provideAuditLogRepository(AppDatabase appDatabase) {
        AuditLogDao auditLogDao = appDatabase.auditLogDao();
        return new AuditLogRepository(auditLogDao);
    }

    @Provides
    @Singleton
    public static VaultManager provideVaultManager(@ApplicationContext Context context, AuditLogRepository auditLogRepository) {
        return new VaultManager(context, auditLogRepository);
    }

    @Provides
    public static Preferences providePreferences(@ApplicationContext Context context) {
        return new Preferences(context);
    }

    @Provides
    @Singleton
    public static AppDatabase provideAppDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, "hex-db")
                .build();
    }
}
