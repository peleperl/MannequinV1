package ru.otus.a220903newtestmodel.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.squareup.picasso.Picasso
import ru.otus.a220903newtestmodel.databinding.FragmentDetailBinding

import ru.otus.a220903newtestmodel.model.MannequinViewModel


class DetailFragment : Fragment() {
    private var binding: FragmentDetailBinding? = null
    private var positionChangedMannequin = 0
    private val sharedViewModel: MannequinViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val fragmentBinding =FragmentDetailBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            positionChangedMannequin = it.getInt("id")
        }
        getMannequinData(positionChangedMannequin)
    }

    fun getMannequinData(positionChangedMannequin: Int){
        var bundleUser = sharedViewModel.newDisplayMannequin(positionChangedMannequin)
        binding?.textViewDescription?.text = bundleUser.get("description").toString()
        Picasso.get().load(bundleUser.get("imId").toString()).into(binding?.mannequinItemImageView)
    }
}