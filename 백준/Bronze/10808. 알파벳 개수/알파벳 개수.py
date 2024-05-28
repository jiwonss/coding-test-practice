from sys import stdin
input = stdin.readline


def solve():
    alphabet = [0] * 26

    word = input().strip()
    for w in word:
        alphabet[ord(w) - 97] += 1

    print(*alphabet)


if __name__ == "__main__":
    solve()
