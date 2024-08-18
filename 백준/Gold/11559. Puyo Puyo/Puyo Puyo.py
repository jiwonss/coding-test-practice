from sys import stdin
from collections import deque
input = stdin.readline

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]


def drop():
    for j in range(M):
        temp = []
        for i in range(N):
            if field[i][j] != '.':
                temp.append(field[i][j])
                field[i][j] = '.'
        if temp:
            for i in range(N - 1, -1, -1):
                if field[i][j] == '.':
                    field[i][j] = temp.pop()
                if not temp:
                    break


def delete():
    for x, y in delete_list:
        field[x][y] = '.'


def out_of_bounds(x, y):
    return not (0 <= x < N and 0 <= y < M)


def bfs(i, j):
    q.append([i, j])
    visited[i][j] = 1

    cnt, temp = 1, []
    while q:
        x, y = q.popleft()
        temp.append([x, y])
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if out_of_bounds(nx, ny):
                continue
            if visited[nx][ny] or field[nx][ny] != field[i][j]:
                continue
            cnt += 1
            visited[nx][ny] = 1
            q.append([nx, ny])
    return [cnt, temp]


def explode():
    global q, visited, delete_list

    is_explode = 0
    q, visited = deque(), [[0] * M for _ in range(N)]
    delete_list = []
    for i in range(N - 1, -1, -1):
        for j in range(M):
            if visited[i][j] or field[i][j] == '.':
                continue
            cnt, temp = bfs(i, j)
            if cnt >= 4:
                is_explode = 1
                delete_list.extend(temp)
    return is_explode


def solve():
    global N, M, field

    N, M = 12, 6
    field = [list(input().strip()) for _ in range(N)]

    result = 0
    while True:
        if not explode():
            break
        result += 1
        delete()
        drop()
    print(result)


if __name__ == "__main__":
    solve()
