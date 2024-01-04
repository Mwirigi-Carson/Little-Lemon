package com.example.littlelemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuNetworkData(
    @SerialName("menu")
    val menuItems : List<MenuItemNetwork>
)

@Serializable
data class MenuItemNetwork(
    @SerialName("id")
    val id : Int,
    @SerialName("title")
    val title : String,
    @SerialName("description")
    val description : String,
    @SerialName("price")
    val price : String,
    @SerialName("image")
    val image : String,
    @SerialName("description")
    val category : String
){
    fun toMenuItem() = MenuItem(
        id = id,
        title = title,
        description = description,
        price = price,
        image = image  ,
        category = category
    )
}
