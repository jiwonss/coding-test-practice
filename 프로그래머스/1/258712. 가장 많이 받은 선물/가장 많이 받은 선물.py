def solution(friends, gifts):
    n = len(friends)
    friends_idx = {friends[i] : i for i, friend in enumerate(friends)}

    gifts_log = [[0] * n for _ in range(n)]
    for gift in gifts:
        a, b = gift.split()
        a_idx, b_idx = friends_idx[a], friends_idx[b]
        gifts_log[a_idx][b_idx] += 1
    
    gifts_index = [0] * n
    for i in range(n):
        give = sum(gifts_log[i])
        take = sum([gifts_log[j][i] for j in range(n)])
        gifts_index[i] = give - take 
    
    answer = [0] * n
    for i in range(n):
        for j in range(n):
            if gifts_log[i][j] < gifts_log[j][i]:
                continue
                
            if gifts_log[i][j] > gifts_log[j][i]:
                answer[i] += 1
            else:
                if gifts_index[i] > gifts_index[j]:
                    answer[i] += 1
    return max(answer)