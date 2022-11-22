import unittest

from KMPSearch import kmp


class MyTestCase(unittest.TestCase):

    def test_kmp(self) -> None:
        with open("test/test1.txt") as file:
            text1: str = file.readline()
        with open("test/test2.txt") as file:
            text2: str = file.readline()
        with open("test/test3.txt") as file:
            text3: str = file.readline()

        result: list[int] = [i for i in range(0, 3152)]

        self.assertEqual(kmp(text1, "aaaaaaaaaaaaaaaaaaaaaaa"), result)
        self.assertEqual(kmp(text2, "abababababababababdf"), [162, 254])
        self.assertEqual(kmp(text3, "acaacaacaacadf"), [168, 260])
        self.assertEqual(kmp(text3, "xxxxxxxxxxxxxx"), -1)


if __name__ == '__main__':
    unittest.main()
