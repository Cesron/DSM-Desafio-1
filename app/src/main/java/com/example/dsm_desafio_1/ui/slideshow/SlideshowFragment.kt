package com.example.dsm_desafio_1.ui.slideshow


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dsm_desafio_1.databinding.FragmentSlideshowBinding
import kotlin.math.sqrt

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonCalcular.setOnClickListener {
            val a = binding.a.text.toString().toDoubleOrNull()
            val b = binding.b.text.toString().toDoubleOrNull()
            val c = binding.c.text.toString().toDoubleOrNull()

            if (a == null || b == null || c == null) {
                binding.resultado.text = "Por favor, ingrese valores válidos para a, b y c"
                return@setOnClickListener
            }

            if (a == 0.0) {
                binding.resultado.text = "El valor de a no puede ser cero"
                return@setOnClickListener
            }

            val discriminante = b * b - 4 * a * c
            if (discriminante < 0) {
                binding.resultado.text = "La ecuación no tiene soluciones reales"
            } else {
                val x1 = (-b + sqrt(discriminante)) / (2 * a)
                val x2 = (-b - sqrt(discriminante)) / (2 * a)
                binding.resultado.text = "x1 = $x1\nx2 = $x2"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}