package pl.hypeapp.materialtimelineview

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hell.setOnClickListener {
            line.lineColor = Color.BLACK
            line.timelineType = MaterialTimelineView.TIMELINE_TYPE_ITEM
            line.bottomRadioColor = Color.GRAY
            line.topRadioColor = Color.RED
            line.radioRadius = 20f
            line.radioOutlineRadius = 28f
        }
    }
}
