dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]

def solution(board, h, w):
    answer = 0
    n = len(board)
    for i in range(4):
        nx = h + dx[i]
        ny = w + dy[i]
        if 0 <= nx < n and 0 <= ny < n:
            if board[h][w] == board[nx][ny]:
                answer += 1
    return answer