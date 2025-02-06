def solution(numbers, hand):
    keypad = [[1, 4, 7, -1], [2, 5, 8, 0], [3, 6, 9, -1]]
    
    answer = ''
    left, right = [0, 3], [2, 3] # [0] : 0, 1, 2 | [1] : 0, 1, 2, 3
    for n in numbers:
        if n in keypad[0]:
            answer += 'L'
            left = [0, keypad[0].index(n)]
        if n in keypad[2]:
            answer += 'R'
            right = [2, keypad[2].index(n)]
        if n in keypad[1]:
            idx = keypad[1].index(n)
            left_dist = abs(1 - left[0]) + abs(left[1] - idx)
            right_dist = abs(1 - right[0]) + abs(right[1] - idx)
            if left_dist == right_dist:
                if hand == 'left':
                    answer += 'L'
                    left = [1, idx]
                else:
                    answer += 'R'
                    right = [1, idx]
            elif left_dist < right_dist:
                answer += 'L'
                left = [1, idx]
            else:
                answer += 'R'
                right = [1, idx]
    return answer