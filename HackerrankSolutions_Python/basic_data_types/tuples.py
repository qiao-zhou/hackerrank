# -*- coding: utf-8 -*-
"""
Created on Sat Dec  3 19:13:28 2016

@author: Zhou Qiao

Tuples
"""

'''
Inputs: 
2
1 2
'''
n = int(input())

input_list = input().split()


input_list = map(int, input_list)

t = tuple(input_list)

t.__hash__()