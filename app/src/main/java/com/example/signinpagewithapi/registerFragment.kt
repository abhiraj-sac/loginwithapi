package com.example.signinpagewithapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.signinpagewithapi.databinding.FragmentRegisterBinding
import com.example.signinpagewithapi.models.Userresponse
import com.example.signinpagewithapi.retrofit.RetrofitInstance
import com.example.signinpagewithapi.viewmodel.viewmodel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Objects

class registerFragment : Fragment() {
private var _binding:FragmentRegisterBinding?= null
private val binding get() = _binding!!
    private val viewModel: viewmodel by viewModels()
    var result : Userresponse? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)

        binding.btnlogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginfragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//     viewModel.repository.result.observe(viewLifecycleOwner, {
//         if(it != null){
//             Log.e("tags", it.data.toString())
//         }
//     })
        viewModel.getresponse().observe(viewLifecycleOwner,{
            result = it
    binding.texts.text = result?.data.toString()

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}