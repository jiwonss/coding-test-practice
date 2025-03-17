def adventure(k, dungeons):
    global answer
    answer = max(answer, sum(visited))

    for i in range(n):
        if visited[i] or k < dungeons[i][0]:
            continue
        visited[i] = 1
        adventure(k - dungeons[i][1], dungeons)
        visited[i] = 0
        
def solution(k, dungeons):
    global n, visited, answer
    n = len(dungeons)
    
    visited = [0] * n
    answer = 0
    adventure(k, dungeons)
    return answer