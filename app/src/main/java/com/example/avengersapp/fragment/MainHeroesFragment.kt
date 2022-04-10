package com.example.avengersapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.avengersapp.R
import com.example.avengersapp.activity.DetailActivity
import com.example.avengersapp.activity.DetailActivity.Companion.KEY_DETAIL_EXTRAS
import com.example.avengersapp.adapter.AvengersCharactersVillainsAdapter
import com.example.avengersapp.adapter.ItemClickListener
import com.example.avengersapp.model.AvengerCharacter
import com.example.avengersapp.model.AvengerCharacters
import com.example.avengersapp.repository.AvengerCharactersRepository

/**
 * A simple [Fragment] subclass.
 * Use the [MainHeroesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainHeroesFragment : Fragment() {

    // Data
    private var avengerCharacters: AvengerCharacters? = null
    // RecyclerView
    private var avengersCharactersRecyclerView: RecyclerView? = null

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */
        @JvmStatic
        fun newInstance() =
            MainHeroesFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_heroes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        configureViews(view)
    }

    private fun configureViews (view: View) {
        avengersCharactersRecyclerView = view.findViewById<RecyclerView?>(R.id.listRecyclerView).apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = AvengersCharactersVillainsAdapter(avengerCharacters ?: arrayListOf(), object : ItemClickListener {
                override fun onItemClickListener(item: AvengerCharacter) {
                    startActivity(Intent(activity, DetailActivity::class.java).apply {
                        putExtra(KEY_DETAIL_EXTRAS, item)
                    })
                }
            })
        }
    }


    private fun loadData () {
        avengerCharacters = AvengerCharactersRepository.charactersHeroes
    }




}