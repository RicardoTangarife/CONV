package com.ricardotangarife.conv

import android.R.layout.simple_spinner_item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter.createFromResource(this, R.array.array_from, simple_spinner_item).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            sp_from.adapter = adapter
        }

        bt_conv.setOnClickListener {
            val valor = et_from.text.toString()
            val divisa1 = sp_from.selectedItem.toString()
            val divisa2 = sp_to.selectedItem.toString()
            if(valor.isEmpty()){
                Toast.makeText( this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show()
            }
            else{
                var tempvalue= 0.0
                if(divisa1==divisa2){
                    tempvalue = valor.toDouble()
                }
                else if(divisa1=="COP" && divisa2=="USD"){
                    tempvalue = valor.toDouble()*0.00030
                }
                else if(divisa1=="COP" && divisa2=="EUR"){
                    tempvalue = valor.toDouble()*0.00027
                }
                else if(divisa1=="USD" && divisa2=="COP"){
                    tempvalue = valor.toDouble()*3342.20
                }
                else if(divisa1=="USD" && divisa2=="EUR"){
                    tempvalue = valor.toDouble()*0.90
                }
                else if(divisa1=="EUR" && divisa2=="COP"){
                    tempvalue = valor.toDouble()*3723.29
                }
                else if(divisa1=="EUR" && divisa2=="USD"){
                    tempvalue = valor.toDouble()*1.11
                }
                else{
                    tempvalue = valor.toDouble()
                }
                var tempround = String.format("%.2f", tempvalue)
                et_result.text = tempround
            }
        }
    }




}
