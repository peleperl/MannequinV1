package ru.otus.a220903newtestmodel.domain

import ru.otus.a220903newtestmodel.model.Mannequin

interface MannequinRepository {

    fun addNewMannequin(mannequin: Mannequin)

    fun deleteMannequin(mannequinId: Int)

    fun editMannequin(mannequinId: Int)

    fun showDetailMannequin(mannequinId: Int)

    fun createMannequin():Mannequin

    fun getAllMannequin()
}