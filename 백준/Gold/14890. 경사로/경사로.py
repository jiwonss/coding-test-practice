from sys import stdin

input = stdin.readline


def make(road):
    visited = [0] * N
    for x in range(N - 1):
        diff = road[x] - road[x + 1]
        if abs(diff) > 1:
            return 0
        if diff == 0:
            continue
        if diff < 0:
            y, cnt = x, 0
            while y >= 0 and road[y] == road[x]:
                cnt += 1
                if cnt == L:
                    break
                y -= 1
            else:
                return 0
            for i in range(cnt):
                idx = x - i
                if visited[idx]:
                    return 0
                visited[idx] = 1
        else:
            y, cnt = x + 1, 0
            while y < N and road[y] == road[x + 1]:
                cnt += 1
                if cnt == L:
                    break
                y += 1
            else:
                return 0
            for i in range(cnt):
                idx = x + i + 1
                if visited[idx]:
                    return 0
                visited[idx] = 1
    return 1


def solve():
    global N, L

    N, L = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]

    result = 0

    for b in board:
        if make(b):
            result += 1

    for b in zip(*board):
        if make(b):
            result += 1

    print(result)


if __name__ == "__main__":
    solve()
