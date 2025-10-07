def solution(n, arr1, arr2):
    answer = []
    for a1, a2 in zip(arr1, arr2):
        answer.append(bin(a1|a2)[2:].zfill(n).replace("0", " ").replace("1", "#"))
    return answer