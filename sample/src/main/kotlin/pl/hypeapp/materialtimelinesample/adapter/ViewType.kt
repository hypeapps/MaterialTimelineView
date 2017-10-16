package pl.hypeapp.materialtimelinesample.adapter

interface ViewType {

    fun getViewType(): Int

    companion object {
        val HEADER = 1
        val LINE = 2
        val ITEM = 3
    }

}

