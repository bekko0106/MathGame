package developer.bekzod.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import java.lang.Exception
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var myTextView: TextView
    private lateinit var myEditText: EditText
    private lateinit var myScoreTv:TextView

    var number1: Int = 0
    var number2: Int = 0
    var amal: Int = 0
    var togriJavob: Int = 0


    var ballar=0
    var togriBallar=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        myTextView = findViewById(R.id.tv_1)
        myEditText = findViewById(R.id.edt_1)
        myScoreTv=findViewById(R.id.tv_ball)

        randomMisol()






        myEditText.addTextChangedListener {
            if (togriJavob.toString().length == it?.length) {
                val javob = myEditText.text.toString().toInt()
                if (javob == togriJavob) {
                    ballar++
                    Toast.makeText(this, "Togri", Toast.LENGTH_SHORT).show()
                } else
                    Toast.makeText(this, "notogri", Toast.LENGTH_SHORT).show()
                togriBallar++
                myEditText.text.clear()
                randomMisol()
            }
        }

    }


    fun randomMisol() {
        number1 = Random.nextInt(20)
        number2 = Random.nextInt(20)

        if (number1 < number2) {
            randomMisol()
            return
        }

        amal = Random.nextInt(4)

        when (amal) {
            0 -> {
                togriJavob = number1 + number2
                myTextView.text = "$number1+ $number2= "
            }
            1 -> {
                togriJavob = number1 - number2
                myTextView.text = "$number1- $number2= "
            }
            2 -> {
                togriJavob = number1 * number2
                myTextView.text = "$number1 x $number2= "
            }
            3 -> {
                try {
                    if (number1 % number2 != 0) {
                        randomMisol()
                        return
                    }

                    togriJavob = number1 / number2
                    myTextView.text = "$number1 : $number2= "

                } catch (e: Exception) {
                    randomMisol()
                }
            }
        }
        myScoreTv.text= "$togriBallar/ $ballar"
    }
}


