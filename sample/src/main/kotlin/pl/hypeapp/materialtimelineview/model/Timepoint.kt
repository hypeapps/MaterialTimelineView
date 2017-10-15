package pl.hypeapp.materialtimelineview.model

import pl.hypeapp.materialtimelineview.adapter.ViewType

data class Timepoint(val timepoint: String,
                     val description: String) : ViewType {

    override fun getViewType(): Int = ViewType.LINE

}
