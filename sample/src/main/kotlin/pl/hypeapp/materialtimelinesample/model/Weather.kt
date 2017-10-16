package pl.hypeapp.materialtimelinesample.model

import pl.hypeapp.materialtimelinesample.adapter.ViewType

class Weather(val date: String,
              val weatherDescription: String,
              val temperature: Float,
              val isLastItem: Boolean = false) : ViewType {

    override fun getViewType(): Int  = ViewType.ITEM

}
