from sys import stdin
from copy import deepcopy
input = stdin.readline


def up(board):
    for y in range(N):
        p = 0
        for x in range(1, N):
            if board[x][y]:
                v = board[x][y]
                board[x][y] = 0
                if board[p][y] == 0:
                    board[p][y] = v
                else:
                    if board[p][y] == v:
                        board[p][y] *= 2
                        p += 1
                    else:
                        p += 1
                        board[p][y] = v
    return board


def down(board):
    for y in range(N):
        p = N - 1
        for x in range(N - 2, -1, -1):
            if board[x][y]:
                v = board[x][y]
                board[x][y] = 0
                if board[p][y] == 0:
                    board[p][y] = v
                else:
                    if board[p][y] == v:
                        board[p][y] *= 2
                        p -= 1
                    else:
                        p -= 1
                        board[p][y] = v
    return board


def left(board):
    for x in range(N):
        p = 0
        for y in range(1, N):
            if board[x][y]:
                v = board[x][y]
                board[x][y] = 0
                if board[x][p] == 0:
                    board[x][p] = v
                else:
                    if board[x][p] == v:
                        board[x][p] *= 2
                        p += 1
                    else:
                        p += 1
                        board[x][p] = v
    return board


def right(board):
    for x in range(N):
        p = N - 1
        for y in range(N - 2, -1, -1):
            if board[x][y]:
                v = board[x][y]
                board[x][y] = 0
                if board[x][p] == 0:
                    board[x][p] = v
                else:
                    if board[x][p] == v:
                        board[x][p] *= 2
                        p -= 1
                    else:
                        p -= 1
                        board[x][p] = v
    return board


def move(board, k):
    if k == 5:
        return max(map(max, board))

    return max(
        move(up(deepcopy(board)), k + 1),
        move(down(deepcopy(board)), k + 1),
        move(left(deepcopy(board)), k + 1),
        move(right(deepcopy(board)), k + 1)
    )


def solve():
    global N, board

    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]

    result = move(board, 0)
    print(result)


if __name__ == "__main__":
    solve()
