package package_and_imports

package launch {
  class Booster3
}

package bobsrockets {
  package navigation {
    package launch {
      class Booster1
    }

    class MissionControll {
      val booster1 = new launch.Booster1
      val booster2 = new package_and_imports.bobsrockets.launch.Booster2
      val booster3 = new _root_.package_and_imports.launch.Booster3
    }

    private[bobsrockets] class Navigator {
      protected[navigation] def useStarChart() {}

      class LegOfJourney {
        private[Navigator] val distance = 100
      }

      private[this] var speed = 200

      // bobsrockets.navigation.StarMapと書かなくてよい
      val map = new StarMap
    }

    class StarMap
  }

  class Ship {
    // bobsrockets.navigation.Navigatorと書かなくてよい
    val nav = new navigation.Navigator
  }

  package fleets {
    class Fleet {
      // bobsrockets.Shipと書かなくてよい
      def addShip() { new Ship }
    }
  }

  package launch {
    import navigation._
    object Vehicle {
      private [launch] val guide = new Navigator
    }

    class Booster2
  }
}

