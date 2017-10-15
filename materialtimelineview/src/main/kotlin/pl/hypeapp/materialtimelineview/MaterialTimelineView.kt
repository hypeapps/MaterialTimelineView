package pl.hypeapp.materialtimelineview

import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View

class MaterialTimelineView(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
    : ConstraintLayout(context, attrs, defStyleAttr) {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    var position: Int = POSITION_FIRST
        set(value) {
            field = value
            postInvalidate()
        }

    var timelineType: Int = TIMELINE_TYPE_LINE
        set(value) {
            field = value
            postInvalidate()
        }

    var radioRadius: Float = DEFAULT_RADIO_RADIUS
        set(value) {
            field = value
            postInvalidate()
        }

    var radioOutlineRadius: Float = DEFAULT_RADIO_OUTLINE_RADIUS
        set(value) {
            field = value
            postInvalidate()
        }

    var radioMarginStart: Float = DEFAULT_RADIO_MARGIN_START
        set(value) {
            field = value
            postInvalidate()
        }

    var topRadioColor: Int = Color.WHITE
        set(value) {
            field = value
            postInvalidate()
        }

    var bottomRadioColor: Int = Color.WHITE
        set(value) {
            field = value
            postInvalidate()
        }

    var lineColor: Int = Color.WHITE
        set(value) {
            field = value
            postInvalidate()
        }

    private val paint: Paint = Paint()

    private val xfermodeClear: PorterDuffXfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)

    init {
        setLayerType(View.LAYER_TYPE_HARDWARE, null)
        setWillNotDraw(false)
        paint.isAntiAlias = true
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.MaterialTimelineView)
            initAttrs(typedArray)
            typedArray.recycle()
        }
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        when (timelineType) {
            TIMELINE_TYPE_ITEM -> drawTimelineTypeItem(canvas)
            TIMELINE_TYPE_LINE -> drawTimelineTypeLine(canvas)
            else -> throw UnsupportedOperationException("Wrong timeline item type.")
        }
    }

    private fun drawTimelineTypeItem(canvas: Canvas) {
        val x = radioMarginStart
        var y = 0f
        when (position) {
            POSITION_FIRST -> {
                y = height.toFloat()
                drawRadioOutline(canvas, x, y)
                drawRadio(canvas, bottomRadioColor, x, y)
            }
            POSITION_MIDDLE -> {
                drawRadioOutline(canvas, x, y)
                drawRadio(canvas, topRadioColor, x, y)
                y = height.toFloat()
                drawRadioOutline(canvas, x, y)
                drawRadio(canvas, bottomRadioColor, x, y)
            }
            POSITION_LAST -> {
                drawRadioOutline(canvas, x, y)
                drawRadio(canvas, topRadioColor, x, y)
            }
        }
    }

    private fun drawTimelineTypeLine(canvas: Canvas) {
        val x = radioMarginStart
        val y = height.toFloat()
        when (position) {
            POSITION_FIRST -> {
                drawLine(canvas, x - radioRadius / 2, radioRadius, x + radioRadius / 2, y)
                drawRadio(canvas, topRadioColor, x, radioRadius)
                drawRadio(canvas, bottomRadioColor, x, y)
            }
            POSITION_MIDDLE -> {
                drawLine(canvas, x - radioRadius / 2, 0f, x + radioRadius / 2, y)
                drawRadio(canvas, topRadioColor, x, 0f)
                drawRadio(canvas, bottomRadioColor, x, y)
            }
            POSITION_LAST -> {
                drawLine(canvas, x - radioRadius / 2, 0f, x + radioRadius / 2, y - radioRadius)
                drawRadio(canvas, topRadioColor, x, 0f)
                drawRadio(canvas, bottomRadioColor, x, y - radioRadius)
            }
        }

    }

    private fun drawRadioOutline(canvas: Canvas, x: Float, y: Float) {
        paint.xfermode = xfermodeClear
        canvas.drawCircle(x, y, radioOutlineRadius, paint)
        paint.xfermode = null
    }

    private fun drawRadio(canvas: Canvas, color: Int, x: Float, y: Float) {
        paint.color = color
        canvas.drawCircle(x, y, radioRadius, paint)
    }

    private fun drawLine(canvas: Canvas, left: Float, top: Float, right: Float, bottom: Float) {
        paint.color = lineColor
        canvas.drawRect(left, top, right, bottom, paint)
    }

    private fun initAttrs(typedArray: TypedArray) {
        this.position = typedArray.getInteger(R.styleable.MaterialTimelineView_timeline_position, POSITION_FIRST)
        this.timelineType = typedArray.getInteger(R.styleable.MaterialTimelineView_timeline_type, TIMELINE_TYPE_LINE)
        this.radioRadius = typedArray.getFloat(R.styleable.MaterialTimelineView_timeline_radio_radius, DEFAULT_RADIO_RADIUS)
        this.radioOutlineRadius = typedArray.getFloat(R.styleable.MaterialTimelineView_timeline_radio_outline_radius, DEFAULT_RADIO_OUTLINE_RADIUS)
        this.radioMarginStart = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,
                typedArray.getDimension(R.styleable.MaterialTimelineView_timeline_margin_start, DEFAULT_RADIO_MARGIN_START),
                resources.displayMetrics)
        this.topRadioColor = typedArray.getColor(R.styleable.MaterialTimelineView_timeline_top_radio_color, Color.WHITE)
        this.bottomRadioColor = typedArray.getColor(R.styleable.MaterialTimelineView_timeline_bottom_radio_color, Color.WHITE)
        this.lineColor = typedArray.getColor(R.styleable.MaterialTimelineView_timeline_line_color, Color.WHITE)
    }

    companion object {
        val TIMELINE_TYPE_LINE = 0
        val TIMELINE_TYPE_ITEM = 1
        val POSITION_FIRST = 0
        val POSITION_MIDDLE = 1
        val POSITION_LAST = 2
        internal val DEFAULT_RADIO_RADIUS = 12f
        internal val DEFAULT_RADIO_OUTLINE_RADIUS = 20f
        internal val DEFAULT_RADIO_MARGIN_START = 150f
    }

}
