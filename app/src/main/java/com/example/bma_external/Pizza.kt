package com.example.externalpractice

class Pizza(var P_Name:String, var P_Price:Double, var P_Qty: Int, var P_Size:String) {
    var P_Id:Int = 0
    constructor(P_Id:Int, P_Name: String,P_Price: Double,P_Qty: Int,P_Size: String): this(P_Name, P_Price, P_Qty,P_Size)
    {
        this.P_Id =P_Id
    }
}