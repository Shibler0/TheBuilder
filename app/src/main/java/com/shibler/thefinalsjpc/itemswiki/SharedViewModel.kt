package com.shibler.thefinalsjpc.itemswiki

import androidx.lifecycle.ViewModel
import com.shibler.thefinalsjpc.SkinsCamos
import com.shibler.thefinalsjpc.SkinsRarity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SharedViewModel: ViewModel() {

    private val _doubleReloadTime = MutableStateFlow(0.0)
    val doubleReloadTime = _doubleReloadTime.asStateFlow()

    fun updateReloadTime(newReloadTime : Double) {
        _doubleReloadTime.value = newReloadTime
    }

    private val _intCritDamage = MutableStateFlow(0)
    val intCritDamage = _intCritDamage.asStateFlow()

    fun updateCritDamage (newDamagePerBullet: Int) {
        _intCritDamage.value = newDamagePerBullet
    }

    private val _intDamagePerBullet = MutableStateFlow(0)
    val intDamagePerBullet = _intDamagePerBullet.asStateFlow()

    fun updateDamagePerBullet (newDamagePerBullet: Int) {
        _intDamagePerBullet.value = newDamagePerBullet
    }

    private val _intMagSize = MutableStateFlow(0)
    val intMagSize = _intMagSize.asStateFlow()

    fun updateMagSize (newMagSize: Int) {
        _intMagSize.value = newMagSize
    }

    private val _intDps = MutableStateFlow(0)
    val intDps = _intDps.asStateFlow()

    fun updateDps(newDps : Int) {
        _intDps.value = newDps
    }

    private val _stringName = MutableStateFlow("")
    val stringName = _stringName.asStateFlow()

    fun updateName(newName : String) {
        _stringName.value = newName
    }

    private val _intList = MutableStateFlow<List<SkinsRarity>>(emptyList())
    val intList = _intList.asStateFlow()

    fun updateIntList(newList: List<SkinsRarity>) {
        _intList.value = newList
    }

    private val _intCamo = MutableStateFlow<List<SkinsCamos>>(emptyList())
    val intCamo = _intCamo.asStateFlow()

    fun updateCamoList(newCamoList : List<SkinsCamos>) {
        _intCamo.value = newCamoList
    }

    /*private val _listClassNumber = MutableStateFlow<List<Int>>(emptyList())
    val listClassNumber = _listClassNumber.asStateFlow()

    fun updateListClassNumber(newList : List<Int>) {
        _listClassNumber.value = newList
    }*/



}