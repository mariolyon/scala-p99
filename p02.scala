//> using scala 3.3.1
//> using dep org.scalameta::munit::1.3.0

import scala.annotation.tailrec

@tailrec
def penultimate(list: List[Int]): Option[Int] =
  list match
    case Nil => None
    case x :: Nil => None
    case x :: y :: Nil => Some(x)
    case x :: xs => penultimate(xs)

class Tests extends munit.FunSuite:
  test("given an empty list return None"):
    assertEquals(penultimate(Nil), None)

  test("given a one element list return None"):
    assertEquals(penultimate(List(1)), None)

  test("given a list of two return the first element"):
    val result = penultimate(List(1, 2))
    assertEquals(result, Some(1))

  test("given a list longer than two return the penultimate element"):
    val result = penultimate(List(1, 1, 2, 3, 5, 8))
    assertEquals(result, Some(5))

