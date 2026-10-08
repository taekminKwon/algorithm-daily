def solution(a, b, n):
    answer = 0
    while n >= a:
        mod = n % a
        new = (n // a) * b
        answer += new
        n = new + mod
        
    return answer