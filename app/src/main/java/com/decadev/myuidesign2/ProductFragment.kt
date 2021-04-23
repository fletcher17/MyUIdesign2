package com.decadev.myuidesign2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProductFragment : Fragment() {

    lateinit var partnersRecyclerView: RecyclerView
    lateinit var visaCardPagerView: ViewPager2
    lateinit var indicator: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_product, container, false)

        partnersRecyclerView = view.findViewById(R.id.recyclerview_layout)
        visaCardPagerView = view.findViewById(R.id.viewpager_layout)
        indicator  = view.findViewById(R.id.tab_layout)

        return view
    }

// On view created, these are the views that displays and functions that are instantiated when the fragment is created.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//This applies the values and how we want the cards to be animated
        visaCardPagerView.apply {
            adapter = CardViewPagerAdapter()
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 2
            setPadding(180, 0, 180, 0)
        }
        val marginPageTransformer = MarginPageTransformer(30)
        val compositionPageTransformer = CompositePageTransformer()
        compositionPageTransformer.addTransformer(marginPageTransformer)
        compositionPageTransformer.addTransformer { page, position ->
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
        }
        visaCardPagerView.setPageTransformer(compositionPageTransformer)

// the TabLayout indicator which indicates when a card is swiped or the position of the current card
        TabLayoutMediator(indicator, visaCardPagerView) { tab, position ->
            visaCardPagerView.setCurrentItem(tab.position, true)
        }.attach()

        partnersRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        partnersRecyclerView.adapter = PartnersAdapter()

    }





    companion object {

        fun newInstance() =
            ProductFragment()

    }
}