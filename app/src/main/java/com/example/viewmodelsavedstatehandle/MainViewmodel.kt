package com.example.viewmodelsavedstatehandle

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.Snapshot.Companion.withMutableSnapshot
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import androidx.lifecycle.viewmodel.compose.saveable
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest

class MainViewmodel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    /** The data is restored from Saved State handle using LiveData */
    val getQuery: MutableLiveData<String> = savedStateHandle.getLiveData("query")

    /** The data is saved in Saved State handle using LiveData */
    fun setQuery(query: String) {
        savedStateHandle["query"] = query
    }

    /** The data is restored from Saved State handle using StateFlow */
    val getStateFlow: StateFlow<String> = savedStateHandle.getStateFlow("query", "")

    /** The data is saved in Saved State handle using StateFlow */
    fun setStateFlow(query: String) { savedStateHandle["query"] = query }

    /** The data is restored from Saved State handle using Experimental Compose's State support */
    @OptIn(SavedStateHandleSaveableApi::class)
     var mutableState: List<String> by savedStateHandle.saveable { mutableStateOf(emptyList()) }

    /** The data is saved in Saved State handle using Experimental Compose's State support */
    fun setMutableState(query: String) {
        withMutableSnapshot { mutableState += query }
    }
}