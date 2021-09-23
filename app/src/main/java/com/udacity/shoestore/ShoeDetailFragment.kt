package com.udacity.shoestore

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        binding.cancelButton.setOnClickListener{ view: View ->
            view.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.saveButton.setOnClickListener{ view: View ->
            val shoe = Shoe(binding.editTextShoeName.text.toString(),
                binding.editTextShoeSize.text.parseToDouble(),
                binding.editTextShoeCompany.text.toString(),
                binding.editTextShoeDescription.text.toString(),
                mutableListOf())

            view.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(shoe))
        }

        return binding.root

    }
}
fun Editable.parseToDouble() = toString().toDoubleOrNull()?: 0.0