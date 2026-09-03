def solution(s):   
    answer = 1
    for i in range(len(s)):
        left = right = i
        while left >= 0 and right < len(s) and s[left] == s[right]:
            answer = max(answer, right - left + 1)
            left -= 1
            right += 1

        left, right = i, i + 1
        while left >= 0 and right < len(s) and s[left] == s[right]:
            answer = max(answer, right - left + 1)
            left -= 1
            right += 1
    return answer