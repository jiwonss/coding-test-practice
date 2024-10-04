def solution(sequence):
    N = len(sequence)
    
    a, b = [(-1) ** x for x in range(N)], [(-1) ** (x + 1) for x in range(N)]
    
    a_arr, b_arr = [], []
    for i in range(N):
        a_arr.append(sequence[i] * a[i])
        b_arr.append(sequence[i] * b[i])
    
    a_sum, a_max_sum = a_arr[0], a_arr[0]
    b_sum, b_max_sum = b_arr[0], b_arr[0]
    for i in range(1, N):
        a_sum = max(a_arr[i], a_sum + a_arr[i])
        a_max_sum = max(a_max_sum, a_sum)
        b_sum = max(b_arr[i], b_sum + b_arr[i])
        b_max_sum = max(b_max_sum, b_sum)
        
    answer = max(a_max_sum, b_max_sum)
    return answer
    