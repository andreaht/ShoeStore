package com.udacity.shoestore

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber


class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    private lateinit var viewModel: ShoeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        // Get the viewmodel
        viewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)


        binding.cancelButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.saveButton.setOnClickListener { view: View ->

            viewModel.shoe.value?.name = binding.editTextShoeName.text.toString()
            viewModel.shoe.value?.size = binding.editTextShoeSize.text.parseToDouble()
            viewModel.shoe.value?.company = binding.editTextShoeCompany.text.toString()
            viewModel.shoe.value?.description = binding.editTextShoeDescription.text.toString()

            Timber.i("shoe: %s", viewModel.shoe.value)
            view.findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(viewModel.shoe.value)
            )
        }

        return binding.root

    }
}

fun Editable.parseToDouble() = toString().toDoubleOrNull() ?: 0.0