import re
from enum import Enum
from btf import btf


def main():
    # class Color(Enum):
    #     Y: str = "Yellow"
    #     G: str = "Green"
    #     W: str = "White"
    #     R: str = "Red"
    #     B: str = "Blue"

    with open("input.txt", 'r') as f, open("output.int", 'w') as w:
        m, n = map(int, f.readlines()[0].split(","))
        f.seek(0)
        i, j = map(int, f.readlines()[1].split(","))
        f.seek(0)
        new_color = f.readlines()[2].strip("'\n")
        f.seek(0)
        matrix = [[str(cell) for cell in re.findall('\w+', line)] for line in f.readlines()[3:n+3]]

        btf(matrix, i, j, new_color, m, n)

        for row in matrix:
            print(row)
            w.write(f'{row}\n')


if __name__ == '__main__':
    main()

