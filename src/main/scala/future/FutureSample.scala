package future

import java.util.concurrent.ExecutionException

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object FutureSample extends App {
  val successFuture = Future(1)

  successFuture.onComplete {
    case Success(x) => println(s"successFuture is Success!")
    case Failure(t) => println(s"successFuture is Failure!")
  }

  val failedFuture = Future(throw new Exception("Exception!!"))

  failedFuture.onComplete {
    case Success(x) => println(s"failedFuture is Success!")
    case Failure(t) => println(s"failedFuture is Failure!")
  }

  val successful = Future.successful(new Exception("Exception!!"))

  successful.onComplete {
    case Success(x) => println(s"successful is Success!")
    case Failure(x) => println(s"successful is Failure!")
  }

  val failed = Future.failed(new Exception("Exception!!"))

  failed.onComplete {
    case Success(x) => println(s"failed is Success!")
    case Failure(x) => println(s"failed is Failure!")
  }


  Thread.sleep(2000)
}
