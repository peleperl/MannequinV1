package ru.otus.a220903newtestmodel.model

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ru.otus.a220903newtestmodel.R
import ru.otus.a220903newtestmodel.adapters.StartFragmentAdapters
import ru.otus.a220903newtestmodel.api.ApiFactory
import ru.otus.a220903newtestmodel.pojo.MannequinResponse


class MannequinViewModel: ViewModel() {
    private var mutableListMannequin: MutableList<Mannequin> = mutableListOf()
    private val mutableListMannequinResponse: MutableList<MannequinResponse> = mutableListOf()

    fun newDisplayMannequin(id: Int): Bundle{
        var bundle = Bundle()
        val indexOfMannequin = mutableListMannequin.indexOfFirst { it.id == id }
        if (indexOfMannequin != -1){
            val description = mutableListMannequin[indexOfMannequin].firstName
            val imId = mutableListMannequin[indexOfMannequin].smallPhoto
            bundle.putString("description", description)
            bundle.putString("imId", imId)
        }
        return bundle
    }

    fun getFriends(adapter: StartFragmentAdapters){
        val apiFactory: ApiFactory = ApiFactory.getInstance()
        val apiService = apiFactory.getApiService()
        val disposable: Disposable = apiService.getMyFriends()
            .subscribeOn(Schedulers.io())
            .observeOn(mainThread())
            .subscribe{ m ->
                mutableListMannequinResponse.addAll(m.response.items)
                for (i in mutableListMannequinResponse){
                    if (i.deactivated != "deleted" && i.deactivated != "banned"){
                        mutableListMannequin.add(createMannequinFromResponse(i))
                    }
                }
                adapter.setMannequin(mutableListMannequin)
            }
    }

    fun deleteMannequin(mannequin: Mannequin, adapter: StartFragmentAdapters){
        //Проверяем все элементы, выбрасываем через id конкретную женщину
        val indexOfMannequin = mutableListMannequin.indexOfFirst { it.id == mannequin.id }
        var mutableListMannequin32 = mutableListOf<Mannequin>()
        if (indexOfMannequin != -1){
             for (i in mutableListMannequin){
            mutableListMannequin32.add(i)
            }
            mutableListMannequin32.removeAt(indexOfMannequin)
            adapter.setMannequin(mutableListMannequin32)
            mutableListMannequin = mutableListMannequin32
        }
    }

    //This method is called when we click on a woman in the list
    fun showDetailMannequin(mannequin: Mannequin, view: View){
        val bundle: Bundle? = Bundle()
        bundle?.putInt("id", mannequin.id)
        Navigation.findNavController(view).navigate(
            R.id.action_startFragment_to_detailFragment,
            bundle
        )
    }

    private fun createMannequinFromResponse(mannequinResponse: MannequinResponse): Mannequin {
        var cityMannequin = ""
        cityMannequin = if(mannequinResponse.city != null){
            mannequinResponse.city.title
        }else{ "Homeless" }
        var bdates = "00/00/0000"
        bdates = if(mannequinResponse.bdate != null){
            mannequinResponse.bdate
        }else{"01/01/2000"}
        return Mannequin(mannequinResponse.id, mannequinResponse.firstName, mannequinResponse.lastName, mannequinResponse.photo100, mannequinResponse.photo_200, cityMannequin, bdates)
    }


}

