//> using scala 3.3.1
//> using dep org.scalameta::munit::1.3.0

//Pack consecutive duplicates of list elements into sublists.: https://aperiodic.net/pip/scala/s-99/#p09

import scala.annotation.tailrec
import language.deprecated.symbolLiterals

def pack[A](list: List[Any]): List[Any] =
  list match {
    case (l:List[Any]) :: y :: ys if l.head == y => pack(((y::l))::ys)
    case (l:List[Any]) :: xs => l :: pack(xs)
    case x :: Nil => List(List(x))
    case x :: xs => pack(List(x) :: xs)
    case l:List[Any] => l
  }

class Tests extends munit.FunSuite:
  test("given an empty list return Nil"):
    assertEquals(pack(Nil), Nil)

  test("given an list with one element return a list with sublist"):
    assertEquals(pack(List('a')), List(List('a')))

  test("given an list with two elements return a list with sublists"):
    assertEquals(pack(List('a','b')), List(List('a'), List('b')))

  test("given input return expected"):
    val input = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val expected = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
    assertEquals(pack(input), expected)


