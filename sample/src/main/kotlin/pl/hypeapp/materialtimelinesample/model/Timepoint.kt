package pl.hypeapp.materialtimelinesample.model

import pl.hypeapp.materialtimelinesample.adapter.ViewType

data class Timepoint(val timepoint: String,
                     val description: String) : ViewType {

    override fun getViewType(): Int = ViewType.LINE

}
