package com.example.signinpagewithapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.signinpagewithapi.databinding.FragmentRegisterBinding
import com.example.signinpagewithapi.models.Userresponse
import com.example.signinpagewithapi.viewmodel.viewmodel

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
            for (i in 0 until result?.data?.size!!) {
                binding.texts.append(result!!.data.get(i).toString())
            }



        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}