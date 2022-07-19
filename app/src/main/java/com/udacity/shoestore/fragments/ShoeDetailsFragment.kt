package com.udacity.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeViewModel


class ShoeDetailsFragment : Fragment() {


    private lateinit var binding:FragmentShoeDetailsBinding
    private val shoeViewModel:ShoeViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_details,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.shoe = Shoe("","","","")
        binding.shoeViewModel = shoeViewModel
        binding.lifecycleOwner = viewLifecycleOwner

         saveShoe()
        cancelShoe()

    }



    private fun saveShoe() {
        binding.btnSave.setOnClickListener{
            if(binding.etShoeName.text.toString().isNotEmpty()&&
                    binding.etCompany.text.toString().isNotEmpty()&&
                    binding.etShoeSize.text.toString().isNotEmpty()&&
                    binding.etDescription.text.toString().isNotEmpty()){

//              findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment2(Shoe(binding.etShoeName.text.toString(),
//                      binding.etShoeSize.text.toString(),
//                      binding.etCompany.text.toString(),
//                      binding.etDescription.text.toString())))

                shoeViewModel.addShoe( (binding.shoe) as Shoe)
                findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment2())
            }
            else{
                Toast.makeText(requireContext(), "Please enter shoe data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun cancelShoe() {
        binding.btnCancel.setOnClickListener {
            findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment2())
        }
    }



}