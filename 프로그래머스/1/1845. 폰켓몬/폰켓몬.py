def solution(nums):
    n = len(nums)
    return min(n // 2, len(set(nums)))