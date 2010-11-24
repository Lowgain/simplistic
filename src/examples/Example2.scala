/**
 * Simple test file used for experimentation at the console.
 */

import simplistic._
import simplistic.Query._
import simplistic.Conversions._

import simplistic._

val account = new SimpleDBAccount(System.getenv("AWS_ACCESS_KEY_ID"), System.getenv("AWS_SECRET_ACCESS_KEY"))

val data = account domain "data"

// make sure the domain exists at simpleDB
data.create()

// define some attributes
val user = attribute("user")
val startDate = attribute("startDate", ISO8610Date)
val visits = attribute("visits", PositiveInt)
val tags = attribute("tags")

// insert some items
data.unique += (user("robin"), startDate(new java.util.Date()), visits(3))
data.unique += (user("jon"), startDate(new java.util.Date()), visits(20))
data.unique += (user("alice"), startDate(new java.util.Date()), visits(15))
data.unique += (user("jack"), startDate(new java.util.Date()), visits(100))

// do some queries
for (i <- data (visits > 16)) { println(user(i).head) }

for (i <- data (visits > 16 and visits < 50)) { println(user(i).head) }

for (i <- data (visits > 1 and visits < 50 sort visits desc)) { println(user(i).head) }

// get rid of the test data
(data items) foreach (_.clear)
