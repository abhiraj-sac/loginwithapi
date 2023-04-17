package com.example.signinpagewithapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.fragment.findNavController
import com.example.signinpagewithapi.databinding.FragmentLoginfragmentBinding
import com.example.signinpagewithapi.models.Loginresponse
import com.example.signinpagewithapi.retrofit.RetrofitInstance
import com.example.signinpagewithapi.viewmodel.loginviewmodel
import com.example.signinpagewithapi.viewmodel.viewmodel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Loginfragment : Fragment() {
private var _binding:FragmentLoginfragmentBinding? =null
private val binding get() = _binding!!
    private lateinit var viewmodellogin:loginviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodellogin = ViewModelProvider(this)[loginviewmodel::class.java]
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentLoginfragmentBinding.inflate(inflater, container, false)
       binding.btnlogin.setOnClickListener{
findNavController().navigate(R.id.action_loginfragment_to_mainFragment)
       }
        binding.loginbutton.setOnClickListener {
            val email = binding.emaillogin.text.toString().trim()
            val password=binding.passwordlogin.text.toString().trim()
    if(email.isEmpty()){
        Toast.makeText(context, "not valid", Toast.LENGTH_SHORT).show()
    }
            if(password.isEmpty()){
                Toast.makeText(context, "not valid", Toast.LENGTH_SHORT).show()
            }
      viewmodellogin.login(email,password)
      observetokens()
        }

        return binding.root
    }

    private fun observetokens() {
        viewmodellogin.observeloginlivedata().observe(viewLifecycleOwner,object : Observer<Loginresponse?>{
            override fun onChanged(value: Loginresponse?) {
                if (value != null) {
                    Log.e("token", value.token)
                }
            }
        })
    }

}