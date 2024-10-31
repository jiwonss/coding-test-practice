from sys import stdin

input = stdin.readline


def solve():
    N = int(input())

    result = []
    for _ in range(N):
        s = input().strip()

        n, number = len(s), ""
        for i in range(n):
            if s[i].isdigit():
                number += s[i]
                if i == n - 1:
                    result.append(int(number))
            else:
                if number:
                    result.append(int(number))
                number = ""

    for r in sorted(result):
        print(r)


if __name__ == "__main__":
    solve()
