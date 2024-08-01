package uz.ssh.newsapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.ssh.newsapp.domain.usercases.app_entry.AppEntryUseCases
import uz.ssh.newsapp.presentation.nvgraph.Route
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    useCases: AppEntryUseCases
) : ViewModel() {
    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Route.OnBoardingScreen.route)
        private set

    init {
        useCases.readAppEntry().onEach {
            if (it) {
                startDestination = Route.HomeScreen.route
            } else {
                startDestination = Route.OnBoardingScreen.route
            }
            delay(300)
            splashCondition = false
        }.launchIn(viewModelScope)
    }
}