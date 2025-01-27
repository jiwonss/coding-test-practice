from heapq import heappush, heappop

def solution(k, score):
    heap, answer = [], []
    for i in range(len(score)):
        if i < k:
            heappush(heap, score[i])
        else:
            if heap[0] < score[i]:
                heappop(heap)
                heappush(heap, score[i])
        answer.append(heap[0])
    return answer