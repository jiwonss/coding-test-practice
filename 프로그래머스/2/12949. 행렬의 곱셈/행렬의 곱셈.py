def solution(arr1, arr2):
    answer = [[] for _ in range(len(arr1))]
    for i, a_col in enumerate(arr1):
        for b_row in zip(*arr2):
            answer[i].append(sum([a * b for a, b in zip(a_col, b_row)]))
    return answer