from sys import stdin
input = stdin.readline


def lotto(n, start):
    if n == 6:
        print(*result)
        return

    for i in range(start, k):
        if visited[i]:
            continue
        visited[i] = 1
        result[n] = S[i]
        lotto(n + 1, i + 1)
        visited[i] = 0


def solve():
    global k, S, result, visited

    while True:
        temp = list(map(int, input().split()))

        if temp[0] == 0:
            return

        k, S = temp[0], temp[1:]

        result, visited = [0] * 6, [0] * k
        lotto(0, 0)
        print()


if __name__ == "__main__":
    solve()
