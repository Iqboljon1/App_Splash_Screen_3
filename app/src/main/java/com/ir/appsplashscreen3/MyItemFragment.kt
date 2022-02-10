package com.ir.appsplashscreen3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.ir.appsplashscreen3.databinding.FragmentMyItemBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"

class MyItemFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var param4: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
            param4 = it.getString(ARG_PARAM4)
        }
    }

    lateinit var binding: FragmentMyItemBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMyItemBinding.inflate(layoutInflater)
        binding.tvName.text = param1
        binding.tvDescription.text = param2
        binding.imageSplash.setImageResource(param3!!.toInt())

        binding.cardSkip.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }

        val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewPager)

        when (param4!!.toInt()){
            in 0..2 -> {
                binding.cardDale.setOnClickListener {
                    viewPager.currentItem = param4!!.toInt()+1
                }
            }
            else -> {
                binding.cardDale.setOnClickListener {
                    findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
                }
            }
        }

        return binding.root
    }

    companion object {
        fun newInstance(param1: String, param2: String, param3: String, param4: String) =
            MyItemFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                    putString(ARG_PARAM3, param3)
                    putString(ARG_PARAM4, param4)
                }
            }
    }
}