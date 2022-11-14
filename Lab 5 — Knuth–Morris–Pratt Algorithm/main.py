import time

from KMPSearch import KMPSearch


def main():
    txt = "ABABDABACDABABCABABi4432u2jkdnsfmdnsfjxsfjdnjandsjndajndjfndsjfhdsfbdsfbdshjfbdsnfdsjnbfsdhjbfdshfdsjhjfdsbhafdshbfdhbfdsfdjhsbfdjhbfdsoahdbhjfdnfldsbnjhlfdnbahfdbfhjdaanfdjlfdsjhfdsjfdsshfdhafdhjsahjafdshafhdsjsfdjfdhjjhdsjhkashhrewbiureihfefdsfjndsaklfdnsalmfkdnsalfkdnfdsklmanfdslafdnfldanjfdaijfndsiafdnjkdfnkdsjlndsf"
    pat = "ABABCABAB"
    KMPSearch(pat, txt)


if __name__ == '__main__':
    start = time.process_time()
    main()
    end = time.process_time()
    print(end-start)
