import time

from KMPSearch import kmp


def main():
    print(kmp("ababcabcabababd", "ababd"))
    print(kmp("Some real text to show reliability of algo", "re"))
    print(kmp("Some real text to show reliability of algo", "axios"))


if __name__ == '__main__':
    start = time.process_time()
    main()
    end = time.process_time()
    print(end - start)
