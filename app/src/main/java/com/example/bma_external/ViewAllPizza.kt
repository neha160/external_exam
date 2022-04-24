package com.example.bma_external

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import android.widget.Toast
import com.example.externalpractice.Pizza
import com.example.externalpractice.PizzaAdapter
import kotlinx.android.synthetic.main.activity_view_all_pizza.*
import kotlinx.android.synthetic.main.customedialog.*

class ViewAllPizza : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all_pizza)
        RefreshRecycler()
    }
    fun RefreshRecycler()
    {
        var arr = ArrayList<Pizza>()
        var db = DBHelper(this)
        arr = db.GetAllFruits()
        var adapt = PizzaAdapter(this,arr)
        MyRecycleOP.adapter = adapt
    }
    fun Update(position:Int)
    {
        var db=DBHelper(this)
        var arr:ArrayList<Pizza> = db.GetAllFruits()

        var dialog= Dialog(this)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.customedialog)

        // Full Screen Code::
        //___________THIS CODE IS OPTIONAL TO EXECUTE_____________
        // FROM Next line from here to next five Lines.....
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window!!.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        lp.gravity = Gravity.CENTER
        dialog.window!!.attributes = lp
        dialog.show()
        dialog.txtUpadateId.text = "Hello!!"
        dialog.setCancelable(false)

//        dialog.txtUpadateId.text = arr[position].P_Id.toString()
//        dialog.edtUpdateName.setText(arr[position].F_Name)
//        dialog.edtUpdateFPrice.setText(arr[position].F_Price.toString())
//        dialog.edtUpdateFQuantity.setText(arr[position].F_Qty.toString())

        dialog.btnUpdate.setOnClickListener {
            var id=dialog.txtUpadateId.text.toString().toInt()
            var name=dialog.edtUpadeName.text.toString()
            var price=dialog.edtUpdatePrice.text.toString()
            var quantity=dialog.edtUpdatequantity.text.toString()
            var size = dialog.edtUpdateSize.text.toString()
            var f=Pizza(id,name,price.toDouble(),quantity.toInt(),size)
            db.update(f)
            dialog.dismiss()
            RefreshRecycler()
        }
    }
    fun Delete(position:Int)
    {
        Toast.makeText(applicationContext,"im here", Toast.LENGTH_LONG).show()
        var db=DBHelper(this)
        var arr:ArrayList<Pizza> = db.GetAllFruits()
        var Pizza=arr.get(position)
        Toast.makeText(applicationContext,"${Pizza.P_Id}", Toast.LENGTH_LONG).show()
        db.Delete(Pizza.P_Id)
        RefreshRecycler()
    }
}