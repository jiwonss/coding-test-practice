def solution(s):
    s = s[2:-2].split("},{")
    s = sorted([c.split(',') for c in s], key=lambda x : len(x))

    answer = []
    for c in s:
        diff = set(c) - set(answer)
        answer.append(diff.pop())
    return list(map(int, answer))