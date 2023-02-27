package com.example.dsm_desafio_1.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dsm_desafio_1.databinding.FragmentGalleryBinding
import kotlin.math.sqrt

class GalleryFragment : Fragment() {
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.calcularButton.setOnClickListener {
            val nombre = binding.nombreEditText.text.toString()
            val codigo = binding.codigoEditText.text.toString()
            val ventas = binding.ventasEditText.text.toString().toDoubleOrNull()
            val mes = binding.mesEditText.text.toString()

            if (nombre == null || codigo == null || ventas == null || mes == null) {
                binding.nombre.text = "Por favor, ingrese valores válidos"
                return@setOnClickListener
            }

            val comision = when {
                ventas < 500 -> 0.0
                ventas <= 1000 -> ventas * 0.05
                ventas <= 2000 -> ventas * 0.1
                ventas <= 3000 -> ventas * 0.15
                ventas <= 4000 -> ventas * 0.2
                else -> ventas * 0.3
            }

            val total = comision+ventas

            binding.nombre.text = "Nombre: $nombre"
            binding.mes.text = "Mes $mes"
            binding.codigo.text= "Codigo $codigo"
            binding.ventas.text = "Ventas: $ventas"
            binding.comicion.text = "Comision: $comision"
            binding.total.text = "Total: $total"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}