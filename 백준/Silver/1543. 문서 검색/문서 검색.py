from sys import stdin

input = stdin.readline


def solve():
    docs = input().strip()
    word = input().strip()

    n, m = len(docs), len(word)

    idx, result = 0, 0
    while idx < n:
        if docs[idx : idx + m] == word:
            result += 1
            idx += m
        else:
            idx += 1
    print(result)


if __name__ == "__main__":
    solve()
