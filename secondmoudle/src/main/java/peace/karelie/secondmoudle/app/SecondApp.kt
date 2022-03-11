package peace.karelie.secondmoudle.app

import android.app.Application
import com.didi.drouter.api.DRouter

class SecondApp:Application(){
    override fun onCreate() {
        super.onCreate()
        DRouter.init(this)
    }
}