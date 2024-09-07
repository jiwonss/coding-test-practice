from sys import stdin
input = stdin.readline

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]


def out_of_bounds(x, y):
    return not (0 <= x < N and 0 <= y < M)


def create(k, x, y, total):
    global result

    if total + max_value * (4 - k) < result:
        return

    if k == 4:
        result = max(result, total)
        return

    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]
        if out_of_bounds(nx, ny) or visited[nx][ny]:
            continue
        if k == 2:
            visited[nx][ny] = 1
            create(k + 1, x, y, total + paper[nx][ny])
            visited[nx][ny] = 0
        visited[nx][ny] = 1
        create(k + 1, nx, ny, total + paper[nx][ny])
        visited[nx][ny] = 0


def solve():
    global N, M, paper, visited, max_value, result

    N, M = map(int, input().split())
    paper, max_value = [], 0
    for i in range(N):
        paper.append(list(map(int, input().split())))
        for j in range(M):
            max_value = max(max_value, paper[i][j])

    result = 0
    visited = [[0] * M for _ in range(N)]
    for x in range(N):
        for y in range(M):
            visited[x][y] = 1
            create(1, x, y, paper[x][y])
            visited[x][y] = 0
    print(result)


if __name__ == "__main__":
    solve()
