graph, profit_info = dict(), dict()

def dfs(seller, amount):
    if seller == '-': return
    referral = graph[seller]

    left = int(amount * 0.1)
    profit_info[seller] += amount - left
    
    if left == 0:
        return
    dfs(referral, left)
    
    
def solution(enroll, referral, seller, amount):
    # 등록인, 추천인
    person = set()
    for i, (a, b) in enumerate(zip(enroll, referral)):
        graph[a] = b
        person.add(a)
        person.add(b)
    
    for p in person:
        profit_info[p] = 0
    
    # 판매원, 판매량
    for s, a in zip(seller, amount):
        dfs(s, a * 100)

    return [profit_info[e] for e in enroll]