def solution(numbers):
    str_numbers = list(map(str, numbers))
    answer = ''.join(sorted(str_numbers, key=lambda x : x * 3, reverse=True))
    return str(int(answer))