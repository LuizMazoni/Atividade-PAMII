package android.fabioclaret.modularpamiifabiopreferences


import android.content.SharedPreferences
import android.fabioclaret.modularpamiifabiopreferences.databinding.ActivityMainBinding
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var preferencias: SharedPreferences

    companion object {
        private val NOME_ARQUIVO = "arquivo_prefs.xml"
    }
    private var cor = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.cor1.setOnClickListener {
            cor = "#FF4138"
            salvarCor(cor)
        }
        binding.cor2.setOnClickListener {
            cor = "#FF4138"
            salvarCor(cor)
        }

        binding.cor3.setOnClickListener {
            cor = "#FF5722"
            salvarCor(cor)
        }

        binding.cor4.setOnClickListener {
            cor = "#3F51B5"
            salvarCor(cor)
        }

        binding.cor5.setOnClickListener {
            cor = "#673AB7"
            salvarCor(cor)
        }

        binding.trocarCor.setOnClickListener {
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }

    }

    private fun salvarCor(cor: String) {
        preferencias = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
        val editor = preferencias.edit()
        editor.putString("cor", cor)
        editor.putString("nome", "Luiz")
        editor.putString("sobrenome", "Mazoni")
        editor.putString("email", "adm.luizgstavo@gmail.com")
        editor.apply()
        Toast.makeText(this, "Cor salva no arquivo das cores", Toast.LENGTH_LONG).show()

    }
}
