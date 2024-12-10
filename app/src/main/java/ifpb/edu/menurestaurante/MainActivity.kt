package ifpb.edu.menurestaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ifpb.edu.menurestaurante.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var  binding: MainActivityBinding
    private val precoDoPao = 0.80
    private val precoDoChocolate = 2.00
    private val precoDoCafe = 1.50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPedido.setOnClickListener {
            val i = Intent(this , SplashScreenActivity::class.java)
            i.putExtra("quant_cafe", binding.editQuantidadeCafe.text.toString())
            i.putExtra("quant_pao", binding.editQuantidadePao.text.toString())
            i.putExtra("quant_chocolate", binding.editQuantidadeChocolate.text.toString())

            i.putExtra("preco_chocolate", precoDoChocolate)
            i.putExtra("preco_pao", precoDoPao)
            i.putExtra("quant_cafe", precoDoCafe)

            startActivity(i)
        }

        binding.checkChocolate.setOnClickListener {
            if (binding.checkChocolate.isChecked()){
                binding.editQuantidadeChocolate.setText("1")
                binding.textPrecoChocolate.visibility = View.VISIBLE
            }else{
                binding.editQuantidadeChocolate.setText("0")
                binding.textPrecoChocolate.visibility = View.GONE
            }
        }
        binding.checkCafe.setOnClickListener {
            if (binding.checkCafe.isChecked()){
                binding.editQuantidadeCafe.setText("1")
                binding.textPrecoCafe.visibility = View.VISIBLE
            }else{
                binding.editQuantidadeCafe.setText("0")
                binding.textPrecoCafe.visibility = View.GONE
            }
        }

        binding.checkPao.setOnClickListener {
            if (binding.checkPao.isChecked()){
                binding.editQuantidadePao.setText("1")
                binding.textPrecoPao.visibility = View.VISIBLE
            }else{
                binding.editQuantidadePao.setText("0")
                binding.textPrecoPao.visibility = View.GONE
            }
        }
    }
}