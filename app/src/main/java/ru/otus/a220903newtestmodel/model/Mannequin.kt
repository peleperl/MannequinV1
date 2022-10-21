package ru.otus.a220903newtestmodel.model

class Mannequin {

    constructor(
        id: Int,
        firstName: String,
        lastName: String,
        smallPhoto: String,
        largePhoto: String,
        city: String,
        bdate: String
    ) {
        this._id = id
        this._firstName = firstName
        this._lastName = lastName
        this._smallPhoto = smallPhoto
        this._largePhoto = largePhoto
        this._city = city
        this._bdate = bdate
    }

    private var _id = 0
    val id: Int get() = _id

    private var _firstName = "Boris"
    val firstName: String get() = _firstName

    private var _lastName = "Stern"
    val lastName: String get() = _lastName

    private var _smallPhoto = ""
    val smallPhoto: String get() = _smallPhoto

    private var _largePhoto = ""
    val largePhoto: String get() = _largePhoto

    private var _deactivated = false
    val deactivated: Boolean get() = _deactivated

    private var _city = ""
    val city: String get() = _city

    private var _bdate = ""
    val bdate: String get() = _bdate

}