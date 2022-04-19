package peace.karelie.secondmoudle

import android.app.Activity
import android.os.Binder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.didi.drouter.annotation.Router
import com.didi.drouter.router.Request
import com.didi.drouter.router.RouterHelper
import com.karelie.commom.widget.initBack
import peace.karelie.secondmoudle.databinding.LayoutSecondBinding

@Router(path = "/secondActivity")
class SecondActivity: Activity(){
    lateinit var binding:LayoutSecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
    }

    private fun initData() {
        val request = RouterHelper.getRequest(this)
        binding.apply {
            request?.getString("jump")?.let {
                ktpSecondmoudle.initBack(R.mipmap.back_topbar,"这是第二个Moudle", it,{finish()}){
                }
            }
        }
    }
}