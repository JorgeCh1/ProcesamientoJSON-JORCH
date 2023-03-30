package uca.jorch.procesamientojson_jorch.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uca.jorch.procesamientojson_jorch.databinding.DataViewBinding

class UserAdapter(private val userList: ArrayList<UserData>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    class ViewHolder(private val binding: DataViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun load(item: UserData) {
            with(binding){
                tvidC.text = item.id
                tvnombres.text = item.name
                tvapellidos.text = item.secondName
                tvfechaNac.text = item.dateBorn
                tvtitulo.text = item.tittle
                tvemail.text = item.email
                tvfacultad.text = item.faculty


            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val userItem = DataViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(userItem)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.load(this.userList[position])
    }
}