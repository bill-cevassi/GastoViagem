package br.dev.tech4labs.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.dev.tech4labs.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        usando binding incluindo a seguinte configuracao no arquivo build.gradle (Module:GastoViagem.app)
            buildFeatures{
                viewBinding = true
            }
        */
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.buttomCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.buttom_calculate){
            if (isValid()){
                calculate()
            }else{
                Toast.makeText(this,R.string.validation_fillAllFields,Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValid(): Boolean {
        return ( binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    private fun calculate(){
        val distancia = binding.editDistance.text.toString().toFloat()
        val preco = binding.editPrice.text.toString().toFloat()
        val autonomia = binding.editAutonomy.text.toString().toFloat()
        val valorTotal = (distancia * preco) / autonomia
        binding.textTotalValue.text = "R$ ${"%.2f".format(valorTotal)}"
    }


}