package com.example.evaluacion_final.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eJ\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/example/evaluacion_final/data/repository/NbaPlayerRepository;", "", "playerDao", "Lcom/example/evaluacion_final/data/db/NbaPlayerDao;", "(Lcom/example/evaluacion_final/data/db/NbaPlayerDao;)V", "getPlayerDao", "()Lcom/example/evaluacion_final/data/db/NbaPlayerDao;", "addFavorite", "", "player", "Lcom/example/evaluacion_final/model/NbaPlayer;", "(Lcom/example/evaluacion_final/model/NbaPlayer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFavorite", "getFavorites", "", "getPlayers", "Lcom/example/evaluacion_final/data/response/ApiResponse;", "Lcom/example/evaluacion_final/data/response/PlayerListResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class NbaPlayerRepository {
    @org.jetbrains.annotations.Nullable
    private final com.example.evaluacion_final.data.db.NbaPlayerDao playerDao = null;
    
    public NbaPlayerRepository() {
        super();
    }
    
    public NbaPlayerRepository(@org.jetbrains.annotations.Nullable
    com.example.evaluacion_final.data.db.NbaPlayerDao playerDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.example.evaluacion_final.data.db.NbaPlayerDao getPlayerDao() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getPlayers(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.evaluacion_final.data.response.ApiResponse<com.example.evaluacion_final.data.response.PlayerListResponse>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addFavorite(@org.jetbrains.annotations.NotNull
    com.example.evaluacion_final.model.NbaPlayer player, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.evaluacion_final.model.NbaPlayer> getFavorites() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteFavorite(@org.jetbrains.annotations.NotNull
    com.example.evaluacion_final.model.NbaPlayer player, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}