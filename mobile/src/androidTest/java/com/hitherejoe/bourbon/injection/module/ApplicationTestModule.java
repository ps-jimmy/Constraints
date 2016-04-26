package com.hitherejoe.bourbon.injection.module;

import android.app.Application;
import android.content.Context;

import com.hitherejoe.bourbon.common.injection.ApplicationContext;
import com.hitherejoe.bourbon.data.DataManager;
import com.hitherejoe.bourbon.data.remote.BourbonService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

/**
 * Provides application-level dependencies for an app running on a testing environment
 * This allows injecting mocks if necessary.
 */
@Module
public class ApplicationTestModule {
    private final Application mApplication;

    public ApplicationTestModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    /************* MOCKS *************/

    @Provides
    @Singleton
    DataManager providesDataManager() {
        return mock(DataManager.class);
    }

    @Provides
    @Singleton
    BourbonService provideBourbonService() {
        return mock(BourbonService.class);
    }
}
