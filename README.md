# Purpose

This mini project sketches out a poor idea for how to implement a 2D geometry
package.  The goal is to be able to define and manipulate shapes, performing
area calculations, point inclusion tests, etc. in a way that will work both in a
webapp and in the server.  This is technology we will need in order to implement
a Telescope Position Editor on the web.

Unfortunately I don't think the work presented here is viable so this is mostly
about soliciting feedback and praying that someone else has a better alternative.

# Implementation

The approach taken is to create a mini 2D geometry API and provide two
implementations.  The webapp implementation is backed with a JavaScript library
called [Paper.js](http://paperjs.org).  There may be better alternatives but my
survey lead me to believe that this one is the most complete (or at least most
familiar looking) library.  The server implementation is backed with Java2D.

The build is split in three parts

* `shared` - Simple platform-independent geometry API.
* `js` - Webapp implementation of the API backed by Paper.js.  This includes
a bit of a Paper.js facade and a trivial [`TestApp`](js/src/main/scala/edu/gemini/geom//testapp/TestApp.scala)
that illustrates how it could be used.
* `jvm` - A server-side implementation using Java 2D for completeness.

One tremendous problem with this idea is that [`Shape`](shared/src/main/scala/edu/gemini/geom/Shape.scala)
is parameterized so that operations like shape intersection can be easily made
to work.  This means that the type parameter has to be tracked by clients of
the API. 
 
# Alternative Approaches

Ideally an existing 2D geometry library in Scala would already exist and we
could just cross build it and use it, translating its idea of a Shape into
something we can draw with Paper.js or whatever.  If such a thing does exist, I
could not find it.  Barring that, we could also consider porting Java2D to pure
Scala. In addition to copyright issues (?) I counted 10,000 lines of code which seems
like a lot to create, test, and maintain.  There is an open source Java 2D
library called [JTS](http://tsusiatsoftware.net/jts/main.html) which is even
larger.



