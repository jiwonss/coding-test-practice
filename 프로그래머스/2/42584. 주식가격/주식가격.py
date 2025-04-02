def solution(prices):
    n = len(prices)
    stack, answer = [], [0] * n
    for i, price in enumerate(prices):
        while stack and stack[-1][1] > price:
            idx, p = stack.pop()
            answer[idx] = i - idx
        stack.append([i, price])
        
    while stack:
        idx, p = stack.pop()
        answer[idx] = n - idx - 1
    return answer