package com.example.evaluacion_final.view.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rR\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/example/evaluacion_final/view/fragments/PlayerListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "playerList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/evaluacion_final/model/NbaPlayer;", "getPlayerList", "()Landroidx/lifecycle/MutableLiveData;", "repository", "Lcom/example/evaluacion_final/data/repository/NbaPlayerRepository;", "getRepository", "()Lcom/example/evaluacion_final/data/repository/NbaPlayerRepository;", "", "getPlayersFromService", "app_debug"})
public final class PlayerListViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.evaluacion_final.data.repository.NbaPlayerRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.evaluacion_final.model.NbaPlayer>> playerList = null;
    
    public PlayerListViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.evaluacion_final.data.repository.NbaPlayerRepository getRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.example.evaluacion_final.model.NbaPlayer>> getPlayerList() {
        return null;
    }
    
    public final void getPlayerList() {
    }
    
    public final void getPlayersFromService() {
    }
}