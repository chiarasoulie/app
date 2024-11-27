package com.example.firstapplicationchiara;

import javax.inject.Qualifier


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;


@Qualifier
annotation class FakeApi
@Qualifier
annotation class RealApi

    @Module
    @InstallIn(SingletonComponent::class)

        object AppModule {
            @RealApi
            @Singleton
            @Provides
            fun provideTmdbApi() : TmbdAPI =
                Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build().create(TmbdAPI::class.java)

            @FakeApi
            @Singleton
            @Provides
            fun provideFakeTmdbApi() : TmbdAPI { return FakeTmdbApi() }

            @Singleton
            @Provides
            fun provideRepository(@FakeApi api: TmbdAPI) = Repository(api)
    }
