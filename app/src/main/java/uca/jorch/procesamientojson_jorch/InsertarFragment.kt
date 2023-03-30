package uca.jorch.procesamientojson_jorch

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import uca.jorch.procesamientojson_jorch.databinding.FragmentInsertarBinding

class InsertarFragment : Fragment() {
    private var _binding: FragmentInsertarBinding? = null
    private val binding get() = _binding!!
    var etNombres: EditText?=null
    var etApellidos: EditText?=null
    var etFechaNac: EditText?=null
    var etTitulo: EditText?=null
    var etEmail: EditText?=null
    var etFacultad: EditText?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInsertarBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etNombres = binding.etNombres
        etApellidos = binding.etApellidos
        etFechaNac = binding.etFechaNac
        etTitulo = binding.etTitulo
        etEmail = binding.etEmail
        etFacultad = binding.etFacultad

        binding.btnInsertar.setOnClickListener() {
            val url = "http://192.168.1.6/evaluación-Jorch/InsertarCoordinador.php"
            val queue = Volley.newRequestQueue(activity)
            var resultadoPost = object : StringRequest(
                Request.Method.POST, url,
                Response.Listener<String> { response ->
                    Toast.makeText(
                        getActivity(),
                        "Usuario ha sido insertado existosamente",
                        Toast.LENGTH_LONG
                    ).show()
                }, Response.ErrorListener { error ->
                    Toast.makeText(getActivity(), "Error: $error", Toast.LENGTH_LONG).show()
                }) {
                override fun getParams(): MutableMap<String, String> {
                    val parametros = HashMap<String, String>()
                    parametros.put("nombres", etNombres?.text.toString())
                    parametros.put("apellidos", etApellidos?.text.toString())
                    parametros.put("fechaNac", etFechaNac?.text.toString())
                    parametros.put("titulo", etTitulo?.text.toString())
                    parametros.put("email", etEmail?.text.toString())
                    parametros.put("facultad", etFacultad?.text.toString())
                    return parametros
                }
            }
            queue.add(resultadoPost)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}