def solution(n, words):
    check, count = {}, {i : 0 for i in range(n)}
    check[words[0]] = 1
    count[0] += 1
    
    for i in range(1, len(words)):
        idx, w = i % n, words[i]
        count[idx] += 1
        if check.get(w) or words[i][0] != words[i - 1][-1]:
            return [idx + 1, count[idx]]
        check[w] = 1
    return [0, 0]