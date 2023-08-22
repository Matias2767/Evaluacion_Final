package com.example.evaluacion_final.view.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/example/evaluacion_final/view/fragments/FirebaseListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "playersFirebase", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/evaluacion_final/model/PlayerFirebase;", "getPlayersFirebase", "()Landroidx/lifecycle/MutableLiveData;", "loadFirebasePlayers", "", "app_debug"})
public final class FirebaseListViewModel extends androidx.lifecycle.ViewModel {
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.evaluacion_final.model.PlayerFirebase>> playersFirebase = null;
    
    public FirebaseListViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.example.evaluacion_final.model.PlayerFirebase>> getPlayersFirebase() {
        return null;
    }
    
    public final void loadFirebasePlayers() {
    }
}