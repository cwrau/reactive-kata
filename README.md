# :leo: reactive kata

This kata is for use as introduction to reactive programming with kotlin and project reactor. The slides, which are a prerequisite for this dojo, are available [here](http://deen13.github.io/talks/reactive). 

## Problem Description
You have to wind up the project of your co-worker Jeff. The task is to build a dashboard for a foosball tournament. Jeff already implemented the connection to the foosball tables and a really slow and unstable dashboard. The datasource is the flux from the [tournament](https://github.com/socras/reactive-kata/blob/master/src/main/kotlin/de/smartsquare/dojo/reactive/tournament/Tournament.kt). 

## Exercises 
1. [Summarize](https://github.com/socras/reactive-kata/blob/master/src/main/kotlin/de/smartsquare/dojo/reactive/summarizer/StatisticsSummarizer.kt) the games streamed by the tournament per second in a [statistics](https://github.com/socras/reactive-kata/blob/master/src/main/kotlin/de/smartsquare/dojo/reactive/dashboard/Statistics.kt) object. 
2. Wire everything up by implementing the [adapter](https://github.com/socras/reactive-kata/blob/master/src/main/kotlin/de/smartsquare/dojo/reactive/summarizer/Adapter.kt) to the [dashboard](https://github.com/socras/reactive-kata/blob/master/src/main/kotlin/de/smartsquare/dojo/reactive/dashboard/Dashboard.kt). _Note: The dashboard is very unstable and thereforce timeouts and exceptions can occour randomly._


## Dataflow
![](https://image.ibb.co/mYwJpz/Untitled_Diagram_1.png)

