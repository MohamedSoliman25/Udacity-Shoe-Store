package com.udacity.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    companion object{
      const  val EMAIL:String = "mohamedelzmar2018@gmail.com"
        const  val PASSWORD:String = "123456"

    }
   private  lateinit var binding:FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login()
        signUp()
    }

    private fun signUp() {
        binding.btnSignUp.setOnClickListener{

            if (binding.etEmail.text.toString().isNotEmpty() && binding.etPassword.text.toString().isNotEmpty()){

                if(binding.etEmail.text.toString().equals(EMAIL)&& binding.etPassword.text.toString().equals(
                        PASSWORD)){
                    it.findNavController().navigate(R.id.action_loginFragment_to_welcomeOnboardingFragment)
                }
                else{
                    Toast.makeText(requireContext(), "Please Enter Valid Email And Password", Toast.LENGTH_SHORT).show()
                }

            }


        }
    }

    private fun login() {

        binding.btnLogin.setOnClickListener{

            if (binding.etEmail.text.toString().isNotEmpty() && binding.etPassword.text.toString().isNotEmpty()){

                if(binding.etEmail.text.toString().equals(EMAIL)&& binding.etPassword.text.toString().equals(
                        PASSWORD)){
                    it.findNavController().navigate(R.id.action_loginFragment_to_welcomeOnboardingFragment)
                }
                else{
                    Toast.makeText(requireContext(), "Please Enter Valid Email And Password", Toast.LENGTH_SHORT).show()
                }

            }

//            if(binding.etEmail.text.toString().isEmpty()){
//                Toast.makeText(requireContext(), "Please Enter Email", Toast.LENGTH_SHORT).show()
//            }
        }
    }


}