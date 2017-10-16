package pl.hypeapp.materialtimelinesample.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_weather_header.view.*
import pl.hypeapp.materialtimelinesample.R
import pl.hypeapp.materialtimelinesample.model.CityWeather

class WeatherHeaderItemDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = WeatherItemViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as WeatherItemViewHolder
        holder.bind(item as CityWeather)
    }

    inner class WeatherItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_weather_header, parent, false)) {

        fun bind(item: CityWeather) = with(itemView) {
            city.text = item.city
            weather_description.text = item.weatherDescription
            temperature_degree.text = "${item.temperature}\u00b0"
            rain_percentage.text = item.rainPercentage
            cloud_percentage.text = item.cloudyPercentage
            wind_speed.text = item.windSpeed
        }

    }

}
