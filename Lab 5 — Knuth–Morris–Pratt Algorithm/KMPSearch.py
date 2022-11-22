def kmp(txt, pat) -> list[int] or int:
    lps = [0] * len(pat)
    result: list[int] = []
    j = 0
    i = 0

    compute_lps_array(pat, len(pat), lps)

    while i < len(txt):
        if pat[j] == txt[i]:
            i += 1
            j += 1

        if j == len(pat):
            result.append(i - j)
            j = lps[j - 1]

        elif i < len(txt) and pat[j] != txt[i]:
            if j != 0:
                j = lps[j - 1]
            else:
                i += 1
    if result:
        return result
    else:
        return -1


def compute_lps_array(pat, length, lps) -> None:
    lps[0]: list[int] = 0
    j: int = 0
    i: int = 1

    while i < length:
        if pat[i] == pat[j]:
            j += 1
            lps[i] = j
            i += 1
        else:
            if j != 0:
                j = lps[j - 1]
            else:
                lps[i] = 0
                i += 1
