def solution(s, skip, index):
    pattern = [chr(i) for i in range(ord('a'), ord('z') + 1) if chr(i) not in skip]
    
    n, answer = len(pattern), ''
    for c in s:
        answer += pattern[(pattern.index(c) + index) % n]
    return answer