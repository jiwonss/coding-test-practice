def solution(A, B):
    A.sort()
    B.sort()
    
    idx, answer = 0, 0
    for i in range(len(A)):
        if A[idx] < B[i]:
            idx += 1
            answer += 1
    return answer