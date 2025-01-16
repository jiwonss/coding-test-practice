def solution(n):
    sqrt = n ** 0.5
    if (int(sqrt) == sqrt):
        return (int(sqrt) + 1) ** 2
    return -1