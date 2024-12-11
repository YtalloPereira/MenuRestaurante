package ifpb.edu.menurestaurante

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ifpb.edu.menurestaurante.databinding.ActivityDadosDoPedidoBinding

class DadosDoPedidoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDadosDoPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDadosDoPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val quant_cafe = i.getStringExtra("quant_cafe").toString().toInt()
        val quant_pao = i.getStringExtra("quant_pao").toString().toInt()
        val quant_chocolate = i.getStringExtra("quant_chocolate").toString().toInt()

        val preco_cafe = i.getDoubleExtra("preco_cafe", 0.0)
        val preco_pao = i.getDoubleExtra("preco_pao", 0.0)
        val preco_chocolate = i.getDoubleExtra("preco_chocolate", 0.0)

        val texto = "Resumo do Pedido: \n" +
                "Café: $quant_cafe Preço:${quant_cafe*preco_cafe}R$\n" +
                "Pão: $quant_pao Preço:${quant_pao*preco_pao}R$\n" +
                "Chocolate: $quant_chocolate Preço:${quant_chocolate*preco_chocolate}R$\n";

        binding.textResumo.setText(texto)

        binding.btnVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) // Substitua MainActivity pela sua tela inicial
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish() // Opcional: Finaliza a atividade atual
        }
    }
}