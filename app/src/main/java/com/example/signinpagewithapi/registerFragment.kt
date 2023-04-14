package com.example.signinpagewithapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.signinpagewithapi.databinding.FragmentRegisterBinding
import com.example.signinpagewithapi.models.Userresponse
import com.example.signinpagewithapi.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class registerFragment : Fragment() {
private var _binding:FragmentRegisterBinding?= null
private val binding get() = _binding!!

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
        RetrofitInstance.api.getsignin().enqueue(object : Callback<Userresponse>{
            override fun onResponse(call: Call<Userresponse>, response: Response<Userresponse>) {
    if(response.body() != null){

    }
                else{

    }
            }

            override fun onFailure(call: Call<Userresponse>, t: Throwable) {

            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}