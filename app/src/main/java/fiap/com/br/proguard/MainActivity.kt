package fiap.com.br.proguard

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SWRepository.getPeople(SWPeoples.DartVader) { people ->
            val name = "Name: ${people?.name}"
            textView.text = name
            Log.d("MainActivity", name)
        }
    }
}
