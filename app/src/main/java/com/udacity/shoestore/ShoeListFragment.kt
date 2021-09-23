package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel

    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )

        // Get the viewmodel
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.buttonAddShoe.setOnClickListener{ view: View ->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoes ->
            val args = ShoeListFragmentArgs.fromBundle(requireArguments())
            if (args.shoe != null){
                viewModel.shoeList.value?.add(args.shoe as Shoe)
            }
            showShoes(shoes)
        })

        return binding.root
    }

    private fun showShoes(shoes: MutableList<Shoe>?) {
        if (shoes != null) {
            for(shoe in shoes) {
                val showTextView = TextView(context)
                showTextView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)
                showTextView.text = (shoe.company + " " + shoe.name + " " + shoe.size + " " + shoe.description)
                binding.layoutShoelist.addView(showTextView)
            }
        }
    }
}