package peace.karelie.mvvm

import java.util.*

class LoginObservable : Observable<Object>() {
    lateinit var register: Observable<Object>
    override fun register(observer: Observer<Object>) {

    }

    override fun unRegister(observer: Observer<Object>) {
        TODO("Not yet implemented")
    }

    override fun onFailed(msg: String) {
        TODO("Not yet implemented")
    }

    fun setValue(message:String){

    }

}