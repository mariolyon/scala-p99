//> using scala 3.3.1
//> using dep org.scalameta::munit::1.3.0

//Eliminate consecutive duplicates of list elements.: https://aperiodic.net/pip/scala/s-99/#p08

import scala.annotation.tailrec

def compress[A](list: List[Any]): List[Any] =
  list match {
    case x :: y :: ys if x == y => compress(x :: ys)
    case x :: xs => x :: compress(xs)
    case n => n
  }

class Tests extends munit.FunSuite:
  test("given an empty list return Nil"):
    assertEquals(compress(Nil), Nil)

  test("given a compressed list return the same list"):
    assertEquals(compress(List(1, 2, 3)), List(1, 2, 3))

  test("given a list with duplicates return a compressed list"):
    val input = List(1, 1, 2, 1, 1, 3)
    assertEquals(compress(input), List(1, 2, 1, 3))


