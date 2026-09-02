def solution(n, l, r):

    def count(n, left, right):
        if left > right:
            return 0
        
        if n == 1:
            return sum([1, 1, 0, 1, 1][left:right + 1])
        
        size, ones = 5 ** (n - 1), 4 ** (n - 1)
        answer = 0
        for i in range(5):
            start = i * size
            end = start + size - 1
            
            if right < start or left > end:
                continue
                
            if i == 2:
                continue
            
            if left <= start and right >= end:
                answer += ones
                continue
            
            next_left = max(left, start) - start
            next_right = min(right, end) - start

            answer += count(n - 1, next_left, next_right)
        return answer  
        
    return count(n, l - 1, r - 1)