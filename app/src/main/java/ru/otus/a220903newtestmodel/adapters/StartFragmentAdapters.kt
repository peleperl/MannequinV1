package ru.otus.a220903newtestmodel.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.otus.a220903newtestmodel.R
import ru.otus.a220903newtestmodel.databinding.MannequinItemBinding
import ru.otus.a220903newtestmodel.model.Mannequin

class StartFragmentAdapters(private val mannequinActionListener: MannequinActionListener) :
    RecyclerView.Adapter<StartFragmentAdapters.StartFragmentViewHolder>(), View.OnClickListener {
    private lateinit var binding: MannequinItemBinding

    private var mannequinst: MutableList<Mannequin> = mutableListOf()

    fun setMannequin(mutableListMannequinst: MutableList<Mannequin>){
        val diffCallback = MannequinDiffCallback(mannequinst, mutableListMannequinst)
        val diResult = DiffUtil.calculateDiff(diffCallback)
        mannequinst = mutableListMannequinst
        diResult.dispatchUpdatesTo(this)
    }


    override fun onClick(view: View) {
        val mannequin: Mannequin = view.tag as Mannequin
        when (view.id) {
            R.id.removeMannequinFromListButton -> {
                mannequinActionListener.mannequinDelete(mannequin)
            }
            else -> {
                mannequinActionListener.mannequinDetail(mannequin, view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartFragmentViewHolder {
        binding = MannequinItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.root.setOnClickListener(this)
        binding.removeMannequinFromListButton.setOnClickListener(this)
        return StartFragmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StartFragmentViewHolder, position: Int) {
        val mannequin: Mannequin = mannequinst.get(position)
        with(holder.binding) {
            holder.itemView.tag = mannequin
            Log.e("MER", position.toString()+"0")
            removeMannequinFromListButton.tag = mannequin

            mannequinItemName.text = String.format(mannequin.firstName + " " + mannequin.lastName)
            if (mannequin.id == 190) {
                Glide.with(mannequinItemImageView.context)
                    .load(mannequin.smallPhoto.toInt())
                    .circleCrop()
                    .placeholder(R.drawable.vlad)
                    .into(mannequinItemImageView)
            } else {
                Glide.with(mannequinItemImageView.context)
                    .load(mannequin.smallPhoto)
                    .circleCrop()
                    .placeholder(R.drawable.vlad)
                    .into(mannequinItemImageView)
            }
            if (mannequin.city == null) {
                mannequinItemDescription.text = "Без роду"
            } else {
                mannequinItemDescription.text = mannequin.city
            }
        }
    }

    override fun getItemCount(): Int {
        return mannequinst.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class StartFragmentViewHolder(val binding: MannequinItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imageView = binding.mannequinItemImageView
        val textViewName = binding.mannequinItemName
        val textViewDescription = binding.mannequinItemDescription
    }
}

interface MannequinActionListener {
    fun mannequinDelete(mannequin: Mannequin)
    fun mannequinDetail(mannequin: Mannequin, view: View)
}
//Создаём анимации в списке
class MannequinDiffCallback(
    private val oldMannequinList: MutableList<Mannequin>,
    private val newMannequinList: MutableList<Mannequin>
):DiffUtil.Callback(){
    override fun getOldListSize(): Int = oldMannequinList.size
    override fun getNewListSize(): Int = newMannequinList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldMannequin = oldMannequinList[oldItemPosition]
        val newMannequin = newMannequinList[newItemPosition]
        return oldMannequin.id==newMannequin.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldMannequin = oldMannequinList[oldItemPosition]
        val newMannequin = newMannequinList[newItemPosition]
        Log.e("MER$", (oldMannequin.city == newMannequin.city
                && oldMannequin.firstName == newMannequin.firstName && oldMannequin.lastName == newMannequin.lastName).toString()
        )
        return (oldMannequin.city == newMannequin.city
                && oldMannequin.firstName == newMannequin.firstName && oldMannequin.lastName == newMannequin.lastName)
    }
}
