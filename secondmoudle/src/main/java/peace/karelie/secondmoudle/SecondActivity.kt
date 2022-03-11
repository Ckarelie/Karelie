package peace.karelie.secondmoudle

import android.app.Activity
import android.os.Binder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.didi.drouter.annotation.Router
import peace.karelie.secondmoudle.databinding.LayoutSecondBinding

@Router(path = "/secondActivity")
class SecondActivity: Activity(){
    lateinit var binding:LayoutSecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutSecondBinding.inflate(layoutInflater)
        setContentView(binding.root);
    }
}