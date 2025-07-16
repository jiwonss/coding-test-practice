def solution(cards):
    n = len(cards)
    visited, answer = [0] * n, [0]
    
    for i in range(n):
        if visited[i]:
            continue

        cnt, j = 0, cards[i] - 1
        while not visited[j]:
            visited[j] = 1
            j = cards[j] - 1
            cnt += 1
        answer.append(cnt)

    answer = sorted(answer)
    return answer[-1] * answer[-2]