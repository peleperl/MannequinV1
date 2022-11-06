package ru.otus.a220903newtestmodel.screens

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.otus.a220903newtestmodel.R
import ru.otus.a220903newtestmodel.adapters.MannequinActionListener
import ru.otus.a220903newtestmodel.adapters.StartFragmentAdapters
import ru.otus.a220903newtestmodel.databinding.FragmentStartBinding
import ru.otus.a220903newtestmodel.model.Mannequin
import ru.otus.a220903newtestmodel.model.MannequinViewModel

class StartFragment : Fragment() {
    private var binding: FragmentStartBinding? = null
    private val sharedViewModel: MannequinViewModel by activityViewModels()
    private lateinit var adapter: StartFragmentAdapters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = StartFragmentAdapters(object : MannequinActionListener{
            override fun mannequinDelete(mannequin: Mannequin) {
                sharedViewModel.deleteMannequin(mannequin, adapter)
            }

            override fun mannequinDetail(mannequin: Mannequin, view: View) {
                sharedViewModel.showDetailMannequin(mannequin, view)
            }

        })
        binding?.recyclerview?.adapter = adapter
        sharedViewModel.getFriends(adapter)
        updateDesign()

        binding?.recyclerview?.layoutManager = LinearLayoutManager(context)
        binding?.addButton?.setOnClickListener{
            findNavController().navigate(R.id.action_startFragment_to_addMannequinFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.app_bar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Установить обработчики меню
        when(item.itemId){
            R.id.menu_item_from_vk -> {
                Log.e("MER", "MErD")
            }
        }
        return true
    }

    private fun updateDesign(){
        val dividerItemDecoration = DividerItemDecoration(this.context, RecyclerView.VERTICAL)
        dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.divider_drawable, resources.newTheme()))
        binding?.recyclerview?.addItemDecoration(dividerItemDecoration)
    }

}

