from collections import deque

def solution(cacheSize, cities):
    cache, answer = deque(maxlen=cacheSize), 0
    for city in cities:
        city = city.lower()
        if city in cache:
            answer += 1
            cache.remove(city)
        else:
            answer += 5
        cache.append(city)
    return answer