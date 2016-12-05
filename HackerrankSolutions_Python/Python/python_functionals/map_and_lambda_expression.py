# -*- coding: utf-8 -*-
"""
Created on Sat Dec  3 22:50:37 2016

@author: Zhou Qiao

map-and-lambda-expression

Input:
5
Output: 
[0, 1, 1, 8, 27]
"""

n = int(input())

input_lst = range(n)

def fib(input_lst):
    fib_list = []
    for i in input_lst:
        if i < 2:
            fib_list.append(i)
        else:
            fib_list.append(fib_list[i-1]+fib_list[i-2])
    return fib_list
    
print(list(map(lambda x: x**3, fib(input_lst))))

        