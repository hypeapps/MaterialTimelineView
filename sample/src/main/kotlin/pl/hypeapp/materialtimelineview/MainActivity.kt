package pl.hypeapp.materialtimelineview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import pl.hypeapp.materialtimelineview.adapter.TimelineRecyclerAdapter
import pl.hypeapp.materialtimelineview.model.CityWeather
import pl.hypeapp.materialtimelineview.model.Timepoint
import pl.hypeapp.materialtimelineview.model.Weather

class MainActivity : AppCompatActivity() {

    lateinit var timelineRecyclerAdapter: TimelineRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timelineRecyclerAdapter = TimelineRecyclerAdapter()
        recycler_view.adapter = timelineRecyclerAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        timelineRecyclerAdapter.addWeatherHeader(cityWeather)
        for (i in 0..5) {
            timelineRecyclerAdapter.addTimepoint(timepoints[i])
            timelineRecyclerAdapter.addWeather(weatherList[i])
        }
    }

    companion object FakeData {
        val cityWeather: CityWeather = CityWeather("Warsaw",
                "Sunny", 21.5f, "5%", "56%", "25km/h")

        val timepoints: ArrayList<Timepoint> = arrayListOf(
                Timepoint("Next 6 hours", "Sunny"),
                Timepoint("Next 24 hours", "Clear sky"),
                Timepoint("Next day", "Cloudy"),
                Timepoint("Next 2 days from now", "Rainy"),
                Timepoint("Next 3 days from now", "Sunny"),
                Timepoint("Next week", "Clear sky"))

        val weatherList: ArrayList<Weather> = arrayListOf(
                Weather("Today", "Sunny", 24f),
                Weather("Monday", "Clear sky", 22.2f),
                Weather("Tuesday", "Cloudy", 18.5f),
                Weather("Wednesday", "Rain fall", 18f),
                Weather("Thursday", "Sunny", 21.5f),
                Weather("Monday", "Sunny and clear sky", 24.7f, isLastItem = true)
        )

    }
}
