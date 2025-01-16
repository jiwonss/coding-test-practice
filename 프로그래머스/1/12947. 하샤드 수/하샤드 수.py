def solution(x):
    harshad = sum(list(map(int, str(x))))
    return True if x % harshad == 0 else False