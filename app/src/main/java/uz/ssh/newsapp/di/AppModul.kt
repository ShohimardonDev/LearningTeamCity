package uz.ssh.newsapp.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.ssh.newsapp.data.local.NewsTypeConvertor
import uz.ssh.newsapp.data.local.NewsDatabase
import uz.ssh.newsapp.data.manager.LocalUserManagerImpl
import uz.ssh.newsapp.data.remote.NewsApi
import uz.ssh.newsapp.data.repo.NewsRepoImpl
import uz.ssh.newsapp.domain.manager.LocalUserManager
import uz.ssh.newsapp.domain.repo.NewsRepo
import uz.ssh.newsapp.domain.usercases.app_entry.AppEntryUseCases
import uz.ssh.newsapp.domain.usercases.app_entry.ReadAppEntry
import uz.ssh.newsapp.domain.usercases.app_entry.SaveAppEntry
import uz.ssh.newsapp.domain.usercases.new_api.GetNews
import uz.ssh.newsapp.domain.usercases.new_api.NewsUseCases
import uz.ssh.newsapp.domain.usercases.new_api.SearchNews
import uz.ssh.newsapp.utill.Constant.NEWS_DATABASE_NAME
import uz.ssh.newsapp.utill.Constant.NEW_API_URL
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        app: Application,
    ): LocalUserManager = LocalUserManagerImpl(app)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager,
    ): AppEntryUseCases = AppEntryUseCases(
        saveAppEntry = SaveAppEntry(localUserManager), readAppEntry = ReadAppEntry(localUserManager)
    )


    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi =
        Retrofit.Builder().baseUrl(NEW_API_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsApi::class.java)


    @Provides
    @Singleton
    fun provideNewsRepo(
        newsApi: NewsApi,
    ): NewsRepo = NewsRepoImpl(newsApi)

    @Provides
    @Singleton
    fun provideSearchNews(
        newsRepo: NewsRepo,
    ): SearchNews = SearchNews(newsRepo)

    @Provides
    @Singleton
    fun provideNewsUserCases(
        newsRepo: NewsRepo,
    ): NewsUseCases = NewsUseCases(
        getNews = GetNews(newsRepo),
        searchNews = SearchNews(newsRepo)
    )

    @Provides
    @Singleton
    fun provideNewsDatabase(
        app: Application,
    ): NewsDatabase =
        Room.databaseBuilder(
            app.applicationContext,
            NewsDatabase::class.java,
            NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase,
    ) = newsDatabase.newsDao


}