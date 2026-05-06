//> using scala 3.3.1
//> using dep org.scalameta::munit::1.3.0

import scala.annotation.tailrec

@tailrec
def elem(k: Int, list: List[Int]): Option[Int] = {
  (k, list) match {
    case (n, Nil) => None
    case (0, x :: _) => Some(x)
    case (n, x :: xs) => elem(n - 1, xs)
  }
}

class Tests extends munit.FunSuite:
  test("given an empty list return None"):
    assertEquals(elem(0, Nil), None)

  test("given list of elements and k of 0 return first element"):
    assertEquals(elem(0, List(1)), Some(1))

  test("given list of elements, and k of length - 1 return last element"):
    assertEquals(elem(2, List(1, 2, 3)), Some(3))
