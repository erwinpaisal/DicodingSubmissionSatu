package com.erwin.subsatu

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter : AdapterPengguna
    private lateinit var dataNamaPengguna: Array<String>
    private lateinit var dataNama: Array<String>
    private lateinit var dataLokasi: Array<String>
    private lateinit var dataRepo: Array<String>
    private lateinit var dataComp: Array<String>
    private lateinit var dataFollow: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataAvatar: TypedArray
    private lateinit var users: ArrayList<DataPengguna>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepare()

        adapter = AdapterPengguna(this, addItem())
        lv_listing.adapter = adapter

        lv_listing.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _->
            val listDataPengguna = DataPengguna("","", "", "", "", "", "",0)
            listDataPengguna.avatar = dataAvatar.getResourceId(position, position)
            listDataPengguna.namapengguna = dataNamaPengguna[position]
            listDataPengguna.nama = dataNama[position]
            listDataPengguna.lokasi = dataLokasi[position]
            listDataPengguna.repo = dataRepo[position]
            listDataPengguna.comp = dataComp[position]
            listDataPengguna.follow = dataFollow[position]
            listDataPengguna.following = dataFollowing[position]

            val intent = Intent(this@MainActivity, DetailPengguna::class.java)
            intent.putExtra(DetailPengguna.EXTRA_DATA, listDataPengguna)

            this@MainActivity.startActivity(intent)
            Toast.makeText(this@MainActivity, users[position].nama, Toast.LENGTH_SHORT).show()
        }
    }

    private fun prepare() {
        dataNamaPengguna = resources.getStringArray(R.array.nama_pengguna)
        dataNama = resources.getStringArray(R.array.nama)
        dataLokasi = resources.getStringArray(R.array.lokasi)
        dataRepo = resources.getStringArray(R.array.repo)
        dataComp = resources.getStringArray(R.array.comp)
        dataFollow = resources.getStringArray(R.array.follow)
        dataFollowing = resources.getStringArray(R.array.following)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
    }

    private fun addItem() : ArrayList<DataPengguna> {
        users = ArrayList()
        for (i in dataNama.indices) {
            val user = DataPengguna()
            user.avatar = dataAvatar.getResourceId(i, 0)
            user.nama = dataNama[i]
            user.comp = dataComp[i]
            user.lokasi = dataLokasi[i]
            users.add(user)
        }
        return users
    }

}