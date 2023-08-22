package com.example.evaluacion_final.view.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/evaluacion_final/view/fragments/PlayerFavoriteViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_favorites", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/evaluacion_final/model/NbaPlayer;", "favorites", "Landroidx/lifecycle/LiveData;", "getFavorites", "()Landroidx/lifecycle/LiveData;", "repository", "Lcom/example/evaluacion_final/data/repository/NbaPlayerRepository;", "loadFavorites", "", "app_debug"})
public final class PlayerFavoriteViewModel extends androidx.lifecycle.AndroidViewModel {
    private final com.example.evaluacion_final.data.repository.NbaPlayerRepository repository = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.evaluacion_final.model.NbaPlayer>> _favorites = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.evaluacion_final.model.NbaPlayer>> favorites = null;
    
    public PlayerFavoriteViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.evaluacion_final.model.NbaPlayer>> getFavorites() {
        return null;
    }
    
    public final void loadFavorites() {
    }
}