package pl.arturborowiec.kursakademiaandroida.core.base

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent
import pl.arturborowiec.kursakademiaandroida.core.exception.ErrorMapper

open class BaseViewModel(private val errorMapper: ErrorMapper? = null) : ViewModel(), DefaultLifecycleObserver {

    private val _message by lazy { LiveEvent<String>() }
    val message: LiveData<String> by lazy { _message }

    private val _uiState by lazy { MutableLiveData<UIState>(UIState.Idle) }
    val uiState: LiveData<UIState> by lazy { _uiState }

    protected fun showMessage(message: String) {
        _message.value = message
    }

    protected fun setIdleState() {
        _uiState.value = UIState.Idle
    }

    protected fun setPendingState() {
        _uiState.value = UIState.Pending
    }

    protected fun handleFailure(throwable: Throwable) {
        errorMapper
            ?.map(throwable)
            ?.let{ showMessage(it) }
    }
}
