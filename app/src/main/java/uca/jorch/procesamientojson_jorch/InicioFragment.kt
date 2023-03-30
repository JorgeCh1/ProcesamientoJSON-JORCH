package uca.jorch.procesamientojson_jorch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import uca.jorch.procesamientojson_jorch.databinding.FragmentInicioBinding

class InicioFragment : Fragment() {
    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDatos.setOnClickListener(){
            it.findNavController().navigate(R.id.InicioToInsertar)
        }
        binding.btnMostrarTodos.setOnClickListener(){
            it.findNavController().navigate(R.id.InicioToViewAll)
        }
        binding.btnMostrarFiltro.setOnClickListener {
            it.findNavController().navigate(R.id.InicioToViewFilter)
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}