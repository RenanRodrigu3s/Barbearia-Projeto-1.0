package br.com.ex.alura.myapplication.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.ex.alura.myapplication.R
import br.com.ex.alura.myapplication.adapter.ServicosAdapter
import br.com.ex.alura.myapplication.databinding.ActivityHomeBinding
import br.com.ex.alura.myapplication.model.Servicos

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var servicosAdapter: ServicosAdapter
    private val listaServiços: MutableList<Servicos> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val nome = intent.extras?.getString("nome")

        binding.txtNomeUsuario.text = "Bem-Vindo, $nome"
        val recyclerViewServicos = binding.recyclerViewServiOs
        recyclerViewServicos.layoutManager = GridLayoutManager(this, 2)
        servicosAdapter = ServicosAdapter(this, listaServiços)
        recyclerViewServicos.setHasFixedSize(true)
        recyclerViewServicos.adapter = servicosAdapter
        getServicos()




        binding.btAgendar.setOnClickListener {
            val intent = Intent(this,Agendamento::class.java)
            intent.putExtra("nome",nome)
            startActivity(intent)
        }

    }

    private fun getServicos() {
        val servico1 = Servicos(R.drawable.img1, "Corte de Cabelo")
        listaServiços.add(servico1)

        val servico2 = Servicos(R.drawable.img2, "Corte de Barba")
        listaServiços.add(servico2)


        val servico3 = Servicos(R.drawable.img3, "Lavagem de Cabelo ")
        listaServiços.add(servico3)

        val servico4 = Servicos(R.drawable.img4, "Tratamento de Cabelo")
        listaServiços.add(servico4)


    }


}