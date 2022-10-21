package ru.otus.a220903newtestmodel.model

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import ru.otus.a220903newtestmodel.R
import ru.otus.a220903newtestmodel.databinding.FragmentAddMannequinBinding

class AddMannequinFragment : Fragment() {
    private var binding: FragmentAddMannequinBinding? = null
    private val sharedViewModel: MannequinViewModel by activityViewModels()
    private val intent = Intent()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentAddMannequinBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.getImageFromGalleryButton?.setOnClickListener{
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select"), 2)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e("MER", data.toString() + {data!=null}.toString())
        try {
            when(resultCode){
                Activity.RESULT_OK ->{
                    val uriImg: Uri? = data?.data
                    val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(requireContext().contentResolver, uriImg)
                    Glide.with(binding!!.getImageFromGalleryButton.context)
                        .load(bitmap)
                        .circleCrop()
                        .into(binding!!.getImageFromGalleryButton)
                }

                Activity.RESULT_CANCELED -> Log.e("MER", "Cancel?")
            }
        }catch (e: Exception){
            Log.e("MER", "RRR-43")
        }
    }
}