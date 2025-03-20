from sys import stdin

input = stdin.readline


def solve():
    N, C = map(int, input().split())
    message = list(input().split())

    counter = {}
    for i, m in enumerate(message):
        if not counter.get(m):
            counter[m] = [i, 1]
        else:
            counter[m][1] += 1

    for c in sorted(counter.items(), key=lambda x: (-x[1][1], x[1][0])):
        print((c[0] + " ") * c[1][1], end="")


if __name__ == "__main__":
    solve()
