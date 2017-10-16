package pl.hypeapp.materialtimelinesample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import pl.hypeapp.materialtimelinesample.adapter.TimelineRecyclerAdapter
import pl.hypeapp.materialtimelinesample.model.CityWeather
import pl.hypeapp.materialtimelinesample.model.Timepoint
import pl.hypeapp.materialtimelinesample.model.Weather

class MainActivity : AppCompatActivity() {

    lateinit var timelineRecyclerAdapter: TimelineRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        timelineRecyclerAdapter = TimelineRecyclerAdapter()
        recycler_view.adapter = timelineRecyclerAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        timelineRecyclerAdapter.addWeatherHeader(cityWeather)
        for (i in 0..5) {
            timelineRecyclerAdapter.addTimepoint(timepoints[i])
            timelineRecyclerAdapter.addWeather(weatherList[i])
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_github) {
            val intent: Intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://github.com/hypeapps/MaterialTimelineView")
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
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
                Weather("Monday", "Windy", 19.7f, isLastItem = true)
        )

    }
}
