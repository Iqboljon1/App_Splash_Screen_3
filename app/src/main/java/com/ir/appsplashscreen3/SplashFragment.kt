package com.ir.appsplashscreen3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.ir.appsplashscreen3.DataClassSplash.DataClassSplash
import com.ir.appsplashscreen3.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    lateinit var adapterSplash: AdapterSplash
    lateinit var arrayListSplash: ArrayList<DataClassSplash>
    lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        arrayListSplash = ArrayList()
        arrayListSplash.add(DataClassSplash("Geoaxborot",
            "Geoaxborot moduli orqali siz o'zingizga yaqin bo'lgan migrantlar va boshqa muassasalar haqida ma'lumot olishingiz mumkin",
            R.drawable.bitmap_1))
        arrayListSplash.add(DataClassSplash("Huquqiy axborot",
            "Huquqiy axborot moduli orqali siz migratsiya sohasiga oid yangiliklardan, qonunlardan xabardor bo'lishingiz va online konsultatsiya olishingiz mumkin",
            R.drawable.bitmap_2))
        arrayListSplash.add(DataClassSplash("To'lovlar xizmatlari",
            "To'lov xizmatlari moduli orqali siz masofadan turib turli xil xizmatlarga to'lovlar haqida ma'lumot olishingiz va to'lovlarni amalga oshirishingiz mumkin",
            R.drawable.bitmap_3))
        arrayListSplash.add(DataClassSplash("Qo'shimcha imkoniyat",
            "Qo'shimcha imkoniyatlar moduli orqali siz interaktiv so'zlashgichlar va lug'atlar yordamida til bilish savodxonligingizni oshirishingiz mumkin",
            R.drawable.bitmap_4))
        adapterSplash = AdapterSplash(arrayListSplash, requireActivity())
        binding.viewPager.adapter = adapterSplash


        for (i in 0 until arrayListSplash.size) {
            buildTabLayoutInLinear(binding.viewPager.currentItem, i)
        }


        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {

                binding.lyTabLayout.removeAllViews()
                for (i in 0 until arrayListSplash.size) {
                    buildTabLayoutInLinear(position, i)
                }
            }
        })

        return binding.root
    }

    private fun buildTabLayoutInLinear(int: Int, count: Int) {
        val view = layoutInflater.inflate(R.layout.item_selected, null, false)
        val image = view.findViewById<ImageView>(R.id.imageItem)

        if (count == int) {
            image.setImageResource(R.drawable.item_selected)
        } else {
            image.setImageResource(R.drawable.item_unselected)
        }
        binding.lyTabLayout.addView(view)

    }
}