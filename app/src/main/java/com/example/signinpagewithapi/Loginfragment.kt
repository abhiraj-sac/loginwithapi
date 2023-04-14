package com.example.signinpagewithapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavHostController
import androidx.navigation.fragment.findNavController
import com.example.signinpagewithapi.databinding.FragmentLoginfragmentBinding

class Loginfragment : Fragment() {
private var _binding:FragmentLoginfragmentBinding? =null
private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginfragmentBinding.inflate(inflater, container, false)
       binding.btnlogin.setOnClickListener{
findNavController().navigate(R.id.action_loginfragment_to_mainFragment)
       }

        return binding.root
    }

}