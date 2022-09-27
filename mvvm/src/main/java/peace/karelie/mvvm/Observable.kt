package peace.karelie.mvvm

abstract class Observable<T> {
    abstract fun register(observer: Observer<T>)

    abstract fun unRegister(observer: Observer<T>)

    protected fun setValue(data:T){}

    abstract fun onFailed(msg:String)
}