from sys import stdin
input = stdin.readline

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]


def out_of_bounds(x, y):
    return not (0 <= x < N and 0 <= y < M)


def melt(melting_height):
    new_iceberg = []
    for k, v in melting_height.items():
        x, y = k
        board[x][y] = max(0, board[x][y] - v)
        if board[x][y]:
            new_iceberg.append([x, y])
    return new_iceberg


def dfs(iceberg):
    stack, visited = [], [[0] * M for _ in range(N)]
    melting_height = {(x, y): 0 for x, y in iceberg}

    stack.append(iceberg[0])
    visited[iceberg[0][0]][iceberg[0][1]] = 1

    selected_cnt = 0
    while stack:
        x, y = stack.pop()
        selected_cnt += 1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if out_of_bounds(nx, ny) or visited[nx][ny]:
                continue
            if board[nx][ny]:
                visited[nx][ny] = 1
                stack.append([nx, ny])
            else:
                melting_height[(x, y)] += 1

    new_iceberg = melt(melting_height)
    return [selected_cnt, new_iceberg]


def solve():
    global N, M, board

    N, M = map(int, input().split())

    board, iceberg = [], []
    for i in range(N):
        board.append(list(map(int, input().split())))
        for j in range(M):
            if board[i][j]:
                iceberg.append([i, j])

    result = 0
    while True:
        selected_cnt, new_iceberg = dfs(iceberg)

        if len(new_iceberg) == 0:
            print(0)
            return

        if selected_cnt != len(iceberg):
            break

        result += 1
        iceberg = new_iceberg
    print(result)


if __name__ == "__main__":
    solve()
