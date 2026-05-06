//> using scala 3.3.1
//> using dep org.scalameta::munit::1.3.0

import scala.annotation.tailrec

@tailrec
def last(list: List[Int]): Option[Int] =
  list match
    case Nil          => None
    case x :: Nil     => Some(x)
    case x :: xs      => last(xs)

class Tests extends munit.FunSuite:
  test("given a non empty list then return last element"):
    val result = last(List(1, 1, 2, 3, 5, 8))
    assertEquals(result, Some(8))

  test("given an empty list then return None "):
    val result = last(Nil)
    assertEquals(result, None)


