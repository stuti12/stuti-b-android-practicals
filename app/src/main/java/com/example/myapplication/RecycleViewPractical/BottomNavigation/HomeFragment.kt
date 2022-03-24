package com.example.myapplication.RecycleViewPractical.BottomNavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import com.example.myapplication.R
import java.util.ArrayList

class HomeFragment : Fragment() {

    internal var expandableListView: ExpandableListView? = null
    internal var adapter: ExpandableListAdapter? = null
    internal var titleList: List<String>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        expandableListView = requireView().findViewById(R.id.expandableListView)
       setAdapter()

    }
    private fun setAdapter() {
        if (expandableListView != null) {
            val listData = data
            titleList = ArrayList(listData.keys)
            adapter = CustomExpandableListAdapter(
                requireContext(),
                titleList as ArrayList<String>,
                listData
            )
            expandableListView!!.setAdapter(adapter)

            expandableListView!!.setOnGroupExpandListener { groupPosition ->
                Toast.makeText(
                    this.context,
                    (titleList as ArrayList<String>)[groupPosition] + R.string.listview_expand,
                    Toast.LENGTH_SHORT
                ).show()
            }

            expandableListView!!.setOnGroupCollapseListener { groupPosition ->
                Toast.makeText(
                    this.context,
                    (titleList as ArrayList<String>)[groupPosition] + R.string.listview_collapse,
                    Toast.LENGTH_SHORT
                ).show()
            }

            expandableListView!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
                Toast.makeText(
                    requireContext(),
                    "Clicked: " + (titleList as ArrayList<String>)[groupPosition] + " -> " + listData[(titleList as ArrayList<String>)[groupPosition]]!!.get(
                        childPosition
                    ),
                    Toast.LENGTH_SHORT
                ).show()
                // For get child position
                // Toast.makeText(applicationContext, groupPosition.toString(), Toast.LENGTH_SHORT).show()
                false
            }
        }
    }
    val data: HashMap<String, List<String>>
        get() {
            val listData = HashMap<String, List<String>>()

            val spiderman = ArrayList<String>()
            spiderman.add("Release year: 2012")
            spiderman.add("Rating: 5 star")
            spiderman.add("Description: Good Movie")

            val movieAbc = ArrayList<String>()
            movieAbc.add("Release year: 2012")
            movieAbc.add("Rating: 5 star")
            movieAbc.add("Description: Good Movie")

            val thor = ArrayList<String>()
            thor.add("Year: 2021")
            thor.add("Rating: 4 Star")
            thor.add("Description: Good Movie")

            val theIncredibleHulk = ArrayList<String>()
            theIncredibleHulk.add("Year: 2022")
            theIncredibleHulk.add("Rating: 4 Star")
            theIncredibleHulk.add("Description: Good movie")

            val theAvengers = ArrayList<String>()
            theAvengers.add("Year:2010")
            theAvengers.add("Rating: 4.3 Star")
            theAvengers.add("Description: Moral movie")

            // set multiple list to header title position
            listData["Spider Man"] = spiderman
            listData["ABC"] = movieAbc
            listData["Thor"] = thor
            listData["The Incredible Hulk"] = theIncredibleHulk
            listData["The Avengers"] = theAvengers
            return listData
        }

}