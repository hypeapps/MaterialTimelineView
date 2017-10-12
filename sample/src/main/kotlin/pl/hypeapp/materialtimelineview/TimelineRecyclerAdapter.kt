package pl.hypeapp.materialtimelineview

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class TimelineRecyclerAdapter(val totalItemCount: Int,
                              viewItemDelegateAdapter: ViewTypeDelegateAdapter)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>

    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    private val loadingItem = object : ViewType {
        override fun getViewType(): Int = ViewType.LOADING
    }

    private val errorItem = object : ViewType {
        override fun getViewType(): Int = ViewType.ERROR
    }

    init {
//        delegateAdapters.put(ViewType.LOADING, LoadingDelegateAdapter())
//        delegateAdapters.put(ViewType.ITEM, viewItemDelegateAdapter)
//        delegateAdapters.put(ViewType.ERROR, ErrorDelegateAdapter(onRetryListener))
        items = ArrayList()
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType).onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, items[position])
    }

    override fun getItemViewType(position: Int) = items[position].getViewType()

}
