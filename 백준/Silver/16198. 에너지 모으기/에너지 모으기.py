from sys import stdin

input = stdin.readline


def dfs(energy):
    global result

    if len(w) == 2:
        result = max(result, energy)
        return

    for i in range(1, len(w) - 1):
        gained = w[i - 1] * w[i + 1]
        v = w.pop(i)
        dfs(energy + gained)
        w.insert(i, v)


def solve():
    global w, result

    N = int(input())
    w = list(map(int, input().split()))

    result = 0
    dfs(0)
    print(result)


if __name__ == "__main__":
    solve()
