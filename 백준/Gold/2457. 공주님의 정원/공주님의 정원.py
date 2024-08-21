from sys import stdin
input = stdin.readline


def solve():
    N = int(input())

    flower = []
    for _ in range(N):
        sm, sd, em, ed = map(int, input().split())
        flower.append([sm * 100 + sd, em * 100 + ed])

    cur, result = 301, 0
    while cur <= 1130:
        nxt = cur
        for i in range(N):
            if flower[i][0] <= cur and flower[i][1] > nxt:
                nxt = flower[i][1]
        if cur == nxt:
            print(0)
            return
        result += 1
        cur = nxt
    print(result)


if __name__ == "__main__":
    solve()
