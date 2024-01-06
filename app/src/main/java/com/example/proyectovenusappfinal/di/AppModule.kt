package com.example.proyectovenusappfinal.di

import com.example.proyectovenusappfinal.data.Repository.AuthRepositoryImpl
import com.example.proyectovenusappfinal.domain.Repository.AuthRepository
import com.example.proyectovenusappfinal.domain.UseCase.Auth.AuthUseCase
import com.example.proyectovenusappfinal.domain.UseCase.Auth.GetCurrentUser
import com.example.proyectovenusappfinal.domain.UseCase.Auth.Login
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideFirebaseAuth():FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepositoty(impl: AuthRepositoryImpl):AuthRepository = impl

    @Provides
    fun provideAuthUseCase(repository: AuthRepository) = AuthUseCase(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository)
    )
}