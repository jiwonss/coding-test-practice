from sys import stdin

input = stdin.readline


def get_ability(team):
    ability = 0
    for i in range(N // 2 - 1):
        for j in range(i + 1, N // 2):
            ability += S[team[i]][team[j]] + S[team[j]][team[i]]
    return ability


def diff(start, link):
    return abs(get_ability(start) - get_ability(link))


def assign(k, idx):
    global result

    if k == N // 2:
        start, link = [], []
        for i in range(N):
            if visited[i]:
                start.append(i)
            else:
                link.append(i)
        result = min(result, diff(start, link))
        return

    for i in range(idx, N):
        if visited[i]:
            continue
        visited[i] = 1
        assign(k + 1, i + 1)
        visited[i] = 0


def solve():
    global N, S, visited, result

    N = int(input())
    S = [list(map(int, input().split())) for _ in range(N)]

    visited, result = [0] * N, 1001
    assign(0, 0)
    print(result)


if __name__ == "__main__":
    solve()
