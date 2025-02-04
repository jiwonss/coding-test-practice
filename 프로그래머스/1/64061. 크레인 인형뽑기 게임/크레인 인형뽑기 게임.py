def solution(board, moves):
    zip_board = list(map(list, zip(*board)))
    stack, answer = [], 0
    for m in moves:
        i = m - 1
        for j in range(len(board)):
            if zip_board[i][j] != 0:
                if stack and stack[-1] == zip_board[i][j]:
                    stack.pop()
                    answer += 2
                else:
                    stack.append(zip_board[i][j])
                zip_board[i][j] = 0
                break
    return answer