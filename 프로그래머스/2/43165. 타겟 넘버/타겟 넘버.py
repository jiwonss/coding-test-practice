def dfs(numbers, target, k, total):
    global answer
    
    if k == len(numbers):
        if total == target:
            answer += 1
        return 
    
    dfs(numbers, target, k + 1, total + numbers[k])
    dfs(numbers, target, k + 1, total - numbers[k])
    
    
def solution(numbers, target):
    global answer
    
    answer = 0
    dfs(numbers, target, 0, 0)
    return answer