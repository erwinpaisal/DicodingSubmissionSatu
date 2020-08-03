package com.erwin.subsatu

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class AdapterPengguna (private val context: Context, private val listDataPengguna : ArrayList<DataPengguna>) : BaseAdapter() {
    @SuppressLint("InflateParams")
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if(itemView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            itemView = inflater.inflate(R.layout.item_pengguna, null, true)
        }
        val viewHolder = ViewHolder(itemView as View)
        val pengguna = getItem(position) as DataPengguna
        viewHolder.bind(pengguna)
        return itemView
    }

    override fun getItem(i: Int): Any {
        return listDataPengguna[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return listDataPengguna.size
    }

    private class ViewHolder(view: View) {
        private val txtNama: TextView = view.findViewById(R.id.txt_nama)
        private val txtLokasi: TextView = view.findViewById(R.id.txt_lokasi)
        private val txtComp: TextView = view.findViewById(R.id.txt_comp)
        private val imgAvatar: CircleImageView = view.findViewById(R.id.img_avatar)

        fun bind(pengguna: DataPengguna) {
            pengguna.avatar?.let { imgAvatar.setImageResource(it) }
            txtNama.text = pengguna.nama
            txtLokasi.text = pengguna.lokasi
            txtComp.text = pengguna.comp
        }
    }

}