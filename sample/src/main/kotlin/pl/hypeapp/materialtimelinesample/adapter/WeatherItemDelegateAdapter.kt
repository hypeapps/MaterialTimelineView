package pl.hypeapp.materialtimelinesample.adapter

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_weather.view.*
import pl.hypeapp.materialtimelinesample.R
import pl.hypeapp.materialtimelinesample.model.Weather
import pl.hypeapp.materialtimelineview.MaterialTimelineView

class WeatherItemDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = WeatherItemViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as WeatherItemViewHolder
        holder.bind(item as Weather)
    }

    inner class WeatherItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)) {

        fun bind(item: Weather) = with(itemView) {
            // If is last item we need to change position type to last.
            if (item.isLastItem) {
                item_weather_timeline.position = MaterialTimelineView.POSITION_LAST
            }
            date.text = item.date
            weather_description.text = item.weatherDescription
            temperature_degree.text = "${item.temperature}\u00b0"
            when (item.weatherDescription) {
                "Sunny" -> {
                    item_weather_timeline.setBackgroundColor(ContextCompat.getColor(context, R.color.sunny))
                    weather_icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_weather_sunny))
                }
                "Cloudy" -> {
                    item_weather_timeline.setBackgroundColor(ContextCompat.getColor(context, R.color.cloudy))
                    weather_icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_cloud))
                }
                "Rain fall" -> {
                    item_weather_timeline.setBackgroundColor(ContextCompat.getColor(context, R.color.rain))
                    weather_icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_rain))
                }
                "Clear sky" -> {
                    item_weather_timeline.setBackgroundColor(ContextCompat.getColor(context, R.color.clear))
                    weather_icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_clear))
                }
                "Windy" -> {
                    item_weather_timeline.setBackgroundColor(ContextCompat.getColor(context, R.color.clear))
                    weather_icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_windy))
                }
            }
        }

    }

}
