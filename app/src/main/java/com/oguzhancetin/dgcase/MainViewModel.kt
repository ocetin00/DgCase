package com.oguzhancetin.dgcase

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.oguzhancetin.dgcase.network.HashRepository
import com.oguzhancetin.dgcase.network.MessageResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(repository: HashRepository) : ViewModel() {
    var hashedMessage = repository.hashedMessage


}