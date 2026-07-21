def solution(arr):
    
    def compression(x, y, n):
        if n == 1:
            answer[arr[x][y]] += 1
            return
        
        v, m = arr[x][y], n // 2
        for nx in range(n):
            for ny in range(n):
                if v != arr[x + nx][y + ny]:
                    compression(x, y, m)
                    compression(x + m, y, m)
                    compression(x, y + m, m)
                    compression(x + m, y + m, m)
                    return
        answer[v] += 1
                
    answer = [0, 0]
    compression(0, 0, len(arr))
    return answer