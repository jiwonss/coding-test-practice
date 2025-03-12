def solution(citations):
    citations.sort(reverse=True)
    return max(map(min, enumerate(citations, start=1)))