from sys import stdin
input = stdin.readline


def solve():
    temp = list(input().split())

    idx, n, arr = 0, int(temp[0]), []

    if len(temp) > 1:
        for t in temp[1:]:
            arr.append(int(t[::-1]))
            idx += 1

    while idx < n:
        temp = list(input().split())
        for t in temp:
            arr.append(int(t[::-1]))
            idx += 1

    for a in sorted(arr):
        print(a)


if __name__ == "__main__":
    solve()
