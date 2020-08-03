package com.erwin.subsatu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail_pengguna.*

class DetailPengguna : AppCompatActivity() {
    companion object{
        var EXTRA_DATA = "0"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_pengguna)

        val listDataPengguna:DataPengguna = intent.getParcelableExtra(EXTRA_DATA)

        detail_namapengguna.text = getString(R.string.nama_pengguna, listDataPengguna.namapengguna)
        nama_detail.text = listDataPengguna.nama
        lokasi_detail.text = getString(R.string.lokasi, listDataPengguna.lokasi)
        detail_repo.text = getString(R.string.repo, listDataPengguna.repo)
        company_detail.text = getString(R.string.comp, listDataPengguna.comp)
        follow_detail.text = getString(R.string.follow, listDataPengguna.follow)
        following_detail.text = getString(R.string.following, listDataPengguna.following)
        avatar_detail.setImageResource(listDataPengguna.avatar!!)

    }

}