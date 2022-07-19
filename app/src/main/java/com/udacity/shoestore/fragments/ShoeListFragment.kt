package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.viewmodel.ShoeViewModel


class ShoeListFragment : Fragment() {

    private  lateinit var binding: FragmentShoeListBinding

//    private lateinit var shoeItemBinding:ShoeItemBinding

//    private  val args by navArgs<ShoeListFragmentArgs>()
    private val shoeViewModel:ShoeViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabAdd.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)
        }

//     if(args.shoe!=null) {
//         args.shoe?.let { shoe ->
//             viewModel.addShoe(shoe)
//         }

//         viewModel.setShoeLiveData()

         shoeViewModel.shoeLiveData.observe(viewLifecycleOwner, Observer {showList->
//             Toast.makeText(requireContext(), showList.get(0).name, Toast.LENGTH_SHORT).show()
             showList.forEach{shoe->

                val shoeItemBinding = ShoeItemBinding.inflate(LayoutInflater.from(requireContext()))

                 shoeItemBinding.tvName.text = shoe.name
                 shoeItemBinding.tvCompany.text = shoe.company
                 shoeItemBinding.tvSize.text = shoe.size
                 shoeItemBinding.tvDescription.text = shoe.description

                 val cardViewParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                 ViewGroup.LayoutParams.WRAP_CONTENT)

                 cardViewParams.setMargins(16,16,16,16)
                 shoeItemBinding.root.layoutParams = cardViewParams
                 binding.shoeList.addView(shoeItemBinding.root)
             }
         })
     }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())||
                super.onOptionsItemSelected(item)

    }

    }