//> using scala 3.3.1
//> using dep org.scalameta::munit::1.3.0

//Flatten a nested list structure: https://aperiodic.net/pip/scala/s-99/#p07

import scala.annotation.tailrec

def flatten[A](list: List[Any]): List[Any] =
  list match {
    case x :: xs if x.isInstanceOf[List[Any]] => flatten(x.asInstanceOf[List[Any]]) ++ flatten(xs)
    case x :: xs => x:: flatten(xs)
    case n => n
  }

class Tests extends munit.FunSuite:
  test("given an empty list return Nil"):
    assertEquals(flatten(Nil), Nil)

  test("given a flat list return the same list"):
    assertEquals(flatten(List(1, 2, 3)), List(1, 2, 3))

  test("given a nested list return a flattened list"):
    val input = List(List(1, 1), 2, List(3, List(5, 8)))
    assertEquals(flatten(input), List(1, 1, 2, 3, 5, 8))

