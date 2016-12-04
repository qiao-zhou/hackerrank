# -*- coding: utf-8 -*-
"""
Created on Sat Dec  3 22:30:27 2016

@author: Zhou Qiao

Polar Coordinates

Input:
1+2j

Output: 
2.23606797749979 
1.1071487177940904
"""
import cmath

number = complex(input())

pa = cmath.phase(number)
r = abs(number)

print(r)
print(pa)
