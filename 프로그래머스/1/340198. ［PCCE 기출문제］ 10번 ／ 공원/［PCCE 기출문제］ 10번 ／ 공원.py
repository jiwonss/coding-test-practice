def check(i, j, mat, park):
    for x in range(i, i + mat):
        for y in range(j, j + mat):
            if x >= n or y >= m or park[x][y] != '-1':
                return 0
    return 1


def solution(mats, park):
    global n, m
    
    n, m = len(park), len(park[0])
    
    answer = []
    for mat in mats:
        for i in range(n):
            for j in range(m):
                if park[i][j] != '-1':
                    continue
                if check(i, j, mat, park):
                    answer.append(mat)
                    break
    return max(answer) if answer else -1