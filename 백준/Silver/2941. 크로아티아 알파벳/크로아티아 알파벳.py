from sys import stdin

input = stdin.readline


def solve():
    word = input().strip()

    croatia = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]

    for c in croatia:
        word = word.replace(c, ".")

    print(len(word))


if __name__ == "__main__":
    solve()
