def check(park, mat, i, j):
    for x in range(i, i + mat):
        for y in range(j, j + mat):
            if x >= n or y >= m or park[x][y] != '-1':
                return 0
    return 1

def spread(park, mat):
    for i in range(n):
        for j in range(m):
            if park[i][j] != '-1':
                continue
            if check(park, mat, i, j):
                answer.append(mat)
                return

def solution(mats, park):
    global n, m, answer
    
    n, m = len(park), len(park[0])
    
    answer = []
    for mat in mats:
        spread(park, mat)
    return max(answer) if answer else -1