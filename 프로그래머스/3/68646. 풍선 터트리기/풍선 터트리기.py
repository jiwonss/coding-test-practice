def solution(a):
    if len(a) <= 2:
        return len(a)
    
    left, right = 0, len(a) - 1
    left_min, right_min = a[left], a[right]
    
    answer = 2
    while left + 1 < right:
        if left_min > right_min:
            left += 1
            if a[left] < left_min:
                left_min = a[left]
                answer += 1
        else:
            right -= 1
            if a[right] < right_min:
                right_min = a[right]
                answer += 1
    return answer