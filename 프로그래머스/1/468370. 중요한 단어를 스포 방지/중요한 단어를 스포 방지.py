from bisect import bisect_left, bisect_right

def solution(message, spoiler_ranges):
    words = message.split(' ')
    starts, ends = [], []
    current = 0
    for word in words:
        starts.append(current)
        ends.append(current + len(word) - 1)
        current += len(word) + 1
    
    check = [0] * len(words)
    for start, end in spoiler_ranges:
        for i in range(bisect_left(ends, start), bisect_right(starts, end)):
            check[i] = 1
    
    non_spoiler_words = set()
    for i, word in enumerate(words):
        if not check[i]:
            non_spoiler_words.add(word)
            
    answer = 0
    spoiler_words = set()
    for i, word in enumerate(words):
        if check[i]:
            if word not in non_spoiler_words and word not in spoiler_words:
                answer += 1
                spoiler_words.add(word)       
    return answer