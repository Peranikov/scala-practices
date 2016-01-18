package package_and_imports

class Rocket {
  import Rocket.fuel
  private def canGoHomeAgain = fuel > 20

}

object Rocket {
  private def fuel = 10
  def chooseStrategy(rocket: Rocket): Unit = {
    if (rocket.canGoHomeAgain)
      goHome()
    else
      pickAStar()

    def goHome() {}
    def pickAStar() {}
  }
}
