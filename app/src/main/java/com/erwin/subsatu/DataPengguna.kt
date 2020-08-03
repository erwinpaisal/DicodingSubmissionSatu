package com.erwin.subsatu

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataPengguna(
    var namapengguna: String? = null,
    var nama: String? = null,
    var lokasi: String? = null,
    var repo: String? = null,
    var comp : String? = null,
    var follow: String? = null,
    var following: String? = null,
    var avatar : Int? = null
): Parcelable