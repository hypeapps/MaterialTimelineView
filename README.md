# MaterialTimelineView [![Build Status](https://travis-ci.org/hypeapps/MaterialTimelineView.svg?branch=master)](https://travis-ci.org/hypeapps/MaterialTimelineView) [![Download](https://api.bintray.com/packages/hypeapps/maven/MaterialTimelineView/images/download.svg)](https://bintray.com/hypeapps/maven/MaterialTimelineView/_latestVersion)  [![Platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com) [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) [![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-MaterialTimelineView-green.svg?style=flat )]( https://android-arsenal.com/details/1/6347 )
With MaterialTimelineView you can easily create a material looking timeline.

![Banner](https://github.com/hypeapps/MaterialTimelineView/blob/master/img/material_timeline_banner.png?raw=true)
<a href="https://play.google.com/store/apps/details?id=pl.hypeapp.materialtimelinesample" target="_blank">
<img src="https://play.google.com/intl/en_us/badges/images/generic/en-play-badge.png" alt="Get it on Google Play" height="90"/></a>

# Setup
The library is pushed to jCenter() as an AAR, 
so you just need to add the following to your ***build.gradle*** file:

```groovy

dependencies {
    implementation 'pl.hypeapp:materialtimelineview:1.0'
}

```

# Usage
#### MaterialTimelineView extends from ConstraintLayout, so it has all of its possibilities.
[A sample of simple recycler view that demonstrates usage of library](https://github.com/hypeapps/MaterialTimelineView/tree/master/sample)
#### In your xml layout add:
```xml
<pl.hypeapp.materialtimelineview.MaterialTimelineView
        android:id="@+id/material_timeline_view"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        android:background="@android:color/holo_orange_light"
        app:timeline_top_radio_color="@android:color/white"
        app:timeline_bottom_radio_color="@android:color/white"
        app:timeline_line_color="@android:color/white"
        app:timeline_type="item"
        app:timeline_position="first"                                              
        app:timeline_margin_start="32dp"
        app:timeline_radio_outline_radius="20"
        app:timeline_radio_radius="12">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="HELLO WORLD"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"/>

</pl.hypeapp.materialtimelineview.MaterialTimelineView>      
```
#### or programatically:
```kotlin
val materialTimelineView: MaterialTimelineView = findViewById(R.id.material_timeline_view)
materialTimelineView.position = MaterialTimelineView.POSITION_FIRST // Default MaterialTimelineView.POSITION_FIRST
materialTimelineView.timelineType = MaterialTimelineView.TIMELINE_TYPE_ITEM // Default MaterialTimelineView.TIMELINE_TYPE_LINE
materialTimelineView.radioRadius = 14f // Default 12f
materialTimelineView.radioOutlineRadius = 22f // Default 22f
materialTimelineView.radioMarginStart = 100f // Default 150f
materialTimelineView.topRadioColor = Color.Black // Default Color.White
materialTimelineView.bottomRadioColor = Color.Black // Default Color.White
materialTimelineView.lineColor = Color.Black // Default Color.White
```
## Timeline types overview

<table>
    <th>Attributes</th>
    <th>Screen</th>
    <tr>
      <td>
        app:timeline_type="item" </br>
        app:timeline_position="first"
      </td>
      <td><img src="https://github.com/hypeapps/MaterialTimelineView/blob/master/img/item_first.png?raw=true" alt="item first" height="90"/></a></td>
    </tr>
    <tr>
        <td>
          app:timeline_type="item" </br>
          app:timeline_position="middle"
        </td>
        <td><img src="https://github.com/hypeapps/MaterialTimelineView/blob/master/img/item_middle.png?raw=true" alt="item middle" height="90"/></a></td>
    </tr>
    <tr>
        <td>
          app:timeline_type="item" </br>
          app:timeline_position="last"
        </td>
        <td><img src="https://github.com/hypeapps/MaterialTimelineView/blob/master/img/item_last.png?raw=true" alt="item last" height="90"/></a></td>
    </tr>
    <tr>
        <td>
          app:timeline_type="line" </br>
          app:timeline_position="first"
        </td>
        <td><img src="https://github.com/hypeapps/MaterialTimelineView/blob/master/img/line_first.png?raw=true" alt="line first" height="90"/></a></td>
    </tr>
     <tr>
        <td>
          app:timeline_type="line" </br>
          app:timeline_position="middle"
        </td>
        <td><img src="https://github.com/hypeapps/MaterialTimelineView/blob/master/img/line_middle.png?raw=true" alt="line middle" height="90"/></a></td>
    </tr>
    <tr>
        <td>
          app:timeline_type="line" </br>
          app:timeline_position="last"
        </td>
        <td><img src="https://github.com/hypeapps/MaterialTimelineView/blob/master/img/line_last.png?raw=true" alt="line last" height="90"/></a></td>
    </tr>
</table>

## Apps that use MaterialTimelineView
- [Episodie](https://github.com/hypeapps/episodie)

If you're using this library in your app and you'd like to list it here,
Please let me know via [email](mailto:pszem.szym@gmail.com), [pull requests](https://github.com/hypeapps/MaterialTimelineView/pulls) or [issues](https://github.com/hypeapps/MaterialTimelineView/issues).

## License
```
MIT License

Copyright (c) 2017 Przemysław Szymkowiak (pszem.szym@gmail.com)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
