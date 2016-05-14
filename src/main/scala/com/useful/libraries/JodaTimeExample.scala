package com.useful.libraries

import org.joda.time._
import org.joda.time.format.DateTimeFormat

/**
 * http://www.joda.org/joda-time/
 * Userguide: http://joda-time.sourceforge.net/userguide.html
 *
 * Joda-Time provides a quality replacement for the Java date and time classes.
 * Joda-Time is the de facto standard date and time library for Java prior to Java SE 8.
 *
 * “default” calendar is the ISO8601 standard which is used by many other standards.
 * The Gregorian, Julian, Buddhist, Coptic, Ethiopic and Islamic calendar systems are also included.
 * Supporting classes include time zone, duration, format and parsing.
 */
object JodaTimeExample extends App {

  val localDt = LocalDate.now()
  println(s"local Dt = ${localDt}")

  val currentDtTime = DateTime.now()
  println(s"Current DateTime = ${currentDtTime}")

  // define a custom format
  val fmt = DateTimeFormat.forPattern("yyyyMMdd")
  val myFormatDt = fmt.print(currentDtTime)
  println(s"Date in my format = ${myFormatDt}")

  // find days between two dates, inclusive of start
  val start = currentDtTime.minusDays(7) // Current date - 7 days
  val end = currentDtTime.plusDays(3) // current date + 3 days

  val myDays = (0 until Days.daysBetween(start, end).getDays).map { d =>
    fmt.print(start.plusDays(d))
  }
  println(s"Days between given dates are ${myDays}")
}
