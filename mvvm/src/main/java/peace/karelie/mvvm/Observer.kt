package peace.karelie.mvvm

interface Observer<T> {
    fun onSuccess(data: T)
    fun onFailed(data: T)
}