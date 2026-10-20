n, m, k = map(int, input().split())
nums = list(map(int, input().split()))

# Please write your code here.
def dfs(turn):
    global result

    if turn == n:
        score = 0
        for p in position:
            if p >= m:
                score += 1

        result = max(result, score)
        return
    
    for i in range(k):
        if position[i] >= m:
            dfs(turn + 1)
            continue

        position[i] += nums[turn]
        dfs(turn + 1)
        position[i] -= nums[turn]

position, result = [1] * k, 0
dfs(0)
print(result)
