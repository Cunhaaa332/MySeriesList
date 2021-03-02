package com.cunha.myserieslist.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.cunha.myserieslist.R
import com.cunha.myserieslist.database.SerieUtil
import com.cunha.myserieslist.model.Serie
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.recycler_serie_list.view.*

class RecyclerListSerie(
    private val series: List<Serie>
) : RecyclerView.Adapter<RecyclerListSerie.SerieViewHolder>(){
    private val storageReference = FirebaseStorage.getInstance().reference
    class SerieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textSerieNome: TextView = itemView.textViewListSerieNome
        val textSerieNota: TextView = itemView.textViewListSerieNota
        val imageSerie: ImageView = itemView.imageViewListSerie
        val imageDetailsSerie: ImageView = itemView.imageViewListSerieDetails
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_serie_list, parent, false)
        return SerieViewHolder(view)

    }

    override fun onBindViewHolder(holder: SerieViewHolder, position: Int) {
        val serie = series[position]
        holder.textSerieNome.text = serie.nome
        holder.textSerieNota.text = serie.nota

        val fileReference: StorageReference
        if(serie.id!!.toInt() % 2 == 0){
            fileReference = storageReference.child("Televisão_par.png")
        }else{
            fileReference = storageReference.child("Televisão_Impar.png")
        }
        fileReference.getBytes(1024*1024).addOnSuccessListener {
            val bitmap = BitmapFactory.decodeByteArray(it, 0, it.size)
            holder.imageSerie.setImageBitmap(bitmap)
        }
        holder.imageDetailsSerie.setOnClickListener{
            SerieUtil.serieSelecionada = serie
            holder.imageDetailsSerie.findNavController().navigate(R.id.detailsSerieFragment)
        }
    }

    override fun getItemCount(): Int = series.size
}